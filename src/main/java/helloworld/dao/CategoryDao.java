package helloworld.dao;

import java.util.List;

import helloworld.models.CategoryModel;

public interface CategoryDao {

	List<CategoryModel> findAll();

	CategoryModel findById(int id);

	CategoryModel findByname(String name);

	void insert(CategoryModel category);

	void update(CategoryModel category);

	void delete(int id);

	void updateStatus(int id, int status);
	
}
