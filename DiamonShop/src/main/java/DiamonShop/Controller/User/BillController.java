package DiamonShop.Controller.User;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Dto.ProductsDto;
import DiamonShop.Entity.Users;
import DiamonShop.Service.User.AccountServiceImpl;

@Controller
public class BillController extends BaseController {
	@Autowired
	AccountServiceImpl accountService = new AccountServiceImpl();

	@RequestMapping(value = "/hoa-don", method = RequestMethod.GET)
	public ModelAndView checkout() {
		_mvShare.setViewName("user/cart/bill");
		_mvShare.addObject("user", new Users());
		return _mvShare;
	}
	@RequestMapping(value = "/hoa-don", method = RequestMethod.POST)
	public ModelAndView Login(HttpSession session ,@ModelAttribute("user") Users user) {
		_mvShare.setViewName("user/cart/bill");
		session.setAttribute("LoginInfo", user);
		return _mvShare;
	}
	@RequestMapping(value = "/paid", method = RequestMethod.GET)
	public ModelAndView Paid(HttpSession session ,@ModelAttribute("user") Users user) {
		_mvShare.setViewName("user/cart/paid");
		session.setAttribute("LoginInfo", user);
		return _mvShare;
	}
//	@RequestMapping(value = "/paid", method = RequestMethod.POST)
//	public ModelAndView EditProduct(HttpSession session ,@ModelAttribute("user") Users user) {
//		
//		int count = accountService.EditProduct(product);
//		if(count>0) {
//			_mvShare.addObject("status","Sửa  thành công");
//			
//		}
//		else {
//			_mvShare.addObject("status","Sửa thất bại");
//		}
//		_mvShare.setViewName("admin/edit");
//		return _mvShare;
//	}
}
