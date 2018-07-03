package application;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;


public class addProductController extends BasicScreen {

	public addProductController(){
	}
	
	@FXML
	private Pane addProductPane;

	protected Pane getPane(){
		return (Pane) addProductPane;
	}
	
	@FXML
	private void clickedCancelButton() {
		exitToMain();
	}
	
	protected Stage getStage() {
		return (Stage) addProductPane.getScene().getWindow();
	}
}