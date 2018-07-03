package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Inhouse extends Part {

	private int machineID;
	
	public int getMachineID() {
		return machineID;
	}
	
	public void setMachineID(int machineID) {
		this.machineID = machineID;
	}
	
	public Inhouse() {
	}
	
	public Inhouse(int partID, String name, double price, int inStock, int min, int max, int machineID) {
		setPartId(partID);
		setName(name);
		setPrice(price);
		setInStock(inStock);
		setMin(min);
		setMax(max);
		setMachineID(machineID);
	}
	
}
