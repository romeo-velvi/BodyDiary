package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
    void OnButtonInsertPressed(ActionEvent event) {
    	//TODO inserimento dati nel DB
    	
    	Double biceps    = Double.parseDouble(bicepsx.getText());      	
    	Double calfs     = Double.parseDouble(calfsx.getText());      	
    	Double chest    =  Double.parseDouble(chestx.getText());    	
    	Double forearms  = Double.parseDouble(forearmsx.getText());
    	Double height    = Double.parseDouble(heightx.getText());
    	Double hips      = Double.parseDouble(hipsx.getText());
    	Double legs      = Double.parseDouble(legsx.getText());
    	Double waistline = Double.parseDouble(waistlinex.getText());
    	Double weight    = Double.parseDouble(weightx.getText());
    	       
    	System.out.println(" Utente ha inserito: "
    			+ "\n biceps   =" + biceps   
    			+ "\n calfs    =" + calfs    
    			+ "\n chest    =" + chest    
    			+ "\n forearms =" + forearms 
    			+ "\n height   =" + height   
    			+ "\n hips     =" + hips     
    			+ "\n legs     =" + legs     
    			+ "\n waistline=" + waistline
    			+ "\n weight   =" + weight   
    			+ "");
    }
	
}