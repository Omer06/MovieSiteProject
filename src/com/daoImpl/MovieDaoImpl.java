package com.daoImpl;

import org.springframework.transaction.annotation.Transactional;

import com.dao.MovieDao;
import com.entities.Movie;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class MovieDaoImpl implements MovieDao{
	
	private static final Logger logger = Logger.getLogger(MovieDaoImpl.class);
	
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

	@Override
	public void hitUpdate(Movie movie) {
		System.out.println(movie.getName() + " isimli filmin hit ' i 1 adet yükseltiliyor.! --------------------------------------------------------");
		sessionFactory.getCurrentSession().createQuery("update movie  m set m.hit = m.hit + 1 where m.id= " + movie.getId()).executeUpdate();
	}

	@Override
	public List<Movie> getMovieListByPageOrder(int pageNo) {
		System.out.println(pageNo + ". sayfadaki filmler listeleniyor..!------------------------------------------------------------------------------------");
		ArrayList<Movie> movieList = new ArrayList<Movie>();

		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from movie order by releaseDate desc");
			query.setFirstResult((pageNo - 1) * 21);
			query.setMaxResults(21);
			movieList = (ArrayList<Movie>) query.list();
			for (Movie movie : movieList) {
				System.out.println(movie.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return movieList;
	}

	@Override
	public long countAllMovie() {
		System.out.println("Tüm filmler sayýlýyor----------------------------------------------------------------------------------------------");
		return (Long) sessionFactory.getCurrentSession().createQuery("select count(id) from movie").list().iterator().next();
	}

	@Override
	public List<Movie> getNewMovieList() {
		// TODO Auto-generated method stub
		System.out.println("Tüm yeni film listesi çekiliyor----------------------------------------------------------------------------------------------");
		return sessionFactory.getCurrentSession().createQuery("from movie order by id desc").setFirstResult((int) Math.round((Math.random() * 0)) * 7).setMaxResults(7).list();
	}

	@Override
	public List<Movie> getPopulerMovies() {
		// TODO Auto-generated method stub
		System.out.println("Tüm filmler popüler filmler çekiliyor----------------------------------------------------------------------------------------------");
		return sessionFactory.getCurrentSession().createQuery("from movie order by hit desc").setFirstResult((int) Math.round((Math.random() * 0)) * 10).setMaxResults(10).list();
	}

	@Override
	public List<Movie> search(String movieName) {
		// TODO Auto-generated method stub
		System.out.println(movieName + " isilmli filmler aranýyor----------------------------------------------------------------------------------------------");
		return sessionFactory.getCurrentSession().createQuery("from movie where name like '%" + movieName + "%'").list();
	}

}
