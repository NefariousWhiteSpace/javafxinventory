package application;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


public class ModifyProductController extends BasicScreen {

	public ModifyProductController(){
	}
	
	@FXML
	private Pane modifyProductPane;
	@FXML
	private TextField modifyProductNameField;
	@FXML
	private TextField modifyProductInvField;
	@FXML
	private TextField modifyProductPriceField;
	@FXML
	private TextField modifyProductMaxField;
	@FXML
	private TextField modifyProductMinField;
	@FXML
	private TableView<Part> excludedPartTableView;
	@FXML
	private TableColumn<Part, String> excludedPartID;
	@FXML 
	private TableColumn<Part, String> excludedPartName;
	@FXML 
	private TableColumn<Part, String> excludedInventory;
	@FXML 
	private TableColumn<Part, String> excludedPrice;
	@FXML
	private TableView<Part> includedPartTableView;
	@FXML 
	private TableColumn<Part, String> includedPartID;
	@FXML 
	private TableColumn<Part, String> includedPartName;
	@FXML 
	private TableColumn<Part, String> includedInventory;
	@FXML 
	private TableColumn<Part, String> includedPrice;


	protected Pane getPane(){
		return (Pane) modifyProductPane;
	}

	@FXML
	private void clickedCancelButton() {
		exitToMain();
	}
	
	@FXML 
	void clickedSaveButton() {
		Main.mainInventory.getCurrentProduct().setName(modifyProductNameField.getText());
		Main.mainInventory.getCurrentProduct().setInStock(Integer.parseInt(modifyProductInvField.getText()));
		Main.mainInventory.getCurrentProduct().setPrice(Double.parseDouble(modifyProductPriceField.getText()));
		Main.mainInventory.getCurrentProduct().setMax(Integer.parseInt(modifyProductMaxField.getText()));
		Main.mainInventory.getCurrentProduct().setMin(Integer.parseInt(modifyProductMinField.getText()));
		exitToMain();
	}
	

	@FXML
	private void initialize(){
		modifyProductNameField.setText(Main.mainInventory.getCurrentProduct().getName());
		modifyProductInvField.setText(String.valueOf(Main.mainInventory.getCurrentProduct().getInStock()));
		modifyProductPriceField.setText(String.valueOf(Main.mainInventory.getCurrentProduct().getPrice()));
		modifyProductMaxField.setText(String.valueOf(Main.mainInventory.getCurrentProduct().getMax()));
		modifyProductMinField.setText(String.valueOf(Main.mainInventory.getCurrentProduct().getMin()));
		modifyProductNameField.setText(String.valueOf(Main.mainInventory.getCurrentProduct().getName()));
		
		excludedPartID.setCellValueFactory(cd -> cd.getValue().getPartIDProperty());	
		excludedPartName.setCellValueFactory(cd -> cd.getValue().getNameProperty());
		excludedInventory.setCellValueFactory(cd -> cd.getValue().getInStockProperty());
		excludedPrice.setCellValueFactory(cd -> cd.getValue().getPriceProperty());
		
		includedPartID.setCellValueFactory(cd -> cd.getValue().getPartIDProperty());	
		includedPartName.setCellValueFactory(cd -> cd.getValue().getNameProperty());
		includedInventory.setCellValueFactory(cd -> cd.getValue().getInStockProperty());
		includedPrice.setCellValueFactory(cd -> cd.getValue().getPriceProperty());

		excludedPartTableView.setItems(Main.mainInventory.getCurrentProduct().getExcludedPartObservableList());
		includedPartTableView.setItems(Main.mainInventory.getCurrentProduct().getIncludedPartObservableList());
	}
	
	@FXML
	private void clickedAddButton() {
		Main.mainInventory.getCurrentProduct().addAssociatedPart(Main.mainInventory.lookupPart(excludedPartTableView.getSelectionModel().getSelectedItem().getPartID()));
		System.out.println("clicked add");
		excludedPartTableView.setItems(Main.mainInventory.getCurrentProduct().getExcludedPartObservableList());
		includedPartTableView.setItems(Main.mainInventory.getCurrentProduct().getIncludedPartObservableList());
	}
	
	@FXML
	private void clickedDeleteButton() {
		Main.mainInventory.getCurrentProduct().removeAssociatedPart(includedPartTableView.getSelectionModel().getSelectedItem().getPartID());
		excludedPartTableView.setItems(Main.mainInventory.getCurrentProduct().getExcludedPartObservableList());
		includedPartTableView.setItems(Main.mainInventory.getCurrentProduct().getIncludedPartObservableList());
	}
	
}