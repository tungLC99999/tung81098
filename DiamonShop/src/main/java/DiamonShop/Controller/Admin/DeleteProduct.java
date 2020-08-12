package DiamonShop.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Controller.User.BaseController;
import DiamonShop.Dto.ProductsDto;
import DiamonShop.Service.User.HomeServiceImpl;
import DiamonShop.Service.User.ProductServiceImpl;

@Controller
public class DeleteProduct extends BaseController {

	@Autowired
	ProductServiceImpl productService = new ProductServiceImpl();
	@Autowired
	HomeServiceImpl _homeService;

	@RequestMapping(value = "/admin/delete", method = RequestMethod.GET)
	public ModelAndView delete() {
		_mvShare.setViewName("admin/delete");
		_mvShare.addObject("products", _homeService.GetAllProducts());
		return _mvShare;
	}

	@RequestMapping(value = "/admin/delete/{id_product}")
	public ModelAndView DeleteProduct(@PathVariable int id_product) {
		int count = productService.DelProduct(id_product);
		if (count > 0) {
			_mvShare.addObject("status", "Xóa  thành công");

		} else {
			_mvShare.addObject("status", "Xóa thất bại");
		}
		_mvShare.setViewName("admin/delete");
		return new ModelAndView("redirect:/admin/delete");
	}
}
