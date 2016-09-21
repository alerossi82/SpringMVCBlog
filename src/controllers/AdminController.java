package controllers;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import beans.ArticoloRM;
import models.AdminViewModel;
import models.HomeViewModel;

@Controller
public class AdminController {
	
	@RequestMapping (value="/admin", method= RequestMethod.GET)
	
	public ModelAndView createListaArticoli (@ModelAttribute(value="advm") AdminViewModel hvm,
											 @RequestParam (value = "insert", required = false) String insert,
											 @RequestParam (value = "update", required = false) String update,
											 @RequestParam (value = "delete", required = false) String delete){
		
		ModelAndView model= new ModelAndView("admin");
		
		hvm.generateListaAllArticoli();
		
		//check if user is logged in
		model.addObject("user", GetLoggedinUser.getPrincipal());
		
		//check if an article was created, updated or deleted
		if (insert != null) {
			model.addObject("message", "NEW ARTICLE WAS CREATED");
		}

		if (update != null) {
			model.addObject("message", "ARTICLE WAS UPDATED");
		}

		if (delete != null) {
			model.addObject("message", "ARTICLE WAS DELETED");
		}
		
		
		return model;
	}
	
}