package application;

import java.io.IOException;
import java.sql.Date;

import database.DBdao;
import database.DerbydbClass;
import database.UserData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EffectiveSingupController implements GenericController {
	
	@FXML
	TextField usr_name;
	@FXML
	TextField usr_surname;
	@FXML
	TextField usr_mail;
	@FXML
	DatePicker usr_bdate;
	@FXML
	ToggleGroup usr_sex;
	@FXML
	PasswordField usr_pass;
	@FXML
	Label ops_text;
	
	DBdao db = new DerbydbClass();
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public Stage launch(Stage s) {
		this.stage = s;
		try {
			root = FXMLLoader.load(getClass().getResource("../FXML/Registration2.fxml"));
		} catch (IOException e) {
			System.out.println("Problema lancio root: "+e);
			return null;
		}
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		return stage;
	}
	
	public void OnButtonSingupPressed(ActionEvent event) throws Exception {

		String name=null,surname=null,mail=null,pass=null,selsextext =null;
		Date d=null; ToggleButton selsex=null;
		
		//Convalidate Data
		try {
		name = usr_name.getText();
		surname =  usr_surname.getText();
		mail = usr_mail.getText();
		pass = usr_pass.getText();
		d = Date.valueOf(usr_bdate.getValue());
		selsex = (ToggleButton)usr_sex.getSelectedToggle();
		selsextext = selsex.getText();
		}
		catch (Exception e) {
			System.out.println("Valori nulli: "+e);
			ops_text.setText("Fields missing or incorrect");
			ops_text.setVisible(true);
			return;
		}
		
		System.out.println(
							"Tentativo di registrazione di:" 
							+name +" "
							+surname +" "
							+mail +" "
							+pass +" "
							+d +" "
							+selsextext+" "
						);

		UserData.erease();
		UserData ud = new UserData(name, surname, mail, pass, d, selsextext);
		
		if(db.insertUserData(ud)==false) {
			System.out.println("Problema inserimento nuovo utente");
			ops_text.setVisible(true);
			return;
		}
		
		// REDIRECTION TO HOME
		GenericController g = new ProxyLoginController();
		g.launch((Stage)((Node)event.getSource()).getScene().getWindow()); // ritorna stage corrente per farlo aggiornare
				
	}
	
	public void OnButtonSinginPressed(MouseEvent event) throws Exception {
		GenericController g = new ProxyLoginController();
		g.launch((Stage)((Node)event.getSource()).getScene().getWindow()); // ritorna stage corrente per farlo aggiornare
	}
	
}