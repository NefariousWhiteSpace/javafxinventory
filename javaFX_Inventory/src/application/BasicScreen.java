package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

abstract class BasicScreen {
	
	protected Pane pane = new Pane();

	protected void switchScene(String xmlFile,int width,int height) {
		try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(xmlFile));
		Pane newPane = loader.load();
		Scene newScene = new Scene(newPane, width, height);
		getStage().setScene(newScene);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	protected Stage getStage() {
		return (Stage) getPane().getScene().getWindow();
	}
	
	abstract Pane getPane();
	
	protected void exitToMain() {
	switchScene("MainScreen.fxml",1100,600);
	}
	
	
}
