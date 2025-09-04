package jpa.services.Impl;

import java.util.List;

import jpa.dao.CategoryDao;
import jpa.dao.Impl.CategoryImpl;
import jpa.entity.Category;
import jpa.services.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	CategoryDao cateDao = new CategoryImpl();
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		
		return cateDao.findAll();
	}

	@Override
	public void create(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
