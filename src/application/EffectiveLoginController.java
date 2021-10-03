package application;
import database.*;

import java.io.IOException;
import database.DerbydbClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EffectiveLoginController implements GenericController {
	
	@FXML
	Label singup_text;
	@FXML
	TextField mail_field;
	@FXML
	PasswordField pass_field;
	@FXML
	Label ops_text;
	
	private DBdao db = new DerbydbClass();
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public Stage launch(Stage s) {
		this.stage = s;
		try {
			root = FXMLLoader.load(getClass().getResource("../FXML/Login2.fxml"));
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
		//Convalidate Data
		String mail = mail_field.getText();
		String pass = pass_field.getText();
		System.out.println("Tentativo di accesso di: " + mail +" "+pass);
		Thread.sleep(2);
	
		if (this.db.checkUser(mail, pass)) {
			ops_text.setVisible(false);
			
		}else {
			//String errorm = ops_text.getText(); // to set error message: midded, mistake or connection problem
			//ops_text.setText(errorm);
			ops_text.setVisible(true);
			return;
		}
		
		// prendo dati utente loggato
		UserData ud = null;
		ud = db.retreiveUserData(mail, pass);
		UserData.setInstance(ud);
		
		GenericController g = new ProxyHomeController();
		g.launch((Stage)((Node)event.getSource()).getScene().getWindow()); // ritorna stage corrente per farlo aggiornare
		
	}
	
	public void OnButtonSingupPressed(MouseEvent event) throws Exception {
		GenericController g = new ProxySingupController();
		g.launch((Stage)((Node)event.getSource()).getScene().getWindow()); // ritorna stage corrente per farlo aggiornare
	}
	
}