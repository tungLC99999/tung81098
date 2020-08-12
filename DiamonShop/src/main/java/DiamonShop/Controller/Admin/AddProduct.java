package DiamonShop.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Controller.User.BaseController;
import DiamonShop.Dto.ProductsDto;
import DiamonShop.Service.User.ProductServiceImpl;

@Controller
public class AddProduct extends BaseController {
	@Autowired
	ProductServiceImpl productService = new ProductServiceImpl();

	
	@RequestMapping(value = "/admin/add", method = RequestMethod.GET)
	public ModelAndView Add() {
		_mvShare.setViewName("admin/add");
		_mvShare.addObject("product", new ProductsDto());
		return _mvShare;
	}

	@RequestMapping(value = "/admin/add", method = RequestMethod.POST)
	public ModelAndView CreateProduct(@ModelAttribute("product") ProductsDto product) {
		int count = productService.AddProduct(product);
		if (count > 0) {
			_mvShare.addObject("status", "Thêm  thành công");

		} else {
			_mvShare.addObject("status", "Thêm thất bại");
		}
		_mvShare.setViewName("admin/add");
		return _mvShare;
	}
}
