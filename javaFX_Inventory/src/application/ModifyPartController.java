package application;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.text.*;
import javafx.scene.control.TextField;

public class ModifyPartController extends BasicScreen {


	@FXML
	private Text textCompanyName;
	@FXML
	private Text textMachineID;
	@FXML
	private TextField modifyPartCompanyNameField;
	@FXML
	private TextField modifyPartMachineIDField;
	@FXML
	private TextField modifyPartNameField;
	@FXML
	private TextField modifyPartInvField;
	@FXML
	private TextField modifyPartPriceField;
	@FXML
	private TextField modifyPartMaxField;
	@FXML
	private TextField modifyPartMinField;
	
	
	public ModifyPartController(){
	}
	
	@FXML
	private Pane modifyPartPane;
	
	protected Pane getPane(){
		return (Pane) modifyPartPane;
	}

	@FXML
	private void clickedCancelButton() {
		exitToMain();
	}
	
	@FXML void clickedSaveButton() {
		Main.mainInventory.getCurrentPart().setName(modifyPartNameField.getText());
		Main.mainInventory.getCurrentPart().setInStock(Integer.parseInt(modifyPartInvField.getText()));
		Main.mainInventory.getCurrentPart().setPrice(Double.parseDouble(modifyPartPriceField.getText()));
		Main.mainInventory.getCurrentPart().setMax(Integer.parseInt(modifyPartMaxField.getText()));
		Main.mainInventory.getCurrentPart().setMin(Integer.parseInt(modifyPartMinField.getText()));
		if(Main.mainInventory.getCurrentPart() instanceof Inhouse) {
			((Inhouse) Main.mainInventory.getCurrentPart()).setMachineID(Integer.parseInt(modifyPartInvField.getText()));
		}else if (Main.mainInventory.getCurrentPart() instanceof Outsourced)  {
			((Outsourced) Main.mainInventory.getCurrentPart()).setCompanyName(modifyPartCompanyNameField.getText());
		}
		exitToMain();
	}
	
	@FXML
	private void inHouseSelected(){
		textMachineID.setVisible(true);
		textCompanyName.setVisible(false);
		modifyPartMachineIDField.setVisible(true);
		modifyPartCompanyNameField.setVisible(false);
	}
	
	@FXML
	private void outsourcedSelected() {
		textMachineID.setVisible(false);
		textCompanyName.setVisible(true);
		modifyPartMachineIDField.setVisible(false);
		modifyPartCompanyNameField.setVisible(true);
	}
	
	@FXML
	private void initialize(){
		modifyPartNameField.setText(Main.mainInventory.getCurrentPart().getName());
		modifyPartInvField.setText(String.valueOf(Main.mainInventory.getCurrentPart().getInStock()));
		modifyPartPriceField.setText(String.valueOf(Main.mainInventory.getCurrentPart().getPrice()));
		modifyPartMaxField.setText(String.valueOf(Main.mainInventory.getCurrentPart().getMax()));
		modifyPartMinField.setText(String.valueOf(Main.mainInventory.getCurrentPart().getMin()));
		modifyPartNameField.setText(String.valueOf(Main.mainInventory.getCurrentPart().getName()));
		if( Main.mainInventory.getCurrentPart() instanceof Outsourced)
		{
		modifyPartCompanyNameField.setText(((Outsourced) Main.mainInventory.getCurrentPart()).getCompanyName());}
		if (Main.mainInventory.getCurrentPart() instanceof Inhouse) {
		modifyPartMachineIDField.setText(String.valueOf(((Inhouse) Main.mainInventory.getCurrentPart()).getMachineID()));}
	}
	
}