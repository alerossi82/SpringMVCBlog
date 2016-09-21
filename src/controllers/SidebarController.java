package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import models.SidebarViewModel;

@Controller
public class SidebarController {
	
	//specify URL invoking this controller
	@RequestMapping (value = "/sidebar", method = RequestMethod.GET)
	
	//create sidebarModel object and add it to model
	public ModelAndView sidebarModel (@ModelAttribute (value= "svm") SidebarViewModel svm) {
	
	//create model and wire it to view
	ModelAndView model = new ModelAndView("sidebar");
		
	//create sidebar list
	svm.generateListaAllArticoli();
	
	return model;
		
	}
}

