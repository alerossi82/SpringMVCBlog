package controllers;

import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

import models.HomeViewModel;

@Controller
public class HomepageController {
	
	@RequestMapping (value="/home", method= RequestMethod.GET)
	
	//create model for view HOME.JSP
	//@ModelAttribute creates HomeViewModel object and autowire params from 
	//@RequestParam gets the value of "page" from URL and set initial value to 1
	public ModelAndView createHome (@ModelAttribute(value="hvm") HomeViewModel hvm,
									@RequestParam (value="page", defaultValue="1") int page) {
		
		ModelAndView model= new ModelAndView("home");
		
		try {
			
			//generate list of ID and name for all restaurants in tab Articolo
			hvm.generateListaAllArticoli();
			
			//generate list of articles to display in current page
			hvm.generateListaArticoliRM(page);
			
		} catch (SQLException e) {
			System.out.println("failed to create HomeViewModel");
			e.printStackTrace();
		}
		
		//hvm is automatically added to the model by @ModelAttribute 
		return model;
	}
 
}