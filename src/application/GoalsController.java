package application;


import javafx.stage.Stage;

public class GoalsController implements GenericController{

	private Stage stage;
	
	public Stage launch(Stage s) throws Exception  {
		this.stage = s;
		EffectiveGoalsController ps = new EffectiveGoalsController();
		preload();
		stage = ps.launch(stage);
		return stage;
	}
	
	private void preload() throws InterruptedException {
		System.out.println("Caricamento della pagina goals");
		Thread.sleep(3);
	}

}