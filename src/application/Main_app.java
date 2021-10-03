package application;
import database.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
 
@SuppressWarnings("unused")
public class Main_app extends Application {
    public static void main(String[] args) {
		
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
    	
		stage.setTitle("BodyDiary");
		Image logo = new Image(getClass().getResourceAsStream("../icons/icon.png"));
		stage.getIcons().add(logo);
		stage.setWidth(800);
		stage.setHeight(600);
		stage.setResizable(false);
		
//    	Parent root = FXMLLoader.load(getClass().getResource("../FXML/Start2.fxml")); 
//		Scene scene = new Scene(root);
//		stage.setScene(scene);
		
		
		GenericController g = new ProxyStartController();
		g.launch(stage);
		
		//stage.show();
		
    }


public static void populing() {
	DBdao db = new DerbydbClass();
	
	String 	name = "romeo";     
	String 	surname = "velvi";  
	String 	mail  = "admin";     
	String 	password = "admin"; 
	Date 	birt_date = Date.valueOf("2000-04-19");
	String 	gender = "male";   
	db.insertUserData(UserData.setInstance(name, surname, mail, password, birt_date, gender));
	 
	 Double weight	= 1.1	;    
		Double legs		= 1.1	;	  
		Double chest	= 1.1	; 	  
		Double height	= 1.1	; 	  
		Double forearms	= 1.1	;  
		Double biceps	= 1.1	; 	  
		Double hips		= 1.1	;	  
		Double waistline = 1.1	; 
		Double calfs	 = 1.1	; 	  
		Measurement mm = new Measurement(mail, weight, legs, chest, height, forearms, biceps, hips, waistline, calfs, Date.valueOf("2012-12-12"));
		db.insertUserMeasurement(mm);
		//2
		 weight	= 21.1	;    
		 legs		= 21.1	;	  
		 chest	= 21.1	; 	  
		 height	= 21.1	; 	  
		 forearms	= 21.1	;  
		 biceps	= 21.1	; 	  
		 hips		= 21.1	;	  
		 waistline = 21.1	; 
		 calfs	 = 21.1	; 	  
		mm = new Measurement(mail, weight, legs, chest, height, forearms, biceps, hips, waistline, calfs, Date.valueOf("2012-12-14"));
		db.insertUserMeasurement(mm);
		
		
		
		String tipo = "weight";         
		Date data_immissione  = (Goal.getCurrentTime());
		Double value_atteso = 12.3;
		Goal g=new Goal(mail, tipo, Date.valueOf("2012-12-12"), value_atteso);
		db.insertUserGoal(g);
		// 2
		 tipo = "height";         
		 data_immissione  = (Goal.getCurrentTime());
		 value_atteso = 21.1;
		 g=new Goal(mail, tipo, data_immissione, value_atteso);
		 db.insertUserGoal(g);
}

}



