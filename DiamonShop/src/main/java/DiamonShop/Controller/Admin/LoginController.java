package DiamonShop.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Controller.User.BaseController;
import DiamonShop.Dto.ProductsDto;
import DiamonShop.Entity.Users;
import DiamonShop.Service.User.ProductServiceImpl;

@Controller
public class LoginController extends BaseController {
	
	@Autowired
	ProductServiceImpl productService = new ProductServiceImpl() ;
	
	@RequestMapping(value = { "/login"})
	public String login(@RequestParam(value = "error", required = false) final String error, final Model model) {
		if (error != null) {
			model.addAttribute("message", "Login Failed!");
		}
		return "login";
	}

	@RequestMapping("/user")
	public String user() {
		return "login_user";
	}

	@RequestMapping("/logout")
	public String logout(final Model model) {
		model.addAttribute("message", "Logged out!");
		return "login";
	}
	@RequestMapping(value = "/admin/index")
	public ModelAndView index() {
		_mvShare.setViewName("admin/index");
		
		return _mvShare;
	}
	
	
	
	

}