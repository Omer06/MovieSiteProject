package com.control;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dao.EntityDao;
import com.entities.Category;
import com.entities.Director;
import com.entities.ImdbPoint;
import com.entities.Language;
import com.entities.Movie;
import com.services.EntityService;

@Controller
@RequestMapping("admin/newmovie")
public class NewMovieController {

	@Autowired
	@Qualifier("entityServiceImpl")
	EntityService entityService;

	@RequestMapping(value = "form")
	public ModelAndView showNewMovieForm() {
		ModelAndView modelAndView = new ModelAndView("/admin/newmovie" , "newMovieObj" , new Movie());
		
		// Bu veritabanýndan çektiðimiz verileri Formun menulerine koyacaðýmýz için çekiyoruz
		modelAndView.addObject("directorList", entityService.getList("director"));
		modelAndView.addObject("languageList", entityService.getList("language"));
		modelAndView.addObject("imdbPointList", entityService.getListByDesc("imdbPoint","point"));
		
		return modelAndView;
	}

	@RequestMapping("save")
	public ModelAndView save(@ModelAttribute Movie newMovieObj, BindingResult result,
			@RequestParam("posterImg") MultipartFile posterImg, HttpServletRequest request) {
		System.out.println("film girdi");
		boolean posterFileHasError = setPosterPlace(posterImg,
				request.getServletContext().getRealPath("/") + "WEB-INF/images/");
		newMovieObj.setPosterPath(posterImg.getOriginalFilename());

		// Seçilen kategorilerin idleyile obje oluþturup olarak filmin içine
		// atýyoruz
		String[] categoryIdList = request.getParameterValues("categoryIdOfTheMovie");
		for (String id : categoryIdList) {
			newMovieObj.getCategoryList().add(new Category(Integer.valueOf(id)));
		}

		if (result.hasErrors() || posterFileHasError) {
			System.out
					.println("result Handler : " + result.hasErrors() + " PosterFileHasError : " + posterFileHasError);
			ModelAndView modelAndView = new ModelAndView("admin/newmovie", "result",
					" Film Yüklenirken Hata Oluþtu. \n Filminiz Düzgün Kayýt Edilmemiþ Olabilir. \n Kontrol Ediniz..!");
			modelAndView.addObject("newMovieObj", newMovieObj);
			return modelAndView;
		}
		
		entityService.saveOrUpdate(newMovieObj);
		
		return new ModelAndView("redirect:/admin/newmovie/form?username=admin&password=e050f626b6b5407da68be29e0d8965d9d8d5ec40eca3d3b802a9bf9853a2926bd819401e8884f26de050f626b6b5407da68be29e0d8965d9d8d5ec40eca3d3b802a9bf9853a2926bd819401e8884f26de050f626b6b5407da68be29e0d8965d9d8d5ec40eca3d3b802a9bf9853a2926bd819401e8884f26d");
	}

	// Film için seçilen resim dosyasýný ayarlanan klasöre yerleþtiriyoruz
	private boolean setPosterPlace(MultipartFile posterImg, String path) {
		boolean errorControll = false;
		System.out.println("path :" + path + " " + posterImg == null);

		try {

			if (!new File(path).exists())
				new File(path).mkdirs();

			if (posterImg != null) {
				posterImg.transferTo(new File(path + posterImg.getOriginalFilename()));
				System.out.println("Poster File Kayýt Edildi : " + path + posterImg.getOriginalFilename());
			}

		} catch (Exception e) {
			errorControll = true;
			System.out.println("Resim Yüklenirken Hata Oluþtu");
			e.printStackTrace();
		}

		return errorControll;
	}

}
