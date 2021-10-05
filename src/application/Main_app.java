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
		
		GenericController g = new ProxyStartController();
		g.launch(stage);

    }
}



