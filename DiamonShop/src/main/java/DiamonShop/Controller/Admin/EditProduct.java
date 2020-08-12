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
public class EditProduct extends BaseController {
	@Autowired
	ProductServiceImpl productService = new ProductServiceImpl() ;
	//them product
		@RequestMapping(value = "/admin/edit", method = RequestMethod.GET)
		public ModelAndView Edit() {
			_mvShare.setViewName("admin/edit");
			_mvShare.addObject("product", new ProductsDto());
			return _mvShare;
		}
		
		@RequestMapping(value = "/admin/edit", method = RequestMethod.POST)
		public ModelAndView EditProduct(@ModelAttribute("product") ProductsDto product) {
			
			int count = productService.EditProduct(product);
			if(count>0) {
				_mvShare.addObject("status","Sửa  thành công");
				
			}
			else {
				_mvShare.addObject("status","Sửa thất bại");
			}
			_mvShare.setViewName("admin/edit");
			return _mvShare;
		}
}
