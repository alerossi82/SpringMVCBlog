package controllers;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;
import models.HomeViewModel;

//create models for views Home and viewArticle
@Controller
public class HomepageController {
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	//create model for view HOME.JSP
	// @ModelAttribute creates HomeViewModel object and autowire params from view HOME
	// @RequestParam gets the value of "page" from URL and set initial value to 1
	public ModelAndView createHome(HttpServletRequest request,
								   @ModelAttribute(value = "hvm") HomeViewModel hvm,
								   @RequestParam(value = "page", defaultValue = "1") int page) {
		
		//wire model to HOME.JSP
		ModelAndView model = new ModelAndView("home");
		
		//store page in session
		request.getSession().setAttribute("page", page);
		
		// generate list of articles to display in current page
		hvm.generateListaArticoliRM(page);

		// check if user is logged in
		model.addObject("user", GetLoggedinUser.getPrincipal());

		// hvm is automatically added to the model by @ModelAttribute
		return model;
	}
}
	