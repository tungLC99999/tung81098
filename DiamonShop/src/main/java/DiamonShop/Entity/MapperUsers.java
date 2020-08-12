package DiamonShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperUsers implements RowMapper<Users>{

	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		Users user = new Users();
		user.setId(rs.getInt("id"));
		user.setEnabled(rs.getInt("enabled"));
		user.setAddress(rs.getString("address"));
		user.setDisplay_name(rs.getString("display_name"));
		user.setPassword(rs.getString("password"));
		user.setUsername(rs.getString("username"));	
		user.setWallet(rs.getDouble("wallet"));
		return user;
	} 

}
