package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EffectiveStartController implements GenericController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public Stage launch(Stage s) {
		this.stage = s;
		try {
			root = FXMLLoader.load(getClass().getResource("../FXML/Start2.fxml"));
		} catch (IOException e) {
			System.out.println("Problema lancio root: "+e);
			return null;
		}
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		return stage;
	}
	
	
	public void OnButtonLoginPressed(ActionEvent event) throws Exception {
		GenericController g = new ProxyLoginController();
		g.launch((Stage)((Node)event.getSource()).getScene().getWindow()); // ritorna stage corrente per farlo aggiornare
	}
	
	public void OnButtonSingupPressed(ActionEvent event) throws Exception {
		GenericController g = new ProxySingupController();
		g.launch((Stage)((Node)event.getSource()).getScene().getWindow()); // ritorna stage corrente per farlo aggiornare
	}
	
	
	
}