package br.edu.fema.academicofx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainViewController implements Initializable{
	@FXML
	private TextField tfMensagem;
	@FXML
	private Button btConfirmar;
	
	public MainViewController(){
		this.tfMensagem = null;
		this.btConfirmar = null;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		btConfirmar.setOnAction(onConfirmar);		
	}
	
	EventHandler<ActionEvent> onConfirmar = new EventHandler<ActionEvent>() {
		
		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			String msg = tfMensagem.getText();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Mensagem");
			alert.setContentText(msg);
			alert.showAndWait();
		}
	};
}
