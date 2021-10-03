package application;


import java.sql.Date;
import java.sql.SQLException;

import database.DBdao;
import database.DerbydbClass;
import database.Goal;
import database.Measurement;
import database.UserData;
import javafx.stage.Stage;

public class ProxyStartController implements GenericController{

	private Stage stage;
	
	public Stage launch(Stage s) throws Exception  {
		this.stage = s;
		EffectiveStartController ps = new EffectiveStartController();
		preload();
		stage = ps.launch(stage);
		return stage;
	}
	
	private void preload() throws InterruptedException {
		System.out.println("Caricamento della pagina start");
		Thread.sleep(3);

		// ELIMINAREEEEEEEEEEEEEEEEEEEEEEE QUANDO SI HA FINITO
		startdbSAMPLE();
		
	}
	
	
	public void startdbSAMPLE() {
		try {
		DBdao db = new DerbydbClass();
		try {
			db.deleteAllTable();
		} catch (SQLException e) {
			System.out.println("Problema cancellare tabelle: "+e);
			return;
		}
		db.createTables();
		populing();
		} catch (Exception e) {
			System.out.println("ERRORE PROXY CREATION: "+e);
		}
	}
	
	public  void populing() {
		DBdao db = new DerbydbClass();
		
		String 	name = "romeo";     
		String 	surname = "velvi";  
		String 	mail  = "admin";     
		String 	password = "admin"; 
		Date 	birt_date = Date.valueOf("2000-04-19");
		String 	gender = "male";   
		try {
			db.insertUserData(UserData.setInstance(name, surname, mail, password, birt_date, gender));
		} catch (SQLException e) {
			System.out.println("problema inserimento dati: "+e);
		}
		 
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
			try {
				db.insertUserMeasurement(mm);
			} catch (SQLException e) {
				System.out.println("problema inserimento dati: "+e);
			}
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
			try {
				db.insertUserMeasurement(mm);
			} catch (SQLException e) {
				System.out.println("problema inserimento dati: "+e);
			}
			
			
			
			String tipo = "weight";         
			Date data_immissione  = (Goal.getCurrentTime());
			Double value_atteso = 12.3;
			Goal g=new Goal(mail, tipo, Date.valueOf("2012-12-12"), value_atteso);
			try {
				db.insertUserGoal(g);
			} catch (SQLException e) {
				System.out.println("problema inserimento dati: "+e);
			}
			// 2
			 tipo = "height";         
			 data_immissione  = (Goal.getCurrentTime());
			 value_atteso = 21.1;
			 g=new Goal(mail, tipo, data_immissione, value_atteso);
			 try {
				db.insertUserGoal(g);
			} catch (SQLException e) {
				System.out.println("problema inserimento dati: "+e);
			}
	}


}