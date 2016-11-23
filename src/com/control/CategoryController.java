package com.control;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.CategoryDao;
import com.entities.Category;
import com.entities.Movie;
import com.services.CategoryService;

@Controller
@RequestMapping("category")
public class CategoryController {

	private static final Logger log = Logger.getLogger(CategoryController.class);

	@Autowired
	CategoryService categoryService;

	@RequestMapping("{categoryName}/movielist")
	public ModelAndView getMovieList(@PathVariable String categoryName, @RequestParam("page_no") Integer pageNo) {

		ModelAndView modelAndView = new ModelAndView("category");

		Category category = categoryService.getCategoryByName(categoryName);
		ArrayList<Movie> movieList = (ArrayList<Movie>) categoryService.getMovieListByCategoryId(category.getId(),
				pageNo);
		category.getMovieList().addAll(movieList);
		long totalMovie = categoryService.countMovieOfTheCategory(category.getId());
		modelAndView.addObject("totalMovie", totalMovie);
		modelAndView.addObject("categoryObj", category);

		return modelAndView;

	}

}
