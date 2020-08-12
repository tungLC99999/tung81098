package DiamonShop.Service.User;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.UsersDao;
import DiamonShop.Dto.ProductsDto;
import DiamonShop.Entity.Users;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	UsersDao usersDao = new UsersDao();

	public int AddAccount(Users user) {
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)) );
		
		return usersDao.AddAccount(user);
	}

	public Users CheckAccount(Users user) {
		
		String pass = user.getPassword();
		
		
		
		user = usersDao.GetAccountByAcc(user);
		if(user!=null) {
			if(BCrypt.checkpw(pass, user.getPassword())) {
				
				return user;
			}
			else {
				return null;
			}
		
		}
		return null;
		
	}
	
	
}


