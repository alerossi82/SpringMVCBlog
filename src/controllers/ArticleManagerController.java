package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import models.NewEditArticolo;

@Controller
public class ArticleManagerController {
	
	@RequestMapping (value="/ArticleManager", method= RequestMethod.GET)
	
	//creates article model and pass it to view ARTICLEMANAGER.JSP
	public ModelAndView createArticleManager (@ModelAttribute (value="nea") NewEditArticolo nea,
											  @RequestParam (value="IDarticolo") int IDarticolo) {
		
		ModelAndView model=new ModelAndView("ArticleManager");
		
		//creates article based on ID from URL
		//if ID=0, creates a blank model
		nea.getArticolo(IDarticolo);
		
		return model;
		
	}
		
}