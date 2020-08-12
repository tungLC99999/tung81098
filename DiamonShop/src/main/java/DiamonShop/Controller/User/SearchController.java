package DiamonShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Dto.ProductsDto;
import DiamonShop.Service.User.IProductService;
import DiamonShop.Service.User.ProductServiceImpl;
@Controller
public class SearchController extends BaseController {

	@Autowired
	ProductServiceImpl productService = new ProductServiceImpl();
	
	@RequestMapping(value = "/search")
	public ModelAndView Index(@ModelAttribute("product") ProductsDto product) {
		
		_mvShare.setViewName("user/products/search");
		
		return _mvShare;
	}
	
	
	
	
	@RequestMapping(value = "/search/{name}",method = RequestMethod.GET )
	public ModelAndView search(@PathVariable String name) {
		
		_mvShare.setViewName("user/products/search");
		_mvShare.addObject("product", productService.GetProductByname(name));
		
		return new ModelAndView("redirect:/search/{name}");
		
	}

}