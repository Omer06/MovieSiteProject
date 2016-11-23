package com.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dao.EntityDao;
import com.entities.Comment;
import com.entities.Movie;
import com.services.EntityService;

@Controller
@RequestMapping("admin/newcomment")
public class NewCommentControll {

	@Autowired
	@Qualifier("entityServiceImpl")
	EntityService entityService;

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> save(Comment comment, @RequestParam("movie_id") Integer movieId) {

		Map<String, Object> response = new HashMap<String, Object>();

		Movie movie = (Movie) entityService.getEntityById(Movie.class, movieId);
		movie.getCommentList().add(comment);
		comment.setDate(new Date());

		if (entityService.saveOrUpdate(movie)) {
			response.put("commentList", movie.getCommentList());
			response.put("message", "Baþarýyla yorumunuz filme eklendi");
		}
		else {
			response.put("message", "Yorumu eklerken bir hata oluþtu");
		}

		return response;
	}

}
