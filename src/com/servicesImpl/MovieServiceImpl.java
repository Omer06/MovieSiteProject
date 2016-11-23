package com.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MovieDao;
import com.entities.Movie;
import com.services.MovieService;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	MovieDao movieDao;
	
	@Override
	public List getList(String entityName) {
		// TODO Auto-generated method stub
		return movieDao.getList(entityName);
	}

	@Override
	public boolean delete(Object entity) {
		// TODO Auto-generated method stub
		return movieDao.delete(entity);
	}

	@Override
	public boolean saveOrUpdate(Object entity) {
		// TODO Auto-generated method stub
		return movieDao.saveOrUpdate(entity);
	}

	@Override
	public List getListByDesc(String entityName , String descField) {
		// TODO Auto-generated method stub
		return movieDao.getListByDesc(entityName , descField);
	}

	@Override
	public Object getEntityById(Class<?> clazz, int id) {
		// TODO Auto-generated method stub
		return movieDao.getEntityById(clazz, id);
	}

	@Override
	public void hitUpdate(Movie movie) {
		// TODO Auto-generated method stub
		movieDao.hitUpdate(movie);
	}

	@Override
	public List<Movie> getMovieListByPageOrder(int pageNo) {
		// TODO Auto-generated method stub
		return movieDao.getMovieListByPageOrder(pageNo);
	}

	@Override
	public long countAllMovie() {
		// TODO Auto-generated method stub
		return movieDao.countAllMovie();
	}

	@Override
	public List<Movie> getNewMovieList() {
		// TODO Auto-generated method stub
		return movieDao.getNewMovieList();
	}

	@Override
	public List<Movie> getPopulerMovies() {
		// TODO Auto-generated method stub
		return movieDao.getPopulerMovies();
	}

	@Override
	public List<Movie> search(String movieName) {
		// TODO Auto-generated method stub
		return movieDao.search(movieName);
	}

}
