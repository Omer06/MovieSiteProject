package com.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.EntityDao;
import com.entities.Movie;

@Transactional
@Repository("entityDaoImpl")
public class EntityDaoImpl implements EntityDao {
	
	private static final Logger logger = Logger.getLogger(EntityDaoImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("deprecation")
	@Override
	public List<?> getList(String entityName) {
		System.out.println(entityName + " isimli tablo veritabanýndan çekiliyor.! ------------------------------------");
		return sessionFactory.getCurrentSession().createQuery("from " + entityName).list();
	}

	@Override
	public boolean delete(Object entity) {
		System.out.println(entity.getClass().getName() + " isimli entity veritabanýndan siliniyor.! ------------------------------------");
		sessionFactory.getCurrentSession().delete(entity);
		return true;
	}

	@Override
	public boolean saveOrUpdate(Object entity) {
		System.out.println(entity.getClass().getName() + " isimli entity veritabanýndan ekleniyor yada kayýt ediliyor.! ------------------------------------");
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
		return true;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<?> getListByDesc(String entityName , String descField) {
		System.out.println(
				entityName + " isimli tablo veritabanýndan çekiliyor ByDesc.! ------------------------------------");
		return sessionFactory.getCurrentSession().createQuery("from " + entityName + " ORDER BY "+ descField +" desc").list();
	}

	@Override
	public Object getEntityById(Class<?> clazz, int id) {
		System.out.println(clazz.getName()  + " isimli entity'in " + id + " id'li objesi veritabanýndan çekiliyor .! ---------------------------");
		return sessionFactory.getCurrentSession().get(clazz, id);
	}
}
