package DiamonShop.Dao;

import org.springframework.stereotype.Repository;

import DiamonShop.Entity.MapperUsers;
import DiamonShop.Entity.Users;

@Repository
public class UsersDao extends BaseDao {
	public int AddAccount(Users user) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT ");
		sql.append("INTO users ");
		sql.append("( ");
		sql.append("    username, ");
		sql.append("    password, ");
		// sql.append(" enabled, ");
		sql.append("    display_name, ");
		sql.append("    address ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("    '" + user.getUsername() + "', ");
		sql.append("    '" + user.getPassword() + "', ");
		// sql.append(" '"+user.getEnabled()+"', ");
		sql.append("    '" + user.getAddress() + "', ");
		sql.append("    '" + user.getDisplay_name() + "' ");
		sql.append(")");

		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}

	public Users GetAccountByAcc(Users user) {
		String sql = "SELECT * FROM users WHERE username = '"+user.getUsername()+"'";
		
		Users result  = _jdbcTemplate.queryForObject(sql, new MapperUsers());
		return result;
	}
}
