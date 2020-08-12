package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.ProductsDao;
import DiamonShop.Dto.ProductsDto;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	ProductsDao productDao = new ProductsDao();

	public ProductsDto GetProductByID(long id) {
		List<ProductsDto> listProducts = productDao.GetProductByID(id);
		return listProducts.get(0);
	}

	public List<ProductsDto> GetProductByIDCategory(int id) {
		return productDao.GetAllProductsByID(id);
	}

	public int AddProduct(ProductsDto product) {
	
		return productDao.AddProduct(product);
	}

	public int DelProduct(int id_product) {
		
		return productDao.DelProduct(id_product);
	}
	public int EditProduct(ProductsDto product) {
		
		return productDao.EditProduct(product);
	}

	public  List<ProductsDto>  GetProductByname(String name) {
		return productDao.GetProductByname(name);
	}

	

	

	

	

	
	
}