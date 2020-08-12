package DiamonShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShop.Dto.ProductsDto;
import DiamonShop.Dto.ProductsDtoMapper;
import DiamonShop.Entity.MapperUsers;
import DiamonShop.Entity.Users;

@Repository
public class ProductsDao extends BaseDao {

	private final boolean YES = true;
	private final boolean NO = false;

	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("p.id as id_product ");
		sql.append(", p.id_category ");
		sql.append(", p.sizes ");
		sql.append(", p.name ");
		sql.append(", p.price ");
		sql.append(", p.sale ");
		sql.append(", p.title ");
		sql.append(", p.highlight ");
		sql.append(", p.new_product ");
		sql.append(", p.details ");
		sql.append(", c.id as id_color ");
		sql.append(", c.name as name_color ");
		sql.append(", c.code as code_color ");
		sql.append(", c.img ");
		sql.append(", p.created_at ");
		sql.append(", p.updated_at ");
		sql.append("FROM ");
		sql.append("products AS p ");
		sql.append("INNER JOIN ");
		sql.append("colors AS c ");
		sql.append("ON p.id = c.id_product ");
		return sql;
	}

	private String SqlProducts(boolean newProduct, boolean highLight) {
		StringBuffer sql = SqlString();
		sql.append("WHERE 1 = 1 ");
		if (highLight) {
			sql.append("AND p.highlight = true ");
		}
		if (newProduct) {
			sql.append("AND p.new_product = true ");
		}
		sql.append("GROUP BY p.id, c.id_product ");
		sql.append("ORDER BY RAND() ");
		if (highLight) {
			sql.append("LIMIT 9 ");
		}
		if (newProduct) {
			sql.append("LIMIT 12 ");
		}
		return sql.toString();
	}

	// all
	private String SqlAllProducts() {
		StringBuffer sql = SqlString();

		return sql.toString();
	}

	private StringBuffer SqlProductsByID(int id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE 1 = 1 ");
		sql.append("AND id_category = " + id + " ");
		return sql;
	}

	private String SqlProductsPaginate(int id, int start, int totalPage) {
		StringBuffer sql = SqlProductsByID(id);
		sql.append("LIMIT " + start + ", " + totalPage);
		return sql.toString();
	}

	public List<ProductsDto> GetDataProducts() {
		String sql = SqlProducts(YES, NO);
		List<ProductsDto> listProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}
// all
	public List<ProductsDto> GetAllProducts() {
		String sql = SqlAllProducts();
		List<ProductsDto> listProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}

	public List<ProductsDto> GetAllProductsByID(int id) {
		String sql = SqlProductsByID(id).toString();
		List<ProductsDto> listProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProducts;
	}

	public List<ProductsDto> GetDataProductsPaginate(int id, int start, int totalPage) {
		StringBuffer sqlGetDataByID = SqlProductsByID(id);
		List<ProductsDto> listProductsByID = _jdbcTemplate.query(sqlGetDataByID.toString(), new ProductsDtoMapper());
		List<ProductsDto> listProducts = new ArrayList<ProductsDto>();
		if (listProductsByID.size() > 0) {
			String sql = SqlProductsPaginate(id, start, totalPage);
			listProducts = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		}
		return listProducts;
	}
//byid
	private String SqlProductByID(long id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE 1 = 1 ");
		sql.append("AND p.id = " + id + " ");
		sql.append("LIMIT 1 ");
		return sql.toString();
	}

	public List<ProductsDto> GetProductByID(long id) {
		String sql = SqlProductByID(id);
		List<ProductsDto> listProduct = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProduct;
	}

	public ProductsDto FindProductByID(long id) {
		String sql = SqlProductByID(id);
		ProductsDto product = _jdbcTemplate.queryForObject(sql, new ProductsDtoMapper());
		return product;
	}
//byName
	private String SqlProductByName(String name) {
		StringBuffer sql = SqlString();
		sql.append("WHERE p.name =  '" + name + "' ");
		//sql.append("WHERE p.name =  'Manicure & Pedicure' ");
		
		return sql.toString();
	}
	public List<ProductsDto> GetProductByname(String name) {
		
		String sql = SqlProductByName(name);
		List<ProductsDto> listProduct = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProduct;
	}
	

	public int AddProduct(ProductsDto product) {
		StringBuffer sql1 = new StringBuffer();
		sql1.append("INSERT ");
		sql1.append("INTO products ");
		sql1.append("( ");
		sql1.append("    id_category, ");
		sql1.append("    sizes, ");
		sql1.append("    name, ");
		sql1.append("    price, ");
		sql1.append("    sale, ");
		sql1.append("    title, ");
		sql1.append("    highlight, ");
		sql1.append("    new_product, ");
		sql1.append("    details ");
		// sql1.append(" img, ");
		// sql1.append(" name_color ");
		// sql1.append(" created_at, ");
		// sql1.append(" updated_at ");
		sql1.append(") ");
		sql1.append(" VALUES ");
		sql1.append(" ( ");
		sql1.append("     ");
		sql1.append("    '1', ");
		sql1.append("    '" + product.getSizes() + "', ");
		sql1.append("    '" + product.getName() + "', ");
		sql1.append("    " + product.getPrice() + ", ");
		sql1.append("    " + product.getSale() + ", ");
		sql1.append("     '" + product.getTitle() + "', ");
		sql1.append("    " + product.istHighlight() + ", ");
		sql1.append("     " + product.isNew_product() + ", ");
		sql1.append("   '" + product.getDetails() + "' ");
		// sql1.append(" '" + product.getImg() + "', ");
		// sql1.append(" '" + product.getName_color() + "' ");
		// sql1.append(" '" + product.getCreated_at() + "', ");
		// sql1.append(" '" + product.getUpdated_at() + "' ");
		sql1.append(" )");
		int insert = _jdbcTemplate.update(sql1.toString());
		return insert;
	}

	public int DelProduct(int id_product) {
		StringBuffer sql1 = new StringBuffer();
		sql1.append("DELETE ");
		sql1.append("FROM products ");
		sql1.append("WHERE ");
		sql1.append("id = " + id_product + " ");
		int insert = _jdbcTemplate.update(sql1.toString());
		return insert;
	}

	public int EditProduct(ProductsDto product) {
		StringBuffer sql1 = new StringBuffer();
		sql1.append("UPDATE ");
		sql1.append("products ");
		sql1.append("SET ");
		sql1.append("id_category = 1, ");
		sql1.append("sizes = '" + product.getSizes() + "' ,");
		sql1.append("name= '" + product.getName() + "', ");
		sql1.append("price= '" + product.getPrice() + "', ");
		sql1.append("sale= '" + product.getSale() + "', ");
		sql1.append("title= '" + product.getTitle() + "', ");
		sql1.append("highlight= " + product.istHighlight() + ", ");
		sql1.append("new_product= " + product.isNew_product() + ", ");
		sql1.append("details = '" + product.getDetails() + "' ");
		sql1.append("WHERE id =  " + product.getId_product() + "");
		int insert = _jdbcTemplate.update(sql1.toString());
		return insert;
	}
	
	
	
}