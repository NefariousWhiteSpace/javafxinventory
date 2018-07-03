package application;

import java.util.ArrayList;
import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {

	private ArrayList<Product> products = new ArrayList();
	private ArrayList<Part> parts = new ArrayList();
	public Part currentPart;
	public Product currentProduct;
	int maxPartId = 0;
	int maxProductId = 0;
	
	
	//Add test data
	private void populateArrayList() {
		Outsourced part1 = new Outsourced(getNewMaxPartID(),"Steering Wheel",1,11,0,2000,"Toyota");
		addPart(part1);
		Outsourced part2 = new Outsourced(getNewMaxPartID(),"Lug Nut",2,22,0,500,"Spoon");
		addPart(part2);
		Outsourced part3 = new Outsourced(getNewMaxPartID(),"Muffler",3,33,0,44,"Nummi");
		addPart(part3);
		Outsourced part4 = new Outsourced(getNewMaxPartID(),"Exhaust",4,44,0,84,"Gecom");
		addPart(part4);
		Inhouse part5 = new Inhouse(getNewMaxPartID(),"Seat Warmer",5,55,0,296,1);
		addPart(part5);
		Inhouse part6 = new Inhouse(getNewMaxPartID(),"Emergency Brake",6,66,0,296,2);
		addPart(part6);
		Inhouse part7 = new Inhouse(getNewMaxPartID(),"Catalytic Converter",7,77,0,296,3);
		addPart(part7);
		Inhouse part8 = new Inhouse(getNewMaxPartID(),"Valve Lifter",8,88,0,296,4);
		addPart(part8);

		Product product1 = new Product(getNewMaxProductID(),"Honda Civic",1,111,10,2001);	
		addProduct(product1);
		Product product2 = new Product(getNewMaxProductID(),"Toyota Carolla",2,222,20,2002);
		addProduct(product2);
		Product product3 = new Product(getNewMaxProductID(),"BMW M5",3,333,30,2003);
		addProduct(product3);
		Product product4 = new Product(getNewMaxProductID(),"Audi R8",4,444,40,2004);
		addProduct(product4);
		Product product5 = new Product(getNewMaxProductID(),"Chevrolet Impala",5,555,50,2005);
		addProduct(product5);
		Product product6 = new Product(getNewMaxProductID(),"Ford GT",6,666,60,2006);
		addProduct(product6);
		Product product7 = new Product(getNewMaxProductID(),"Nissan Maxima",7,777,70,2007);
		addProduct(product7);
		
		product1.addAssociatedPart(part1);
		product1.addAssociatedPart(part2);
		product1.addAssociatedPart(part3);
		product1.addAssociatedPart(part4);
		product1.addAssociatedPart(part5);
		
		product2.addAssociatedPart(part6);
		product2.addAssociatedPart(part7);
		product2.addAssociatedPart(part8);
	}
	
	public Inventory() {
		populateArrayList();
	}
	
	public ArrayList<Part> getParts(){
		return parts;
	}	
	
	public ArrayList<Product> getProducts(){
		return products;
	}
	
	//Returns observable list for TableView usage (keeps view in sync with model)
	public ObservableList<Part> getPartObservableList(){
		ObservableList<Part> partObservableList = FXCollections.observableArrayList();
		partObservableList.addAll(parts);
		return partObservableList;
	}
	
	public ObservableList<Product> getProductObservableList(){
		ObservableList<Product> productObservableList = FXCollections.observableArrayList();
		productObservableList.addAll(products);
		return productObservableList;
	}
	

	
	public void addProduct(Product product) {
		products.add(product);
		updateMaxProductID();
	}
	
	public boolean removeProduct(int productID) {
		boolean isDeleted = false;
		for(Iterator<Product> iterator = products.iterator(); iterator.hasNext();) {
			Product product = iterator.next();
			if(product.getProductID() == productID) {
				iterator.remove();
				isDeleted = true;
				updateMaxPartID();
			}
		}
		
		return isDeleted;
	}
	
	public void updateProduct(int productID) {
		//TODO: Implement
	}	
	
	public void addPart(Part part) {
		parts.add(part);
		updateMaxPartID();
	}
	
	public boolean deletePart(int partID) {
		boolean isDeleted = false;
		for(Iterator<Part> iterator = parts.iterator(); iterator.hasNext();) {
			Part part = iterator.next();
			if(part.getPartID() == partID) {
				iterator.remove();
				isDeleted = true;
				updateMaxPartID();
			}
			
		}return isDeleted;
	}
	
	public void updateMaxPartID() {
		maxPartId = 0;
		if (!parts.isEmpty()) {
			for(Part part:parts) {
				if (part.getPartID() > maxPartId) {
					maxPartId = part.getPartID();
				}
			}
		}
	}
	
	public void updateMaxProductID() {
		maxProductId = 0;
		if (!products.isEmpty()) {
			for(Product product:products) {
				if (product.getProductID() > maxProductId) {
					maxProductId = product.getProductID();
				}
			}
		}
	}
	
	public int getNewMaxPartID() {
		return maxPartId + 1;
	}
	
	public int getNewMaxProductID() {
		return maxProductId + 1;
	}
	
	public Part lookupPart(int partID) {
		Part returnPart = new Outsourced();
		for(Part part:parts) {
			if(part.getPartID() == partID) {
			returnPart = part;
			}
		}return returnPart;
	}
	
	public void updatePart(int partID) {
		//TODO: Implement (May not be needed functionality)
	}
	
	
	public Part getCurrentPart(){
		return currentPart;
	}
	
	public void setCurrentPart(Part currentPart) {
		this.currentPart = currentPart;
	}

	public Product getCurrentProduct() {
		return currentProduct;
	}
	
	public void setCurrentProduct(Product currentProduct) {
		this.currentProduct = currentProduct;
	}
	
}
