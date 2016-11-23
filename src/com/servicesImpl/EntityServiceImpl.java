package com.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dao.EntityDao;
import com.daoImpl.EntityDaoImpl;
import com.entities.Movie;
import com.services.EntityService;

@Service
public class EntityServiceImpl implements EntityService{

	@Autowired
	@Qualifier("entityDaoImpl")
	EntityDao entityDao;
	
	@Override
	public List getList(String entityName) {
		// TODO Auto-generated method stub
		return entityDao.getList(entityName);
	}

	@Override
	public boolean delete(Object entity) {
		// TODO Auto-generated method stub
		return entityDao.delete(entity);
	}

	@Override
	public boolean saveOrUpdate(Object entity) {
		// TODO Auto-generated method stub
		return entityDao.saveOrUpdate(entity);
	}

	@Override
	public List getListByDesc(String entityName , String descField) {
		// TODO Auto-generated method stub
		return entityDao.getListByDesc(entityName , descField);
	}

	@Override
	public Object getEntityById(Class<?> clazz, int id) {
		// TODO Auto-generated method stub
		return entityDao.getEntityById(clazz, id);
	}
	
}
