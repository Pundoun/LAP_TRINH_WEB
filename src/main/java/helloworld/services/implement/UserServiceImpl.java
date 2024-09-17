package helloworld.services.implement;

import helloworld.dao.UserDao;
import helloworld.dao.implement.UserDaoImpl;
import helloworld.models.UserModel;
import helloworld.services.UserService;

public class UserServiceImpl implements UserService {
	// Lấy toàn bộ hàm trong tầng Dao của user
	UserDao userDao = new UserDaoImpl();

	@Override
	public UserModel findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	// Test chương trình. Kích phải chuột chọn run as->java application
	public static void main(String[] args) {
		try {
			UserService userService = new UserServiceImpl();

			System.out.println(userService.login("nhuquynh", "123"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
