package application;

import java.sql.Date;
import java.sql.SQLException;
import database.DBdao;
import database.DerbydbClass;
import database.Goal;
import database.Measurement;
import database.UserData;
import javafx.stage.Stage;

public class VirtualProxyStartController implements GenericController{

	private Stage stage;
	DBdao db = new DerbydbClass();
	
	public Stage launch(Stage s) throws Exception  {
		this.stage = s;
		EffectiveStartController ps = new EffectiveStartController();
		preload();
		stage = ps.launch(stage);
		return stage;
	}
	
	private void preload() throws InterruptedException {
		// COSA FARE PRIMA DEL CARICAMENTO DELLA PAGINA
		System.out.println("Caricamento della pagina start");
		Thread.sleep(3);
		try {
			db.createTables();
			population1();
			population2();
		}catch (Exception e) {
			System.out.println("Creazione tabelle: "+e);
		}
	}
	
	private void population1() throws SQLException {
		String nome, cognome, email, pass, gender, tipo; 
		Double weight, height, thigs, chest, forearms, biceps, hips, waistline, calfs, goal;
		Date d, birth, entro;
		
		UserData u = null; Measurement m = null; Goal g = null;
		
		nome = "Raffaele";
		cognome = "Motella";
		email = "raffmont@libero.it";
		pass = "30lode";
		gender = "male";
		birth = Date.valueOf("1981-04-25");
		u = new UserData(nome, cognome, email, pass, birth, gender);
		db.insertUserData(u);
		
		weight = 70.5;
		height = 1.7;
		thigs = 40.2;
		chest = 80.0;
		forearms = 30.0;
		biceps = 28.2;
		hips = 70.2;
		waistline = 80.4;
		calfs = 32.7;
		d = Date.valueOf("2021-09-01");
		m = new Measurement(email, weight, thigs, chest, height, forearms, biceps, hips, waistline, calfs, d);
		db.insertUserMeasurement(m);
		
		weight = 70.0;
		height = 1.72;
		thigs = 40.0;
		chest = 81.0;
		forearms = 40.0;
		biceps = 30.2;
		hips = 71.2;
		waistline = 40.4;
		calfs = 31.7;
		d = Date.valueOf("2021-09-02");
		m = new Measurement(email, weight, thigs, chest, height, forearms, biceps, hips, waistline, calfs, d);
		db.insertUserMeasurement(m);
		
		weight = 70.0;
		height = 1.7;
		thigs = 40.5;
		chest = 80.2;
		forearms = 30.4;
		biceps = 30.2;
		hips = 71.2;
		waistline = 81.4;
		calfs = 35.7;
		d = Date.valueOf("2021-09-03");
		m = new Measurement(email, weight, thigs, chest, height, forearms, biceps, hips, waistline, calfs, d);
		db.insertUserMeasurement(m);
		
		weight = 60.5;
		height = 1.8;
		thigs = 41.2;
		chest = 82.0;
		forearms = 24.0;
		biceps = 30.8;
		hips = 70.5;
		waistline = 81.4;
		calfs = 24.7;
		d = Date.valueOf("2021-09-04");
		m = new Measurement(email, weight, thigs, chest, height, forearms, biceps, hips, waistline, calfs, d);
		db.insertUserMeasurement(m);
		
		weight = 73.5;
		height = 1.7;
		thigs = 41.2;
		chest = 85.0;
		forearms = 36.0;
		biceps = 26.2;
		hips = 76.2;
		waistline = 86.4;
		calfs = 32.1;
		d = Date.valueOf("2021-09-05");
		m = new Measurement(email, weight, thigs, chest, height, forearms, biceps, hips, waistline, calfs, d);
		db.insertUserMeasurement(m);
		
		weight = 70.5;
		height = 1.7;
		thigs = 40.2;
		chest = 80.0;
		forearms = 30.0;
		biceps = 28.2;
		hips = 70.2;
		waistline = 80.4;
		calfs = 32.7;
		d = Date.valueOf("2021-09-06");
		m = new Measurement(email, weight, thigs, chest, height, forearms, biceps, hips, waistline, calfs, d);
		db.insertUserMeasurement(m);
		
		tipo = "chest";
		goal = 88.4;
		entro = Date.valueOf("2021-10-15");
		g = new Goal(email, tipo, entro, goal);
		db.insertUserGoal(g);
		
		tipo = "hips";
		goal = 60.4;
		entro = Date.valueOf("2021-10-20");
		g = new Goal(email, tipo, entro, goal);
		db.insertUserGoal(g);
	}
	
