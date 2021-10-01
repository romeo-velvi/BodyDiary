package application;

import java.io.IOException;


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

	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private FXMLLoader loader;

    @FXML
    private LineChart<?, ?> fatchart;
    @FXML
    private LineChart<?, ?> imcchart;
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
    	
    	//TODO RECUPERARE L'ITERATOR dei vari campi facendo una query al db
    	//	Passarle in formato series ed aggiungerli ai grafici
    	
    	int min = 10, max = 100;
    	
    	XYChart.Series series1 = new XYChart.Series();   	
    	series1.getData().add(new XYChart.Data(("2010/05/01"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series1.getData().add(new XYChart.Data(("2010/05/02"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series1.getData().add(new XYChart.Data(("2010/05/03"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series1.getData().add(new XYChart.Data(("2010/05/04"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series1.getData().add(new XYChart.Data(("2010/05/05"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series1.getData().add(new XYChart.Data(("2010/05/06"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series1.getData().add(new XYChart.Data(("2010/05/07"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series1.getData().add(new XYChart.Data(("2010/05/08"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series1.getData().add(new XYChart.Data(("2010/06/01"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series1.getData().add(new XYChart.Data(("2010/06/02"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	fatchart.getData().addAll(series1);
    	fatchart.setTitle("% fat mass");
    	
    	
    	XYChart.Series series2 = new XYChart.Series();  
    	series2.getData().add(new XYChart.Data(("2010/07/01"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series2.getData().add(new XYChart.Data(("2010/07/02"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series2.getData().add(new XYChart.Data(("2010/07/03"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series2.getData().add(new XYChart.Data(("2010/07/04"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series2.getData().add(new XYChart.Data(("2010/07/05"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series2.getData().add(new XYChart.Data(("2010/07/06"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series2.getData().add(new XYChart.Data(("2010/07/07"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series2.getData().add(new XYChart.Data(("2010/07/08"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series2.getData().add(new XYChart.Data(("2010/08/01"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series2.getData().add(new XYChart.Data(("2010/08/02"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	imcchart.getData().addAll(series2);
    	imcchart.setTitle("Body mass index");
    	
    	
    	XYChart.Series series3 = new XYChart.Series();  
    	series3.getData().add(new XYChart.Data(("2010/09/01"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series3.getData().add(new XYChart.Data(("2010/09/02"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series3.getData().add(new XYChart.Data(("2010/09/03"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series3.getData().add(new XYChart.Data(("2010/09/04"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series3.getData().add(new XYChart.Data(("2010/09/05"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series3.getData().add(new XYChart.Data(("2010/09/06"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series3.getData().add(new XYChart.Data(("2010/09/07"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series3.getData().add(new XYChart.Data(("2010/09/08"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series3.getData().add(new XYChart.Data(("2010/10/01"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series3.getData().add(new XYChart.Data(("2010/10/02"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	rvachart.getData().addAll(series3);
    	rvachart.setTitle("Waistline-Heigh ratio");
   
    	
    	XYChart.Series series4 = new XYChart.Series();  
    	series4.getData().add(new XYChart.Data(("2010/11/01"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series4.getData().add(new XYChart.Data(("2010/11/02"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series4.getData().add(new XYChart.Data(("2010/11/03"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series4.getData().add(new XYChart.Data(("2010/11/04"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series4.getData().add(new XYChart.Data(("2010/11/05"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series4.getData().add(new XYChart.Data(("2010/11/06"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series4.getData().add(new XYChart.Data(("2010/11/07"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series4.getData().add(new XYChart.Data(("2010/11/08"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series4.getData().add(new XYChart.Data(("2010/12/01"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series4.getData().add(new XYChart.Data(("2010/12/02"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	rvfcahrt.getData().addAll(series4);
    	rvfcahrt.setTitle("Waistline-Hips ratio");
    	
    	
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