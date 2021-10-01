package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class EffectiveDownloadController implements GenericController {
	
	
	@FXML
	ToggleGroup choice_download;
	@FXML
	ToggleButton pdf_id;
	@FXML
	ToggleButton doc_id;
	@FXML
	ImageView pdf_btn;
	@FXML
	ImageView doc_btn;
	
	private Stage window;
	private Scene scene;
	private Parent root;
	
	public Stage launch(Stage s) {
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		Image logo = new Image(getClass().getResourceAsStream("../icons/icon.png"));
		window.getIcons().add(logo);
		window.setTitle("Bodydiary");
		window.setWidth(400);
		window.setHeight(300);
		window.setResizable(false);
		try {
			root = FXMLLoader.load(getClass().getResource("../FXML/Download2.fxml"));
		} catch (IOException e) {
			System.out.println("Problema lancio root: "+e);
			return null;
		}
		scene = new Scene(root);
		window.setScene(scene);
		window.showAndWait();
		return null;
	}
	

	public void OnButtonDownloadPressed(ActionEvent event) {
		ToggleButton selformat = (ToggleButton)choice_download.getSelectedToggle();
		String format = selformat.getId();
		String tipo = null;
		if(format == pdf_id.getId()) {
			tipo="pdf";
		}else {
			tipo="doc";
		}
		System.out.println("L'utente ha scelto di scaricare il formato: "+tipo );
		return;
	}


	public void OnButtonBackPressed(ActionEvent event) throws Exception {
		window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.close();
	}


	public void OnButtonPDFpressed(MouseEvent event) {  PDFchecked();  }
	public void OnButtonPDFpressed1(ActionEvent event) {  PDFchecked();  }
	
	
	public void OnButtonDOCpressed(MouseEvent event){ DOCchecked();  }
	public void OnButtonDOCpressed1(ActionEvent event){ DOCchecked();  }
	
	
	public void PDFchecked() {
		Image pdf2 = new Image(getClass().getResourceAsStream("../icons/pdf2.png"));
		Image doc1 = new Image(getClass().getResourceAsStream("../icons/doc.png"));
		doc_btn.setImage(doc1);
		pdf_btn.setImage(pdf2);
		pdf_btn.setFitWidth(100);
		pdf_btn.setFitHeight(100);
	}

	public void DOCchecked() {
		Image pdf1 = new Image(getClass().getResourceAsStream("../icons/pdf.png"));
		Image doc2 = new Image(getClass().getResourceAsStream("../icons/doc2.png"));
		pdf_btn.setImage(pdf1);
		doc_btn.setImage(doc2);
		doc_btn.setFitWidth(100);
		doc_btn.setFitHeight(100);
	}
	
	
	
}