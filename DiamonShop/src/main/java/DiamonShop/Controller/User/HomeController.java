package DiamonShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Dto.ProductsDto;
import DiamonShop.Service.User.IProductService;

@Controller
public class HomeController extends BaseController {

	
	@Autowired
	private IProductService _productService;
	
	@RequestMapping(value = { "/", "/trang-chu" })
	public ModelAndView Index() {
	
		_mvShare.addObject("slides", _homeService.GetDataSlide());
		_mvShare.addObject("categorys", _homeService.GetDataCategorys());
		_mvShare.addObject("products", _homeService.GetDataProducts());	
	
		
		_mvShare.setViewName("user/index");
		return _mvShare;
	}
	
	

	@RequestMapping(value = "/product")
	public ModelAndView Product() {
		ModelAndView mv = new ModelAndView("user/product");
		return mv;
	}
	@RequestMapping(value = "/contact")
	public ModelAndView Contact() {
		ModelAndView mv = new ModelAndView("user/contact");
		return mv;
	}
	@RequestMapping(value = "/infor")
	public ModelAndView Infor() {
		ModelAndView mv = new ModelAndView("user/account/infor");
		return mv;
	}
	
}