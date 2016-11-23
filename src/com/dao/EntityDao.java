package com.dao;

import java.util.List;

public interface EntityDao {

	public List getList(String entityName);

	public boolean delete(Object entity);

	public boolean saveOrUpdate(Object entity);

	public List getListByDesc(String entityName , String descField);

	public Object getEntityById(Class<?> clazz, int id);

}
