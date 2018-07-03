package application;
import java.util.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class Product {

private ArrayList<Part> associatedParts = new ArrayList<Part>();
private int productID;
private String name;
private double price;
private int inStock;
private int min;
private int max;

public Product(int productID, String name, double price, int inStock, int min, int max) {
	setProductID(productID);
	setName(name);
	setPrice(price);
	setInStock(inStock);
	setMin(min);
	setMax(max);
}

public void setName(String name) {
	this.name = name;
}

public String getName() {
	return name;
}

public void setPrice(double price) {
	this.price = price;
}

public double getPrice() {
	return price;
}

public void setInStock(int inStock) {
	this.inStock = inStock;
}

public int getInStock() {
	return inStock;
}



public void setMin(int min) {
	this.min = min;
}

public int getMin() {
	return min;
}

public void setMax(int max) {
	this.max = max;
}

public int getMax() {
	return max;
}

public void addAssociatedPart(Part part){
	associatedParts.add(part);
}

public boolean removeAssociatedPart(int partID) {
	boolean deleted = false;
	for(Iterator<Part> iterator = associatedParts.iterator(); iterator.hasNext();) {
		Part thisPart = iterator.next();
		if(thisPart.getPartID() == partID) {
			iterator.remove();
			deleted = true;
		}
	}
	return deleted;
}

public int lookupAssociatedPart(Part part) {
	// return int associatedParts.partID where this.part == part;
	int partId = 0;
	for (Part thisPart:associatedParts) {
		if(thisPart==part) {
			partId = thisPart.getPartID();
		}
	}
return partId;
}

public void setProductID(int productID) {
	this.productID = productID;
}

public int getProductID() {
	return productID;
}

public StringProperty getProductIDProperty() {
	return new SimpleStringProperty(Integer.toString(getProductID()));
}
public StringProperty getNameProperty() {
	return new SimpleStringProperty(getName());
}
public StringProperty getPriceProperty() {
	return new SimpleStringProperty("$" + String.valueOf(getPrice()));
}
public StringProperty getInStockProperty() {
	return new SimpleStringProperty(Integer.toString(getInStock()));
}

public ObservableList<Part> getIncludedPartObservableList(){
	ObservableList<Part> includedPartObservableList = FXCollections.observableArrayList();
	includedPartObservableList.addAll(associatedParts);
	return includedPartObservableList;
}

public ObservableList<Part> getExcludedPartObservableList(){
	ObservableList<Part> excludedPartObservableList = FXCollections.observableArrayList();
	excludedPartObservableList.addAll(Main.mainInventory.getParts());
	excludedPartObservableList.removeAll(associatedParts);
	return excludedPartObservableList;
}

}