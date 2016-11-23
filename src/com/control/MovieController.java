package com.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.entities.Movie;
import com.services.EntityService;
import com.services.MovieService;

@Controller
@RequestMapping("movie")
public class MovieController {
	
	@Autowired
	@Qualifier("movieServiceImpl")
	MovieService movieService;
	
	@RequestMapping("getmovie")
	public ModelAndView getMovieById(@RequestParam("movie_id") Integer movieId) {
		
		Movie movie = (Movie) movieService.getEntityById(Movie.class, movieId);
		
		movieService.hitUpdate(movie);
		
		return new ModelAndView("movie","movieObj", movie);
	}
	
}
