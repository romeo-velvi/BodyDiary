package application;
import database.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.ListView;

@SuppressWarnings("unused")
public class EffectiveGoalsController implements GenericController {

	ObservableList<String> measure = FXCollections.observableArrayList();
	
	@FXML
    private ComboBox<String> choice_measure;
    @FXML
    private DatePicker expiration_date;
    @FXML
    private TextField goals_value;
	@FXML 
	Label ops_text;
	@FXML 
	ListView<String> list_goals;
    
	DBdao db = new DerbydbClass();
	
	private Stage stage;
	private Scene scene;
	private Parent root;
				
	public Stage launch(Stage s) {
		this.stage = s;
		try {
			root = FXMLLoader.load(getClass().getResource("../FXML/Goals2.fxml"));
		} catch (IOException e) {
			System.out.println("Problema lancio root goals: "+e);
			return null;
		}
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		return stage;
	}
	
	
	@FXML
    public void initialize(){ // setta variabili al caricamento della pagina
    	
    	loadChoiceBox();
    	
    	try {
			loadListGoals();
		} catch (SQLException e) {
			System.out.println("Errore generare lista goals: "+e);
		}

    }
	
	private void loadListGoals() throws SQLException {
		
		list_goals.getItems().clear();
		ObservableList<String> goals_elem = FXCollections.observableArrayList();
		goals_elem.removeAll(goals_elem);
		
		DBdao db = new DerbydbClass();
    	database.Iterator it = null;
    	try {
			it = db.retreiveGoal(UserData.getInstance().getMail());
		} catch (SQLException e) {
			System.out.println("Errore recezione goals: "+e);
			return;
		}
    	
    	Measurement m = db.getLastMeasurement(UserData.getInstance().getMail());
    	
    	Goal g; String s;
		while (it.hasNext()) {
			g= (Goal)it.next();
			g.updateGoal(m.getMeasureByType(g.getTipo()));
			
			s = 	"\t"
					+g.getTipo()
					+"\t\t\t\t"
					+g.getValue_atteso()
					+"\t\t\t\t"
					+m.getMeasureByType(g.getTipo())
					+"\t\t\t\t"
					+g.getStato()
					+"\t";
			
			System.out.println(s);
			goals_elem.add(s);
		}
		
		list_goals.getItems().addAll(goals_elem);
		
		/*
		Goal_old g1 =null,g2=null,g3=null,g4=null,g5=null,g6=null,g7=null;
		try {
			g1 = new Goal_old("biceps", Date.valueOf("2021-05-01"), 11.43  , 112.43);
			g2 = new Goal_old("calfs", Date.valueOf("2021-06-01"), 12.43  , 156.43);
			g3 = new Goal_old("height", Date.valueOf("2021-07-01"), 14.43 , 17.43);
			g4 = new Goal_old("legs", Date.valueOf("2021-08-01"), 15.43 , 137.43);
			g5 = new Goal_old("biceps", Date.valueOf("2021-08-01"), 17.43 , 17.43);
			g6 = new Goal_old("hips", Date.valueOf("2021-05-01"), 11.43 , 17.43);
			g7 = new Goal_old("weight", Date.valueOf("2021-09-01"), 111.43 , 111.43);
		}
		catch (Exception e) {
			System.out.println("problem set list: "+e);
		}
		
		goals_elem.removeAll(goals_elem);
		
		goals_elem.add(g1.toString());
		goals_elem.add(g2.toString());
		goals_elem.add(g3.toString());
		goals_elem.add(g4.toString());
		goals_elem.add(g5.toString());
		goals_elem.add(g6.toString());
		goals_elem.add(g7.toString());
		list_goals.getItems().addAll(goals_elem);
		*/	
		
	}
	
	private void loadChoiceBox() {
		/* 
		 * Double weight, Double legs, 
		 * Double chest, Double height, 
		 * Double forearms, Double biceps
		 * Double hips, Double waistline, 
		 * Double calfs, Date d	
		 */	
		measure.removeAll(measure);
		measure.addAll(
				"weight",
				"legs",
				"chest",
				"height",
				"forearms",
				"biceps",
				"hips",
				"waistline",
				"calfs"
				);
    	choice_measure.setItems(measure);
	}
	
	
	public void OnButtonAddPressed(MouseEvent event) throws Exception {
		Goal ng = null;
		String type; Double x; Date dd;
		try {
			type = choice_measure.getValue();
			x = Double.parseDouble(goals_value.getText());
			dd = Goal.getCurrentTime();
		}catch (Exception e) {
			System.out.println("Errore goal: "+e);
			ops_text.setVisible(true);
			return;
		}
		ops_text.setVisible(false);
		
		ng = new Goal(UserData.getInstance().getMail(), type, dd, x);
		this.db.insertUserGoal(ng);
		
		System.out.println("l'utente "+UserData.getInstance().getName()+" in data "+ dd + " ha impostato "
		   	   	+ "di raggiungere " + x + " per " + type);
		loadListGoals();
	}
	
	public void OnButtonHomePressed(MouseEvent event) throws Exception {
		GenericController g = new ProxyHomeController();
		g.launch((Stage)((Node)event.getSource()).getScene().getWindow());
	}
	
	public void OnButtonHomePressed1(ActionEvent event) throws Exception {
		GenericController g = new ProxyHomeController();
		g.launch((Stage)((Node)event.getSource()).getScene().getWindow());
	}
}