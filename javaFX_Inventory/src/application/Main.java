package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;



public class Main extends Application {
	
	static Inventory mainInventory = new Inventory();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
			Pane mainPane = loader.load();
			Scene mainScreenScene = new Scene(mainPane,1100,600);
			
//			mainScreenScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(mainScreenScene);
			primaryStage.show();
			Controller controller = new Controller();
			loader.setController(controller);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
		importData();
	}
	
	private static void importData() {
		//Populate test data
		PersistenceManager pm = new PersistenceManager();
		Inventory inventory = pm.getInventoryFromFile();
	}

}

