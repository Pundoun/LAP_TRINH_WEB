package helloworld.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import helloworld.configs.DBConnectSQL;
import helloworld.dao.UserDao;
import helloworld.models.UserModel;

public class UserDaoImpl implements UserDao {
	@Override
	public UserModel findByUserName(String username) {
		String sql = "select * from Users where username = ?";
		try {
			Connection conn = new DBConnectSQL().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username); // truyền tham số
			ResultSet rs = ps.executeQuery(); // thực thi phát biểu prepare rồi đưa kết quả vào resultSet
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setFullname(rs.getString("fullname"));
				user.setImages(rs.getString("images"));
				user.setPhone(rs.getString("phone"));
				user.setRoleid(rs.getInt("roleid"));
				user.setCreatedate(rs.getDate("createdate"));
				
				return user;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Test chương trình. Kích phải chuột chọn run as->java application
	public static void main(String[] args) {
		try {
			UserDao userDao = new UserDaoImpl();

			System.out.println(userDao.findByUserName("nhuquynh"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
