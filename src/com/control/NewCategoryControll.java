package com.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.EntityDao;
import com.entities.Category;
import com.entities.Movie;
import com.services.EntityService;

@Controller
@RequestMapping("admin/newcategory")
public class NewCategoryControll {
	
	@Autowired
	@Qualifier("entityServiceImpl")
	EntityService entityService;
	
	@RequestMapping("save")
	public ModelAndView addCategory(Category category) {
		
		boolean hasError = entityService.saveOrUpdate(category);
		
		if(hasError) {
			ModelAndView modelAndView = new ModelAndView("admin/newmovie","newMovieObj" , new Movie());
			modelAndView.addObject("result", "Kategori Yüklenirken Hata Oluþtu!");
		}
		
		return new ModelAndView("redirect:/admin/newmovie/form?username=admin&password=e050f626b6b5407da68be29e0d8965d9d8d5ec40eca3d3b802a9bf9853a2926bd819401e8884f26de050f626b6b5407da68be29e0d8965d9d8d5ec40eca3d3b802a9bf9853a2926bd819401e8884f26de050f626b6b5407da68be29e0d8965d9d8d5ec40eca3d3b802a9bf9853a2926bd819401e8884f26d");
	}

}
