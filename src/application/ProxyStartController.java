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
	DBdao db = new DerbydbClass();
	
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
		try {
			db.createTables();
		}catch (Exception e) {
			System.out.println("Creazione tabelle: "+e);
		}
	}

}