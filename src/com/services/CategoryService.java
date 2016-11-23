package com.services;

import java.util.List;

import com.entities.Category;
import com.entities.Movie;

public interface CategoryService extends EntityService {
	
	public List<Movie> getMovieListByCategoryId(int categoryId, int pageNo) ;
	
	public long countMovieOfTheCategory(int categoryId) ; 
	
	public Category getCategoryByName (String categoryName);

}
