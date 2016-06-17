package controllers;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import DAO.DAOArticolo;
import beans.Articolo;
import models.NewEditArticolo;

@Controller
public class ArticleManagerController {
	
	@RequestMapping (value="/ArticleManager", method= RequestMethod.GET)
	
	//creates article model and pass it to view ARTICLEMANAGER.JSP
	public ModelAndView createArticleManager (@ModelAttribute	(value="nea") 		 NewEditArticolo nea,
											  @RequestParam 	(value="IDarticolo") int IDarticolo) {
		
		ModelAndView model=new ModelAndView("ArticleManager");
		
		//get article based on ID number from URL
		//if ID=0, creates a blank model
		nea.getArticolo(IDarticolo);
		
		// check is user is logged in
		model.addObject("user", GetLoggedinUser.getPrincipal());
		
		return model;
		
	}
	
	// insert, edit or delete article in DB
	// map POST method to URL from form in view ArticleManager.jsp
	@RequestMapping (value="/editArticle", method=RequestMethod.POST)
	
	//create Articolo object and map attributes to values from ARTICLEMANAGER.JSP
	public String editArticle (	@ModelAttribute (value="articolo1") Articolo articolo1, 
							 	@ModelAttribute (value="daoArt") 	DAOArticolo daoArt,
							 	@RequestParam 	(value="submit") 	String submit){
		
		switch (submit) {

		case "SUBMIT": {

			// INSERT new article
			if (articolo1.getId() == 0) {

				try {
					daoArt.insert(articolo1);
					System.out.println("new article was created");
					return "redirect:/admin?insert";

				} catch (SQLException e) {
					System.out.println("failed to create new article");
					e.printStackTrace();
				}
			}

			// UPDATE article
			else {

				try {
					daoArt.update(articolo1);
					System.out.println("article was updated");
					return "redirect:/admin?update"; 

				} catch (SQLException e) {
					System.out.println("failed to update article");
					e.printStackTrace();
				}
			}
			
			break;
		}
		
		//DELETE article
		case "DELETE ARTICLE": {

			try {
				daoArt.delete(articolo1);
				System.out.println("article was deleted");
				return "redirect:/admin?delete"; 

			} catch (SQLException e) {
				System.out.println("failed to delete article");
				e.printStackTrace();
			}
			
			break;
		}

		}
		
		return submit;
		
	}
}