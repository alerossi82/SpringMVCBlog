package controllers;

import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import beans.ArticoloRM;
import models.HomeViewModel;

//generate list of all articles in DB and forward to view ADMIN.JSP
@Controller
public class AdminController {
	
	@RequestMapping (value="/admin", method= RequestMethod.GET)
	
	//@ModelAttribute to generate and autowire HomeViewModel object
	public ModelAndView createListaArticoli (@ModelAttribute(value="hvm") HomeViewModel hvm){
		
		ModelAndView model= new ModelAndView("admin");
		
		try {
			hvm.generateListaAllArticoli();
			
		} catch (SQLException e) {
			System.out.println("failed to generate all articles list");
			e.printStackTrace();
		}
		
		return model;
	}
	
}
