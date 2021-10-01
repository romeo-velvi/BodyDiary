package application;

import java.io.IOException;
import java.security.spec.ECFieldF2m;
import java.util.Iterator;

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

public class EffectiveHomeController implements GenericController {
	
	@FXML
	Label user_id_text;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private FXMLLoader loader;

	@FXML
	private LineChart<?, ?> chart1;
    @FXML
    private LineChart<?, ?> chart2;
    @FXML
    private LineChart<?, ?> chart3;
    @FXML
    private LineChart<?, ?> chart4;
    @FXML
    private LineChart<?, ?> chart5;
    @FXML
    private LineChart<?, ?> chart6;
    @FXML
    private LineChart<?, ?> chart7;
    @FXML
    private LineChart<?, ?> chart8;
    @FXML
    private LineChart<?, ?> chart9;

	
	
    @FXML
    public void initialize(){ // setta variabili al caricamento della pagina
		user_id_text.setText(UserData.getName());
		scene = user_id_text.getScene();
		// TODO foreach measurement, drow a line chart

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



	public void OnButtonInsertPressed(ActionEvent event) {
//		GenericController g = new ProxySingupController();
//		g.launch((Stage)((Node)event.getSource()).getScene().getWindow());
	}

	public void OnButtonAntropomPressed(ActionEvent event) {
//		GenericController g = new ProxySingupController();
//		g.launch((Stage)((Node)event.getSource()).getScene().getWindow());
	}

	public void OnButtonGoalsPressed(ActionEvent event) {
//		GenericController g = new ProxySingupController();
//		g.launch((Stage)((Node)event.getSource()).getScene().getWindow());
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