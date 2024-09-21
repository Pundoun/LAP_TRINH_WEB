package helloworld.dao;

import helloworld.models.UserModel;

public interface UserDao {
	// khai báo các hàm và thủ tục
	
	UserModel findByUserName(String username);
	
	void insert(UserModel user);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);

	void updatePassword(String username, String password);

}
