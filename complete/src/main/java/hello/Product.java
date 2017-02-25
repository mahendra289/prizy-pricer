package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	private String productBarCode;
	private String store;
	private Integer price;
	private String notes;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public String getProductBarCode() {
		return productBarCode;
	}
	public void setProductBarCode(String productBarCode) {
		this.productBarCode = productBarCode;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	
}
