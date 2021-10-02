package application;

import java.io.IOException;
import java.sql.Date;
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
    	
    	loadListGoals();
    	
    	//TODO connessione db -> prendere goals -> controllare stato :
    	// stato = 1 -> riuscito
    	// stato = 2 -> non riuscito
    	// stato = 0 -> SI DEVE CONTROLLARE:
    		// se data_scadenza < data_oggi: stato -> in lavorazione
    		// se data_scandenza > data_oggi: -> non riuscito ; stato =2
    		// se data_obiettivo == data_oggi && se misura == misura_goal -> riucito ; stato =1
    			//altrimenti stato: non riuscito
    	//TODO ogni controllo di stato comporta un aggiornamento
    }
	
	private void loadListGoals() {
		ObservableList<String> goals_elem = FXCollections.observableArrayList();
		
		Goal g1 =null,g2=null,g3=null,g4=null,g5=null,g6=null,g7=null;
		try {
			g1 = new Goal("biceps", Date.valueOf("2021-05-01"), 11.43  , 112.43);
			g2 = new Goal("calfs", Date.valueOf("2021-06-01"), 12.43  , 156.43);
			g3 = new Goal("height", Date.valueOf("2021-07-01"), 14.43 , 17.43);
			g4 = new Goal("legs", Date.valueOf("2021-08-01"), 15.43 , 137.43);
			g5 = new Goal("biceps", Date.valueOf("2021-08-01"), 17.43 , 17.43);
			g6 = new Goal("hips", Date.valueOf("2021-05-01"), 11.43 , 17.43);
			g7 = new Goal("weight", Date.valueOf("2021-09-01"), 111.43 , 111.43);
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
	}
	
	private void loadChoiceBox() {
		measure.removeAll(measure);
		measure.addAll(
				"biceps",
				"calfs",
				"chest",
				"forearms",
				"height",
				"hips",
				"legs",
				"waistline",
				"weight"
				);
    	choice_measure.setItems(measure);
	}
	
	
	public void OnButtonAddPressed(MouseEvent event) throws Exception {
		String type; Double mm; DateTimeFormatter formatter; LocalDate date; Date dd;
		try {
		type = choice_measure.getValue();
		mm = Double.parseDouble(goals_value.getText());
		date = LocalDate.now();
		formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
		String text = date.format(formatter);
		LocalDate parsedDate = LocalDate.parse(text, formatter);
   	   	dd = Date.valueOf(parsedDate);
		}catch (Exception e) {
			System.out.println("Errore goal: "+e);
			ops_text.setVisible(true);
			return;
		}
		ops_text.setVisible(false);
		System.out.println("l'utente "+UserData.getName()+" in data "+ dd + " ha impostato "
		   	   	+ "di raggiungere " + mm + " per " + type);
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