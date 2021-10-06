package application;

import javafx.stage.Stage;

public class LoginController implements GenericController{

	private Stage stage;
	
	public Stage launch(Stage s) throws Exception  {
		this.stage = s;
		GenericController ps = new EffectiveLoginController();
		preload();
		stage = ps.launch(stage);
		return stage;
	}
	
	private void preload() throws InterruptedException {
		System.out.println("Caricamento della pagina login");
		Thread.sleep(3);
	}

}