	private void population2() throws SQLException {
		String nome, cognome, email, pass, gender, tipo; 
		Double weight, height, thigs, chest, forearms, biceps, hips, waistline, calfs, goal;
		Date d, birth, entro;
		
		UserData u = null; Measurement m = null; Goal g = null;
		
		nome = "Angelo";
		cognome = "Ciaramella";
		email = "angielociaramella@outlook.it";
		pass = "trenta";
		gender = "male";
		birth = Date.valueOf("1978-03-25");
		u = new UserData(nome, cognome, email, pass, birth, gender);
		db.insertUserData(u);
		
		
		weight = 70.5;
		height = 1.7;
		thigs = 40.2;
		chest = 80.0;
		forearms = 30.0;
		biceps = 28.2;
		hips = 70.2;
		waistline = 80.4;
		calfs = 32.7;
		d = Date.valueOf("2021-09-06");
		m = new Measurement(email, weight, thigs, chest, height, forearms, biceps, hips, waistline, calfs, d);
		db.insertUserMeasurement(m);
		
		weight = 70.5;
		height = 1.7;
		thigs = 40.2;
		chest = 80.0;
		forearms = 30.0;
		biceps = 28.2;
		hips = 70.2;
		waistline = 80.4;
		calfs = 32.7;
		d = Date.valueOf("2021-09-01");
		m = new Measurement(email, weight, thigs, chest, height, forearms, biceps, hips, waistline, calfs, d);
		db.insertUserMeasurement(m);
		
		weight = 73.5;
		height = 1.7;
		thigs = 41.2;
		chest = 85.0;
		forearms = 36.0;
		biceps = 26.2;
		hips = 76.2;
		waistline = 86.4;
		calfs = 32.1;
		d = Date.valueOf("2021-09-05");
		m = new Measurement(email, weight, thigs, chest, height, forearms, biceps, hips, waistline, calfs, d);
		db.insertUserMeasurement(m);
		
		weight = 70.0;
		height = 1.7;
		thigs = 40.5;
		chest = 80.2;
		forearms = 30.4;
		biceps = 30.2;
		hips = 71.2;
		waistline = 81.4;
		calfs = 35.7;
		d = Date.valueOf("2021-09-03");
		m = new Measurement(email, weight, thigs, chest, height, forearms, biceps, hips, waistline, calfs, d);
		db.insertUserMeasurement(m);
		
		weight = 60.5;
		height = 1.8;
		thigs = 41.2;
		chest = 82.0;
		forearms = 24.0;
		biceps = 30.8;
		hips = 70.5;
		waistline = 81.4;
		calfs = 24.7;
		d = Date.valueOf("2021-09-04");
		m = new Measurement(email, weight, thigs, chest, height, forearms, biceps, hips, waistline, calfs, d);
		db.insertUserMeasurement(m);
		
		weight = 70.0;
		height = 1.72;
		thigs = 40.0;
		chest = 81.0;
		forearms = 40.0;
		biceps = 30.2;
		hips = 71.2;
		waistline = 40.4;
		calfs = 31.7;
		d = Date.valueOf("2021-09-02");
		m = new Measurement(email, weight, thigs, chest, height, forearms, biceps, hips, waistline, calfs, d);
		db.insertUserMeasurement(m);
		

		tipo = "chest";
		goal = 88.4;
		entro = Date.valueOf("2021-10-15");
		g = new Goal(email, tipo, entro, goal);
		db.insertUserGoal(g);
		
		tipo = "hips";
		goal = 60.4;
		entro = Date.valueOf("2021-10-20");
		g = new Goal(email, tipo, entro, goal);
		db.insertUserGoal(g);
	}

}