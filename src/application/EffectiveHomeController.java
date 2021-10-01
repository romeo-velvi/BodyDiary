package application;

import java.io.IOException;
import java.security.spec.ECFieldF2m;
import java.sql.Date;
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
		user_id_text.setText(UserData.getName());
		scene = user_id_text.getScene();
		// TODO foreach measurement, drow a line chart
		SetLineChart();
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void SetLineChart() {
    	
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
    	chart1.getData().addAll(series1);
    	chart1.setTitle("Weight");
    	
    	
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
    	chart2.getData().addAll(series2);
    	chart2.setTitle("Legs");
    	
    	
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
    	chart3.getData().addAll(series3);
    	chart3.setTitle("Chest");
   
    	
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
    	chart4.getData().addAll(series4);
    	chart4.setTitle("Height");
    	
    	
    	XYChart.Series series5 = new XYChart.Series();   	
    	series5.getData().add(new XYChart.Data(("2010/05/01"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series5.getData().add(new XYChart.Data(("2010/05/02"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series5.getData().add(new XYChart.Data(("2010/05/03"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series5.getData().add(new XYChart.Data(("2010/05/04"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series5.getData().add(new XYChart.Data(("2010/05/05"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series5.getData().add(new XYChart.Data(("2010/05/06"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series5.getData().add(new XYChart.Data(("2010/05/07"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series5.getData().add(new XYChart.Data(("2010/05/08"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series5.getData().add(new XYChart.Data(("2010/06/01"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series5.getData().add(new XYChart.Data(("2010/06/02"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	chart5.getData().addAll(series5);
    	chart5.setTitle("Forearms");
    	
    	
    	XYChart.Series series6 = new XYChart.Series();        
    	series6.getData().add(new XYChart.Data(("2010/07/01"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series6.getData().add(new XYChart.Data(("2010/07/02"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series6.getData().add(new XYChart.Data(("2010/07/03"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series6.getData().add(new XYChart.Data(("2010/07/04"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series6.getData().add(new XYChart.Data(("2010/07/05"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series6.getData().add(new XYChart.Data(("2010/07/06"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series6.getData().add(new XYChart.Data(("2010/07/07"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series6.getData().add(new XYChart.Data(("2010/07/08"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series6.getData().add(new XYChart.Data(("2010/08/01"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series6.getData().add(new XYChart.Data(("2010/08/02"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	chart6.getData().addAll(series6);
    	chart6.setTitle("Biceps");
    	
    	
    	XYChart.Series series7 = new XYChart.Series();       
    	series7.getData().add(new XYChart.Data(("2010/09/01"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series7.getData().add(new XYChart.Data(("2010/09/02"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series7.getData().add(new XYChart.Data(("2010/09/03"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series7.getData().add(new XYChart.Data(("2010/09/04"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series7.getData().add(new XYChart.Data(("2010/09/05"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series7.getData().add(new XYChart.Data(("2010/09/06"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series7.getData().add(new XYChart.Data(("2010/09/07"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series7.getData().add(new XYChart.Data(("2010/09/08"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series7.getData().add(new XYChart.Data(("2010/10/01"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series7.getData().add(new XYChart.Data(("2010/10/02"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	chart7.getData().addAll(series7);
    	chart7.setTitle("Hips");
     	
    	
    	XYChart.Series series8 = new XYChart.Series();        
    	series8.getData().add(new XYChart.Data(("2010/11/01"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series8.getData().add(new XYChart.Data(("2010/11/02"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series8.getData().add(new XYChart.Data(("2010/11/03"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series8.getData().add(new XYChart.Data(("2010/11/04"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series8.getData().add(new XYChart.Data(("2010/11/05"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series8.getData().add(new XYChart.Data(("2010/11/06"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series8.getData().add(new XYChart.Data(("2010/11/07"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series8.getData().add(new XYChart.Data(("2010/11/08"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series8.getData().add(new XYChart.Data(("2010/12/01"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series8.getData().add(new XYChart.Data(("2010/12/02"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	chart8.getData().addAll(series8);
    	chart8.setTitle("Waistline");

    	
    	XYChart.Series series9 = new XYChart.Series();       
    	series9.getData().add(new XYChart.Data(("2010/11/01"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series9.getData().add(new XYChart.Data(("2010/11/02"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series9.getData().add(new XYChart.Data(("2010/11/03"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series9.getData().add(new XYChart.Data(("2010/11/04"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series9.getData().add(new XYChart.Data(("2010/11/05"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series9.getData().add(new XYChart.Data(("2010/11/06"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series9.getData().add(new XYChart.Data(("2010/11/07"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series9.getData().add(new XYChart.Data(("2010/11/08"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series9.getData().add(new XYChart.Data(("2010/12/01"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	series9.getData().add(new XYChart.Data(("2010/12/02"),(int)Math.floor(Math.random()*(max-min+1)+min)));
    	chart9.getData().addAll(series9);
    	chart9.setTitle("Calfs");
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
		//TODO Exit User
		GenericController g = new ProxyStartController();
		g.launch((Stage)((Node)event.getSource()).getScene().getWindow());
	}
	
}