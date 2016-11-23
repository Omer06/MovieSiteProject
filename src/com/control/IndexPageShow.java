package com.control;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.entities.Movie;
import com.services.MovieService;

@Controller
@SessionAttributes(names = "newMovieList")
public class IndexPageShow {
	
	@Autowired
	MovieService movieService;
	
	@RequestMapping(value = {"index","/"})
	public ModelAndView showIndexPage(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("index");
		
		modelAndView.addObject("newMovieList", movieService.getNewMovieList());
		modelAndView.addObject("movieList", movieService.getMovieListByPageOrder(getPageNo(request)));
		modelAndView.addObject("totalMovie", movieService.countAllMovie());
		
		return modelAndView;
	}
	
	@RequestMapping(value = "search" , method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> search(@RequestParam("movie_name") String movieName) {
		
		Map<String,Object> responseMap = new HashMap<String , Object>();
		
		ArrayList<Movie> movieList = (ArrayList<Movie>) movieService.search(movieName);
		
		if(movieList != null) {
			responseMap.put("movieList", movieList);
		}
		else {
			responseMap.put("message", "Filmler aranýrken beklenmedik bi hata oluþtu");
		}
		
		return responseMap;
		
	}
	
	
	public int getPageNo(HttpServletRequest request) {
		int pageNo = 1;
		
		if(request.getParameter("page_no") != null)
			pageNo = Integer.valueOf(request.getParameter("page_no"));
		
		return pageNo;
	}
}
