package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.control.TableColumn;


public class addPartController extends BasicScreen {
	
	public addPartController(){
	}
	
	private boolean inHouseSelected = false;
	@FXML
	private Text textCompanyName;
	@FXML
	private Text textMachineID;
	@FXML
	private TextField addPartCompanyNameField;
	@FXML
	private TextField addPartMachineIDField;
	@FXML
	private TextField addPartNameField;
	@FXML
	private TextField addPartInvField;
	@FXML 
	private TextField addPartPriceField;
	@FXML
	private TextField addPartMaxField;
	@FXML
	private TextField addPartMinField;
	

	//int,string.double,int,int,int,int
	@FXML
	private void clickedSaveButton() {
		if(inHouseSelected) {
			Inhouse newPart = new Inhouse(Main.mainInventory.getNewMaxPartID(), addPartNameField.getText(),  Double.parseDouble(addPartPriceField.getText()),Integer.parseInt(addPartInvField.getText()), Integer.parseInt(addPartMaxField.getText()), Integer.parseInt(addPartMinField.getText()), Integer.parseInt(addPartMachineIDField.getText()));
			Main.mainInventory.addPart(newPart);
		}else {
			Outsourced newPart = new Outsourced(Main.mainInventory.getNewMaxPartID(), addPartNameField.getText(),  Double.parseDouble(addPartPriceField.getText()),Integer.parseInt(addPartInvField.getText()), Integer.parseInt(addPartMaxField.getText()), Integer.parseInt(addPartMinField.getText()), addPartCompanyNameField.getText());
			Main.mainInventory.addPart(newPart);
		}
		exitToMain();
	}
	
	@FXML
	private Pane addPartPane;
	
	protected Pane getPane(){
		return (Pane) addPartPane;
	}
	
	@FXML
	private void clickedCancelButton() {
		exitToMain();
	}
	
	@FXML
	private void inHouseSelected(){
		textMachineID.setVisible(true);
		textCompanyName.setVisible(false);
		addPartMachineIDField.setVisible(true);
		addPartCompanyNameField.setVisible(false);
		inHouseSelected = true;
	}
	
	@FXML
	private void outsourcedSelected() {
		textMachineID.setVisible(false);
		textCompanyName.setVisible(true);
		addPartMachineIDField.setVisible(false);
		addPartCompanyNameField.setVisible(true);	
		inHouseSelected = false;
	}
	

	
}
