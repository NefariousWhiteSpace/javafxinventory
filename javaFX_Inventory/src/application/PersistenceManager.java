package application;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class PersistenceManager {

	public Inventory getInventoryFromFile() {
		Inventory inventory = new Inventory();
		return inventory;
		//TODO: Get inventory from XML
	}
	
	public void saveInventoryToFile() {
		//TODO: Save inventory to XML
	}
	
}
