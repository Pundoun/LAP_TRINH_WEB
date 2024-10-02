package helloworld.services.implement;

import java.util.List;

import helloworld.dao.CategoryDao;
import helloworld.dao.implement.CategoryDaoImpl;
import helloworld.models.CategoryModel;
import helloworld.services.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	public CategoryDao cateDao = new CategoryDaoImpl();

	@Override
	public List<CategoryModel> findAll() {

		return cateDao.findAll();
	}

	@Override
	public CategoryModel findById(int id) {

		return cateDao.findById(id);
	}

	@Override
	public CategoryModel findByname(String name) {

		return cateDao.findByname(name);
	}

	@Override
	public void insert(CategoryModel category) {
		CategoryModel cate = this.findByname(category.getCategoryname());
		if (cate.getCategoryname() == null) {
			cateDao.insert(category);
		}
	}

	@Override
	public void update(CategoryModel category) {
		CategoryModel cate = new CategoryModel();
		cate = cateDao.findById(category.getCategoryid());
		if (cate != null) {
		cateDao.update(category);
		}
	}

	@Override
	public void delete(int id) {
		CategoryModel cate = new CategoryModel();
		cate = cateDao.findById(id);
		if (cate != null) {
			cateDao.delete(id);
		}
	}

	@Override
	public void updateStatus(int id, int status) {
		cateDao.updateStatus(id, status);
	}

}
