package helloworld.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import helloworld.configs.DBConnectSQL;
import helloworld.dao.CategoryDao;
import helloworld.models.CategoryModel;

public class CategoryDaoImpl implements CategoryDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<CategoryModel> findAll() {
		String sql = "select * from categories";
		List<CategoryModel> list = new ArrayList<>();
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				list.add(category);
			}
			conn.close();
			ps.close();
			rs.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CategoryModel findById(int id) {
		String sql = "select * from categories where categoryid=?";

		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			CategoryModel category = new CategoryModel();
			while (rs.next()) {
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));

			}
			conn.close();
			ps.close();
			rs.close();
			return category;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public CategoryModel findByname(String name) {
		String sql = "select * from categories where categoryname=?";

		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();

			CategoryModel category = new CategoryModel();
			while (rs.next()) {
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));

			}
			conn.close();
			ps.close();
			rs.close();
			return category;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(CategoryModel category) {
		String sql = "insert into categories(categoryname, images, status) values(?, ?, ?)";

		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.executeUpdate();
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(CategoryModel category) {
		String sql = "update categories set categoryname=?, images=?, status=?";

		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.executeUpdate();
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "delete from categories where categoryid=?";

		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			// doc resultset
			ps.executeUpdate();

			conn.close();
			ps.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateStatus(int id, int status) {
		String sql = "update categories set status=? where categoryid=?";

		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			// truyền vào tham số thứ nhất id (dấu hòi thứ nhat)
			// thiet lap tham so (neu co)

			ps.setInt(1, status);
			ps.setInt(2, id);

			ps.executeUpdate();

			conn.close();
			ps.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
