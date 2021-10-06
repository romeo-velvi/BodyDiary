package application;

import database.DBdao;
import database.DerbydbClass;
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
		}catch (Exception e) {
			System.out.println("Creazione tabelle: "+e);
		}
	}

}