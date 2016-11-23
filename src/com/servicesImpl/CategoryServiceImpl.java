package com.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CategoryDao;
import com.entities.Category;
import com.entities.Movie;
import com.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryDao categoryDao;
	
	@Override
	public List getList(String entityName) {
		// TODO Auto-generated method stub
		return categoryDao.getList(entityName);
	}

	@Override
	public boolean delete(Object entity) {
		// TODO Auto-generated method stub
		return categoryDao.delete(entity);
	}

	@Override
	public boolean saveOrUpdate(Object entity) {
		// TODO Auto-generated method stub
		return categoryDao.saveOrUpdate(entity);
	}

	@Override
	public List getListByDesc(String entityName , String descField) {
		// TODO Auto-generated method stub
		return categoryDao.getListByDesc(entityName , descField);
	}

	@Override
	public Object getEntityById(Class<?> clazz, int id) {
		// TODO Auto-generated method stub
		return categoryDao.getEntityById(clazz, id);
	}

	@Override
	public List<Movie> getMovieListByCategoryId(int categoryId, int pageNo) {
		// TODO Auto-generated method stub
		return categoryDao.getMovieListByCategoryId(categoryId, pageNo);
	}

	@Override
	public long countMovieOfTheCategory(int categoryId) {
		// TODO Auto-generated method stub
		return categoryDao.countMovieOfTheCategory(categoryId);
	}

	@Override
	public Category getCategoryByName(String categoryName) {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryByName(categoryName);
	}


}
