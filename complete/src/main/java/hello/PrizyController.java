package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PrizyController {
	
	@Autowired
	PrizyRepository prizyRepository;
	
	@Autowired
	ProductRepository productRepository;

    @RequestMapping(value="/rateProduct", method=RequestMethod.GET)
    public String greeting(Model model) {
    	
    	ProductRates productRates = new ProductRates(new Product());
    	model.addAttribute(productRates);
    	
        return "rateProduct";
    }
    
    @RequestMapping(value="/productListview", method=RequestMethod.GET)
    public String productListview(Model model) {
    	model.addAttribute("productRates", prizyRepository.findAll());
        return "productListview";
    }
    
    @RequestMapping(value="/rateProduct", method=RequestMethod.POST)
    public String saveProduct(@ModelAttribute ProductRates productRates, BindingResult bindingResult , Model model) {
    	
    	prizyRepository.save(productRates);
    	
        model.addAttribute("store", productRates.getStore());
        model.addAttribute("productBarCode", productRates.getProduct().getProductBarCode());
        model.addAttribute("price", productRates.getPrice());
        model.addAttribute("notes", productRates.getNotes());
        return "productConfirm";
    }
    
    @RequestMapping(value="/productInfo", method=RequestMethod.GET)
    public String productInfo(Model model) {
    	
    	Product product = productRepository.findByProductBarCode(888);
    	
    	System.out.println(product.getProductRates().get(0).getNotes());
    	
        return "productInfo";
    }
    

}
