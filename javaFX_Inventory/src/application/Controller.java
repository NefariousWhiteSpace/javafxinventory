package application;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.scene.control.*;


public class Controller extends BasicScreen {
	

	@FXML
	private Parent mainPane;

	
	@FXML
	private TableView<Part> mainPartTable;
	@FXML
	private TableColumn<Part,String> mainPartNameColumn; 
	@FXML
	private TableColumn<Part,String> mainPartIDColumn;
	@FXML
	private TableColumn<Part,String> mainInventoryColumn;
	@FXML
	private TableColumn<Part,String> mainPriceColumn;
	@FXML
	private TableView<Product> mainProductTable;
	@FXML
	private TableColumn<Product,String> mainProductIDColumn;
	@FXML
	private TableColumn<Product,String> mainProductNameColumn;
	@FXML
	private TableColumn<Product,String> mainProductInventoryColumn;
	@FXML
	private TableColumn<Product,String> mainProductPriceColumn;
	
	
	@FXML
	private void mainPartSearchButtonClicked()
	{
		//TODO: Implement Search
		System.out.println("execute part search");
	}
	
	@FXML
	private void mainPartAddButtonClicked()
	{
		switchScene("addPart.fxml",600,550);
	}
	
	@FXML
	private void mainPartModifyButtonClicked()
	{
		Main.mainInventory.setCurrentPart(mainPartTable.getSelectionModel().getSelectedItem());
		switchScene("modifyPart.fxml",600,550);
	}
	
	@FXML
	private void mainPartDeleteButtonClicked()
	{
	//TODO: Delete product	
		System.out.println("Delete Part" + mainPartTable.getSelectionModel().getSelectedItem().getPartID());
		Main.mainInventory.deletePart(mainPartTable.getSelectionModel().getSelectedItem().getPartID());
		mainPartTable.setItems(Main.mainInventory.getPartObservableList());
	}
	
	@FXML
	private void mainProductSearchButtonClicked()
	{
		//TODO: Implement Search
		System.out.println("execute product search");
	}
	
	@FXML
	private void mainProductAddButtonClicked()
	{
		switchScene("addProduct.fxml",1200,700);
	}
	
	@FXML
	private void mainProductModifyButtonClicked()
	{
		Main.mainInventory.setCurrentProduct(mainProductTable.getSelectionModel().getSelectedItem());
		switchScene("modifyProduct.fxml",1200,700);
	}
	
	@FXML
	private void mainProductDeleteButtonClicked()
	{
		System.out.println("Delete Product" + mainProductTable.getSelectionModel().getSelectedItem().getProductID());
		Main.mainInventory.removeProduct(mainProductTable.getSelectionModel().getSelectedItem().getProductID());
		mainProductTable.setItems(Main.mainInventory.getProductObservableList());
	}
	
	@FXML
	private void mainExitButtonClicked(ActionEvent event)
	{
		System.exit(0);
	}
	
	@FXML
	private void initialize() {
		
		//Populate TableView nodes		
		mainPartIDColumn.setCellValueFactory(cd -> cd.getValue().getPartIDProperty());	
		mainPartNameColumn.setCellValueFactory(cd -> cd.getValue().getNameProperty());
		mainInventoryColumn.setCellValueFactory(cd -> cd.getValue().getInStockProperty());
		mainPriceColumn.setCellValueFactory(cd -> cd.getValue().getPriceProperty());
		mainPartTable.setItems(Main.mainInventory.getPartObservableList());
		
		//Populate TableView node for product
		mainProductIDColumn.setCellValueFactory(cd -> cd.getValue().getProductIDProperty());
		mainProductNameColumn.setCellValueFactory(cd -> cd.getValue().getNameProperty());
		mainProductInventoryColumn.setCellValueFactory(cd -> cd.getValue().getInStockProperty());
		mainProductPriceColumn.setCellValueFactory(cd -> cd.getValue().getPriceProperty());
		mainProductTable.setItems(Main.mainInventory.getProductObservableList());
}


	
	protected Stage getStage() {
		return (Stage) mainPane.getScene().getWindow();
	}
	
	protected Pane getPane(){
		return (Pane) mainPane;
	}
	
}
