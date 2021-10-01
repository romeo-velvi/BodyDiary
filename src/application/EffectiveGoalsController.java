package application;

import java.io.IOException;
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

public class EffectiveGoalsController implements GenericController {
	
	@FXML
	Label singup_text;
	@FXML
	TextField mail_field;
	@FXML
	PasswordField pass_field;
	@FXML
	Label ops_text;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public Stage launch(Stage s) {
		this.stage = s;
		try {
			root = FXMLLoader.load(getClass().getResource("../FXML/Goals2.fxml"));
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
		
		/*// CONTROL DATA
		if(user != "admin" && pass != "admin"){
			String errorm = ops_text.getText(); // to set error message: midded, mistake or connection problem
			ops_text.setText(errorm);
			ops_text.setVisible(true);
			return;
		}else {
			ops_text.setVisible(false);
		}*/
		
		// REDIRECTION TO HOME
		// TAKE ALL USERS DATA FROM DB
		String name = mail;
		String surname= mail;
		UserData.setMail(mail);
		UserData.setName(name);
		UserData.setSurname(surname);
		GenericController g = new ProxyHomeController();
		g.launch((Stage)((Node)event.getSource()).getScene().getWindow()); // ritorna stage corrente per farlo aggiornare
		
	}
	
	//TODO CAMBIARE ActionEvent con uno più appropriato al click del mouse
	public void OnButtonSingupPressed(MouseEvent event) throws Exception {
		GenericController g = new ProxySingupController();
		g.launch((Stage)((Node)event.getSource()).getScene().getWindow()); // ritorna stage corrente per farlo aggiornare
	}
	
}