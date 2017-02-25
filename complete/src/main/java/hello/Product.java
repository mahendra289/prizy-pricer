package hello;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product {

	private  Integer productBarCode;
	
	private List<ProductRates> productRates;
	
	
	public Product(){}
	
	@Id
	public Integer getProductBarCode() {
		return productBarCode;
	}
	public void setProductBarCode(Integer productBarCode) {
		this.productBarCode = productBarCode;
	}
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	public List<ProductRates> getProductRates() {
		return productRates;
	}
	public void setProductRates(List<ProductRates> productRates) {
		this.productRates = productRates;
	}

	
	
	
	
	
}
