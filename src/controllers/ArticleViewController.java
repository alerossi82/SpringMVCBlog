package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import models.ArticleViewModel;

//create model for viewArticle.jsp
@Controller
public class ArticleViewController {
	
	@RequestMapping(value = "/viewArticle", method = RequestMethod.GET) 
		
		// @ModelAttribute creates HomeViewModel object and autowire all attributes
		// @RequestParam gets param ID from URL
		public ModelAndView articleModel (@ModelAttribute(value = "avm") ArticleViewModel avm,
										  @RequestParam(value = "ID") int ID) {
		
		//wire model to VIEWARTICLE.JSP
		ModelAndView model = new ModelAndView("viewArticle");
		
		// generate article based on ID from URL
		avm.generateArticolo(ID);
		
		// check if user is logged in
		model.addObject("user", GetLoggedinUser.getPrincipal());
		
		//avm is automatically added to the model by @ModelAttribute
		return model;

		
	}
	
}
