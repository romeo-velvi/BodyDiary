package application;

import java.io.IOException;

import database.DBdao;
import database.DerbydbClass;
import database.UserData;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class EffectiveStartController implements GenericController {
	
	private DBdao db;
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML Label ops_text;
	@FXML Button login_button;
	@FXML Button singup_button;
	
    @FXML
    public void initialize(){
    	this.db = new DerbydbClass();
    	if(this.db.getConnection()==null) {
    		System.out.println("Problema connesione db ");
			ops_text.setVisible(true);
			login_button.setDisable(true);
			singup_button.setDisable(true);
    	}
    	
    }
	
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
		g.launch((Stage)((Node)event.getSource()).getScene().getWindow()); 
	}
	
	public void OnButtonSingupPressed(ActionEvent event) throws Exception {
		GenericController g = new ProxySingupController();
		g.launch((Stage)((Node)event.getSource()).getScene().getWindow());
	}
	
	
	
}