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

    @RequestMapping(value="/rateProduct", method=RequestMethod.GET)
    public String greeting(Product product, Model model) {
    	
        return "rateProduct";
    }
    
    @RequestMapping(value="/productListview", method=RequestMethod.GET)
    public String productListview(Model model) {
    	model.addAttribute("products", prizyRepository.findAll());
        return "productListview";
    }
    
    @RequestMapping(value="/rateProduct", method=RequestMethod.POST)
    public String saveProduct(@ModelAttribute Product product, BindingResult bindingResult , Model model) {
    	
    	prizyRepository.save(product);
    	
        model.addAttribute("store", product.getStore());
        model.addAttribute("productBarCode", product.getProductBarCode());
        model.addAttribute("price", product.getPrice());
        model.addAttribute("notes", product.getNotes());
        return "productConfirm";
    }
    
    

}
