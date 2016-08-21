package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	// /login URL is called by Spring Security to access protected pages
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)

	public ModelAndView createLoginPage(
			// get params error and logout from URL, if available
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView("login");

		// if login failed, add error message to model
		if (error != null) {
			model.addObject("error", "Invalid username or password");
		}

		// if logged out, add logout message to model
		if (logout != null) {
			model.addObject("logout", "You have been logged out");
		}
		
		//check if user is logged in
		model.addObject("user", GetLoggedinUser.getPrincipal());
				
		return model;

	}

	// logout user
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {

		// check if user is authenticated
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		// if user authenticated, executes logout
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		// redirect to view LOGIN.jsp
		return "redirect:/login?logout";
	}
}
