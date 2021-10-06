package application;
import database.*;

import java.io.IOException;
import java.sql.Date;
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
	private TextField thighsx;
	
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

	@FXML
    void OnButtonHomePressed(MouseEvent event) throws Exception{
		GenericController g = new HomeController();
		g.launch((Stage)((Node)event.getSource()).getScene().getWindow());
    }

	@FXML
    void OnButtonHomePressed1(ActionEvent event) throws Exception{
    	GenericController g = new HomeController();
		g.launch((Stage)((Node)event.getSource()).getScene().getWindow());
    }
	
    @FXML
    void OnButtonInsertPressed(ActionEvent event) throws Exception{
    	Double biceps, calfs, chest, forearms, height, hips, thighs, waistline, weight ;
    	Date d;
    	
    	try {
	    	biceps    = Double.parseDouble(bicepsx.getText());      	
	    	calfs     = Double.parseDouble(calfsx.getText());      	
	    	chest     = Double.parseDouble(chestx.getText());    	
	    	forearms  = Double.parseDouble(forearmsx.getText());
	    	height    = Double.parseDouble(heightx.getText());
	    	hips      = Double.parseDouble(hipsx.getText());
	    	thighs      = Double.parseDouble(thighsx.getText());
	    	waistline = Double.parseDouble(waistlinex.getText());
	    	weight    = Double.parseDouble(weightx.getText());
	    	d		  = Measurement.getCurrentTime();
    	}catch (Exception e) {
			System.out.println("Problema importare dati: "+e);
			ops_text.setVisible(true);
			return;
		}  
    	ops_text.setVisible(false);
    	
    	
    	Measurement mm = new Measurement(UserData.getInstance().getMail(), weight, thighs, chest, height, forearms, biceps, hips, waistline, calfs, d);
    	
    	DBdao db = new DerbydbClass();
    	
    	db.insertUserMeasurement(mm);
    	
    	System.out.println(" Utente "+ UserData.getInstance().getName() +" ha inserito: "
    			+ "\n biceps   =" + mm.getMail()   
    			+ "\n calfs    =" + mm.getCalfs()    
    			+ "\n chest    =" + mm.getCalfs()    
    			+ "\n forearms =" + mm.getForearms() 
    			+ "\n height   =" + mm.getHeight()   
    			+ "\n hips     =" + mm.getHips()     
    			+ "\n thighs     =" + mm.getThighs()     
    			+ "\n waistline=" + mm.getWaistline()
    			+ "\n weight   =" + mm.getWeight()   
    			+ "\n il giorno = " + mm.getDate()
    			);
    	
    	GenericController g = new HomeController();
		g.launch((Stage)((Node)event.getSource()).getScene().getWindow());
    }
	
}