package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Outsourced extends Part {

	private String companyName = "";
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	public Outsourced() {
	}
	
	public Outsourced(int partID, String name, double price, int inStock, int min, int max, String companyName) {
		setPartId(partID);
		setName(name);
		setPrice(price);
		setInStock(inStock);
		setMin(min);
		setMax(max);
		setCompanyName(companyName);

	}
	
}
