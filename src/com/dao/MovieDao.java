package com.dao;

import java.util.List;

import com.entities.Movie;

public interface MovieDao extends EntityDao {
	
	public void hitUpdate(Movie movie) ;
	
	public List<Movie> getMovieListByPageOrder(int pageNo);
	
	public long countAllMovie() ;
	
	public List<Movie> getNewMovieList();
	
	public List<Movie> getPopulerMovies();
	
	public List<Movie> search(String movieName);
}
