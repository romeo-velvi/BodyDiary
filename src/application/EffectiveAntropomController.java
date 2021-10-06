package application;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
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

    	
    	fatchart.setTitle("% fat mass");
    	leanchart.setTitle("% lean mass");
    	rvachart.setTitle("Waistline-Heigh ratio");
    	rvfcahrt.setTitle("Waistline-Hips ratio");
    	
    	
    	Measurement mes;
		while (it.hasNext()) {
			mes= (Measurement)it.next();
			series1.getData().add(new XYChart.Data(String.valueOf(mes.getDate()),calculateFatMass(UserData.getInstance().getGender(), mes.getWaistline(), mes.getThighs(), mes.getHips(), mes.getHeight(), mes.getWeight())));
			series2.getData().add(new XYChart.Data(String.valueOf(mes.getDate()),calculateLeanMass(UserData.getInstance().getGender(), mes.getWeight(), mes.getHeight())));
			series3.getData().add(new XYChart.Data(String.valueOf(mes.getDate()),mes.getHeight()/mes.getWaistline()));
			series4.getData().add(new XYChart.Data(String.valueOf(mes.getDate()),mes.getHeight()/mes.getHeight()));
			System.out.println(mes.toString());
		}
    	
		fatchart.getData().addAll(series1);
		leanchart.getData().addAll(series2);
		rvachart.getData().addAll(series3);
		rvfcahrt.getData().addAll(series4);
    	
    }
    
    private Double calculateFatMass(String gender, Double vita, Double gamba, Double fianchi, Double altezza, Double peso) {
    	Double d = 0.0d;
    	if (gender.equals("female")) {
    		d = (1.46*(peso/(altezza*altezza))) + (0.14* ( getDataDiff(UserData.getInstance().getBirt_date(), Measurement.getCurrentTime()))) - 10;
    		return d;
    	}
    	d = (1.46*(peso/(altezza*altezza))) + (0.14* ( getDataDiff(UserData.getInstance().getBirt_date(), Measurement.getCurrentTime()))) - 21.6;    	
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
    
    private int getDataDiff(Date bd, Date td) {
    	LocalDate k = bd.toLocalDate();
    	LocalDate x = td.toLocalDate();
    	int diff = Period.between(k, x).getYears();
    	return diff;
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
    	GenericController g = new HomeController();
		g.launch((Stage)((Node)event.getSource()).getScene().getWindow());
    }

    @FXML
    void OnButtonHomePressed1(ActionEvent event) throws Exception {
    	GenericController g = new HomeController();
		g.launch((Stage)((Node)event.getSource()).getScene().getWindow());
    }

}