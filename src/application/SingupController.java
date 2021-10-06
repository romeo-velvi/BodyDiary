package application;


import javafx.stage.Stage;

public class SingupController implements GenericController{

	private Stage stage;
	
	public Stage launch(Stage s) throws Exception  {
		this.stage = s;
		EffectiveSingupController ps = new EffectiveSingupController();
		preload();
		stage = ps.launch(stage);
		return stage;
	}
	
	private void preload() throws InterruptedException {
		System.out.println("Caricamento della pagina Registrazione");
		Thread.sleep(3);
	}

}