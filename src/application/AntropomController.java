package application;


import javafx.stage.Stage;

public class AntropomController implements GenericController{

	private Stage stage;
	
	public Stage launch(Stage s) throws Exception  {
		this.stage = s;
		EffectiveAntropomController ps = new EffectiveAntropomController();
		preload();
		stage = ps.launch(stage);
		return stage;
	}
	
	private void preload() throws InterruptedException {
		System.out.println("Caricamento della pagina Antropom");
		Thread.sleep(3);
	}

}