package controllers;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import models.HomeViewModel;

//creates model for VIEWARTICLE.JSP
@Controller
public class SingleArticleController {
	
	
	@RequestMapping (value="/viewArticle", method= RequestMethod.GET)
	
	//@ModelAttribute creates HomeViewModel object and autowire all attributes
	//@RequestParam gets param ID from URL
	public ModelAndView createViewArticle (@ModelAttribute(value="hvm") HomeViewModel hvm,
										   @RequestParam (value="ID") int ID) {
		
		//wire model to VIEWARTICLE.JSP
		ModelAndView model= new ModelAndView("viewArticle");
		
		try {
			
			//generate article based on ID from URL
			hvm.generateArticolo(ID);
			
			//generate list of all articles to display on sidebar
			hvm.generateListaAllArticoli();
			
		} catch (SQLException e) {
			System.out.println("failed to create HomeViewModel");
			e.printStackTrace();
		}

		return model;
	}
										   

}
