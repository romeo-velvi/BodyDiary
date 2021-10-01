package application;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class EffectiveInsertController implements GenericController {
	
	@FXML
	private TextField bicepsx;
	
	@FXML
	private TextField calfsx;
	
	@FXML
	private TextField chestx;
	
	@FXML
	private TextField forearmsx;
	
	@FXML
	private TextField heightx;
	
	@FXML
	private TextField hipsx;
	
	@FXML
	private TextField legsx;
	
	@FXML
	private TextField waistlinex;
	
	@FXML
	private TextField weightx;
	
	
	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML Label ops_text;
	
	
	public Stage launch(Stage s) {
		this.stage = s;
		try {
			root = FXMLLoader.load(getClass().getResource("../FXML/Insert2.fxml"));
		} catch (IOException e) {
			System.out.println("Problema lancio root: "+e);
			return null;
		}
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		return stage;
	}
	
	//TODO CAMBIARE ActionEvent con uno più appropriato al click del mouse
	public void OnButtonSingupPressed(MouseEvent event) throws Exception {
		GenericController g = new ProxySingupController();
		g.launch((Stage)((Node)event.getSource()).getScene().getWindow()); // ritorna stage corrente per farlo aggiornare
	}
	
	
	@FXML
    void OnButtonHomePressed(MouseEvent event) throws Exception{
		GenericController g = new ProxyHomeController();
		g.launch((Stage)((Node)event.getSource()).getScene().getWindow());
    }

    @FXML
    void OnButtonHomePressed1(ActionEvent event) throws Exception{
    	GenericController g = new ProxyHomeController();
		g.launch((Stage)((Node)event.getSource()).getScene().getWindow());
    }

    @FXML
    void OnButtonInsertPressed(ActionEvent event) throws Exception{
    	//TODO inserimento dati nel DB
    	Double biceps, calfs, chest, forearms, height, hips, legs, waistline, weight ;
    	
    	try {
	    	biceps    = Double.parseDouble(bicepsx.getText());      	
	    	calfs     = Double.parseDouble(calfsx.getText());      	
	    	chest    =  Double.parseDouble(chestx.getText());    	
	    	forearms  = Double.parseDouble(forearmsx.getText());
	    	height    = Double.parseDouble(heightx.getText());
	    	hips      = Double.parseDouble(hipsx.getText());
	    	legs      = Double.parseDouble(legsx.getText());
	    	waistline = Double.parseDouble(waistlinex.getText());
	    	weight    = Double.parseDouble(weightx.getText());
    	}catch (Exception e) {
			System.out.println("Problema importare dati: "+e);
			ops_text.setVisible(true);
			return;
		}  
    	ops_text.setVisible(false);
    	
    	String nome_user = UserData.getName();
    	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    	   LocalDateTime now = LocalDateTime.now();
    	   Date d = Date.valueOf(dtf.format(now));
    	System.out.println(" Utente "+ nome_user +" ha inserito: "
    			+ "\n biceps   =" + biceps   
    			+ "\n calfs    =" + calfs    
    			+ "\n chest    =" + chest    
    			+ "\n forearms =" + forearms 
    			+ "\n height   =" + height   
    			+ "\n hips     =" + hips     
    			+ "\n legs     =" + legs     
    			+ "\n waistline=" + waistline
    			+ "\n weight   =" + weight   
    			+ " il giorno = " + d 
    			);
    	GenericController g = new ProxyHomeController();
		g.launch((Stage)((Node)event.getSource()).getScene().getWindow());
    }
	
}