package helloworld.dao;

import helloworld.models.UserModel;

public interface UserDao {
	// khai báo các hàm và thủ tục
	UserModel findByUserName(String username);

}
