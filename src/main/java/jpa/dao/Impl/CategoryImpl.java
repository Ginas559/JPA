package jpa.dao.Impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jpa.Configs.JPAConfig;
import jpa.dao.CategoryDao;
import jpa.entity.Category;

public class CategoryImpl implements CategoryDao{

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		EntityManager enma = JPAConfig.getEntityManager();
		//Cach 1:
		TypedQuery<Category> query = enma.createNamedQuery("Category.findAll", Category.class);
		//Cach 2:
//		String jpql = "Select c from Category c";
//		TypedQuery<Category> query = enma.createQuery(jpql,Category.class);
		
		
		
		return null;
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
