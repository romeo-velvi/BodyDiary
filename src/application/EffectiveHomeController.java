package application;
import database.*;

import java.io.IOException;
import java.security.spec.ECFieldF2m;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

@SuppressWarnings("unused")
public class EffectiveHomeController implements GenericController {
	
	@FXML
	Label user_id_text;
	
	DBdao db = new DerbydbClass();
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private FXMLLoader loader;

	@FXML //peso
	private LineChart<?, ?> chart1; 
    @FXML //vita
    private LineChart<?, ?> chart2;
    @FXML //petto
    private LineChart<?, ?> chart3;
    @FXML //fianchi
    private LineChart<?, ?> chart4;
    @FXML //bicipiti
    private LineChart<?, ?> chart5;
    @FXML //polpacci
    private LineChart<?, ?> chart6;
    @FXML // cosce
    private LineChart<?, ?> chart7;
    @FXML //altezza
    private LineChart<?, ?> chart8;
    @FXML //avambracci
    private LineChart<?, ?> chart9;

	
	
    @FXML
    public void initialize(){ // setta variabili al caricamento della pagina
		user_id_text.setText(UserData.getInstance().getName());
		scene = user_id_text.getScene();
		SetLineChart();
				
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void SetLineChart() {
    
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
    	XYChart.Series series5 = new XYChart.Series();   
    	XYChart.Series series6 = new XYChart.Series();   
    	XYChart.Series series7 = new XYChart.Series();   
    	XYChart.Series series8 = new XYChart.Series();   
    	XYChart.Series series9 = new XYChart.Series();
  
    	
    	chart1.setTitle("Weight");
    	chart2.setTitle("Thigh");
    	chart3.setTitle("Chest");
    	chart4.setTitle("Height");
    	chart5.setTitle("Forearms");
    	chart6.setTitle("Biceps");
    	chart7.setTitle("Hips");
    	chart8.setTitle("Waistline");
    	chart9.setTitle("Calfs");
    	
    	
    	Measurement mes;
		while (it.hasNext()) {
			mes= (Measurement)it.next();
			series1.getData().add(new XYChart.Data(String.valueOf(mes.getDate()),mes.getWeight()));
			series2.getData().add(new XYChart.Data(String.valueOf(mes.getDate()),mes.getThighs()));
			series3.getData().add(new XYChart.Data(String.valueOf(mes.getDate()),mes.getChest()));
			series4.getData().add(new XYChart.Data(String.valueOf(mes.getDate()),mes.getHeight()));
			series5.getData().add(new XYChart.Data(String.valueOf(mes.getDate()),mes.getForearms()));
			series6.getData().add(new XYChart.Data(String.valueOf(mes.getDate()),mes.getBiceps()));
			series7.getData().add(new XYChart.Data(String.valueOf(mes.getDate()),mes.getHips()));
			series8.getData().add(new XYChart.Data(String.valueOf(mes.getDate()),mes.getWaistline()));
			series9.getData().add(new XYChart.Data(String.valueOf(mes.getDate()),mes.getCalfs()));
			System.out.println(mes.toString());
		}
    	
		chart1.getData().addAll(series1);
		chart2.getData().addAll(series2);
		chart3.getData().addAll(series3);
		chart4.getData().addAll(series4);
		chart5.getData().addAll(series5);
		chart6.getData().addAll(series6);
		chart7.getData().addAll(series7);
		chart8.getData().addAll(series8);
		chart9.getData().addAll(series9);
  
    }
	
	public Stage launch(Stage s) {
		this.stage = s;
		try {
			loader = new FXMLLoader(getClass().getResource("../FXML/Home2.fxml"));
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



	public void OnButtonInsertPressed(ActionEvent event) throws Exception {
		GenericController g = new ProxyInsertController();
		g.launch((Stage)((Node)event.getSource()).getScene().getWindow());
	}

	public void OnButtonAntropomPressed(ActionEvent event) throws Exception {
		GenericController g = new ProxyAntropomController();
		g.launch((Stage)((Node)event.getSource()).getScene().getWindow());
	}

	public void OnButtonGoalsPressed(ActionEvent event) throws Exception {
		GenericController g = new ProxyGoalsController();
		g.launch((Stage)((Node)event.getSource()).getScene().getWindow());
	}

	public void OnButtonDownloadPressed(ActionEvent event) throws Exception{
		GenericController g = new ProxyDownloadController();
		g.launch((Stage)((Node)event.getSource()).getScene().getWindow());
	}

	public void OnButtonExitPressed(MouseEvent event) throws Exception{
		UserData.erease();
		GenericController g = new ProxyStartController();
		g.launch((Stage)((Node)event.getSource()).getScene().getWindow());
		UserData.erease();
	}
	
}