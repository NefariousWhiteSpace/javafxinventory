package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Part {

private int partID;
private String name;
private double price;
private int inStock;
private int min;
private int max;


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

public void setPartId(int partID) {
	this.partID = partID;
}

public int getPartID() {
	return partID;
}

//public String getCompany() {
//	return "";
//}

//public void setCompanyName(String name) {
	//Overridden by child
//}

//public int getMachineID() {
//	return -1;
//}
//
//public void setMachineID(int machineID) {
//}

public StringProperty getNameProperty() {
	return new SimpleStringProperty(getName());
}
public StringProperty getPartIDProperty() {
	return new SimpleStringProperty(Integer.toString(getPartID()));
}
public StringProperty getPriceProperty() {
	return new SimpleStringProperty("$" + String.valueOf(getPrice()));
}
public StringProperty getInStockProperty() {
	return new SimpleStringProperty(Integer.toString(getInStock()));
}





}
