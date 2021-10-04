package application;

import java.io.IOException;
import java.sql.SQLException;

import database.DBdao;
import database.DerbydbClass;
import database.Measurement;
import database.UserData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class EffectiveAntropomController implements GenericController {

	DBdao db = new DerbydbClass();
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private FXMLLoader loader;

    @FXML
    private LineChart<?, ?> fatchart;
    @FXML
    private LineChart<?, ?> leanchart;
    @FXML
    private LineChart<?, ?> rvachart;
    @FXML
    private LineChart<?, ?> rvfcahrt;
	
	
    @FXML
    public void initialize(){ // setta variabili al caricamento della pagina
		// TODO foreach measurement, calculate and drow a line chart
		SetChart();
    }
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void SetChart() {
    	
    	database.Iterator it = null;
    	try {
			it = db.retreiveMeasure(UserData.getInstance().getMail());
		} catch (SQLException e) {
			System.out.println("Errore recezione misure: "+e);
			return;
		}
    	
    	XYChart.Series series1 = new XYChart.Series();   
    	XYChart.Series series2 = new XYChart.Series();   
    	XYChart.Series series3 = new XYChart.Series();   
    	XYChart.Series series4 = new XYChart.Series();   
    	
    	/* 
		 * Double weight, Double legs, 
		 * Double chest, Double height, 
		 * Double forearms, Double biceps
		 * Double hips, Double waistline, 
		 * Double calfs, Date d	
		 */	
    	
    	fatchart.setTitle("% fat mass");
    	leanchart.setTitle("% lean mass");
    	rvachart.setTitle("Waistline-Heigh ratio");
    	rvfcahrt.setTitle("Waistline-Hips ratio");
    	
    	
    	Measurement mes;
		while (it.hasNext()) {
			mes= (Measurement)it.next();
			series1.getData().add(new XYChart.Data(String.valueOf(mes.getDate()),calculateFatMass(UserData.getInstance().getGender(), mes.getWaistline(), mes.getLegs(), mes.getHips(), mes.getHeight())));
			series2.getData().add(new XYChart.Data(String.valueOf(mes.getDate()),calculateLeanMass(UserData.getInstance().getGender(), mes.getWeight(), mes.getHeight())));
			series3.getData().add(new XYChart.Data(String.valueOf(mes.getDate()),mes.getHeight()/mes.getHeight()));
			series4.getData().add(new XYChart.Data(String.valueOf(mes.getDate()),mes.getHeight()/mes.getHeight()));
			System.out.println(mes.toString());
		}
    	
		fatchart.getData().addAll(series1);
		leanchart.getData().addAll(series2);
		rvachart.getData().addAll(series3);
		rvfcahrt.getData().addAll(series4);
    	
    }
    
    private Double calculateFatMass(String gender, Double vita, Double gamba, Double fianchi, Double altezza) {
    	Double d = 0.0d;
    	if (gender.equals("female")) {
    		d = 495/(1.29579 - 0.35004*(Math.log(vita+fianchi-gamba)) + 0.22100 *(Math.log(altezza)))-450;
    		return d;
    	}
		d = 495/(1.0324 - 0.19077*(Math.log(vita-gamba)) + 0.15456*(Math.log(altezza)))-450;
    	return d;
    }
    
    private Double calculateLeanMass(String gender, Double peso, Double altezza) {
    	Double d = 0.0d;
    	if (gender.equals("female")) {
    		d = (1.10 * peso) - 128*(peso/(100*altezza)*2);
    		return d;
    	}
    	d = (1.07 * peso) - 148*(peso/(100*altezza)*2);
    	return d;
    }
    
    
	
	public Stage launch(Stage s) {
		this.stage = s;
		try {
			loader = new FXMLLoader(getClass().getResource("../FXML/Antropom2.fxml"));
			root = loader.load();
		} catch (IOException e) {
			System.out.println("Problema lancio root home: "+e);
			return null;
		}
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		return stage;
	}

	
    
    @FXML
    void OnButtonHomePressed(MouseEvent event) throws Exception {
    	GenericController g = new ProxyHomeController();
		g.launch((Stage)((Node)event.getSource()).getScene().getWindow());
    }

    @FXML
    void OnButtonHomePressed1(ActionEvent event) throws Exception {
    	GenericController g = new ProxyHomeController();
		g.launch((Stage)((Node)event.getSource()).getScene().getWindow());
    }

}