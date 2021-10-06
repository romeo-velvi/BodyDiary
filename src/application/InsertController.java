package application;


import javafx.stage.Stage;

public class InsertController implements GenericController{

	private Stage stage;
	
	public Stage launch(Stage s) throws Exception  {
		this.stage = s;
		EffectiveInsertController ps = new EffectiveInsertController();
		preload();
		stage = ps.launch(stage);
		return stage;
	}
	
	private void preload() throws InterruptedException {
		System.out.println("Caricamento della pagina insert");
		Thread.sleep(3);
	}

}