package DiamonShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import DiamonShop.Dto.ProductsDto;
import DiamonShop.Entity.Users;

@Service
public interface IProductService {
	public ProductsDto GetProductByID(long id);
	
	
	
	public List<ProductsDto> GetProductByIDCategory(int id);
	
	public  List<ProductsDto>  GetProductByname(String name);
	
	
	
	public int AddProduct(ProductsDto product);
	
	public int DelProduct(int id_product);
	
	public int EditProduct(ProductsDto product);
}