package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccessDeniedController {
	
	//if user access is denied, display view AccessDenied
	@RequestMapping (value="/AccessDenied", method=RequestMethod.GET)
	public ModelAndView accessDenied () {
		
		//get username using static method getPrincipal
		String username= GetLoggedinUser.getPrincipal();
		
		ModelAndView model = new ModelAndView("AccessDenied");

		//add username to model
		model.addObject("username", username);
		
		return model;
		
	}
}
