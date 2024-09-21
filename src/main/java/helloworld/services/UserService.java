package helloworld.services;

import helloworld.models.UserModel;

public interface UserService {
	UserModel findByUserName(String username);

	UserModel login(String username, String password);

	void insert(UserModel user);

	boolean register(String email, String password, String username, String fullname, String phone);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);
	
	boolean checkExistPhone(String phone);

	void updatePassword(String username, String password);
}
