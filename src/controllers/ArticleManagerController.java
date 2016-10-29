package controllers;

import java.sql.SQLException;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
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
	/*public String createArticleManager(Map<String, Object> model) {
		
		Articolo articolo = new Articolo();
		model.put("articolo1", articolo);
		return "ArticleManager";
		
	}*/
	
public ModelAndView createArticleManager(@RequestParam(value = "IDarticolo") int IDarticolo) {
		
		ModelAndView model=new ModelAndView("ArticleManager");
		
		//get article based on ID number from URL
		//if ID=0, creates empty model (new article)

			try {
				NewEditArticolo nea = new NewEditArticolo(IDarticolo);
				model.addObject("nea", nea);

			}

			catch (SQLException e) {
				System.out.println("failed to generate model for article with ID " + IDarticolo);
				e.printStackTrace();
			}

		return model;
		
	}
	
	
	@RequestMapping (value="/ArticleManager", method= RequestMethod.POST)
	
	// insert, edit or delete article in DB
	// map POST method to URL from form in view ArticleManager.jsp
	/*public String editArticle(@Valid @ModelAttribute("articolo1") Articolo articolo1,
									BindingResult result) {

		// if validation fails, return ArticleManager form displaying error
		// messages
		if (result.hasErrors()) {
			System.out.println("VALIDATION FAILED");
			return "ArticleManager";

		}
		
		System.out.println("VALIDATION WAS SUCCESSFULL");
		return "admin";
	}*/

	
	//create Articolo object and map attributes to values from ARTICLEMANAGER.JSP
		public String editArticle (	@Valid @ModelAttribute ("articolo1") Articolo articolo1, 
								 	@ModelAttribute (value="daoArt") 	DAOArticolo daoArt,
								 	@RequestParam 	(value="submit") 	String submit,
								 	BindingResult result)	{
			
			//if validation fails, return ArticleManager form displaying error messages
			if (result.hasErrors()) {
				System.out.println("VALIDATION FAILED");
				return "ArticleManager";
			}
			
			//if validation is succesfull
			else {
				System.out.println("VALIDATION WAS SUCCESFULL");
			switch (submit) {

			case "SUBMIT": {

				// INSERT new article
				if (articolo1.getId() == 0) {

					try {
						daoArt.insert(articolo1);
						System.out.println("new article was created");
						return "redirect:/admin?insert";

					} catch (Exception  e) {
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

					} catch (Exception  e) {
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

				} catch (Exception  e) {
					System.out.println("failed to delete article");
					e.printStackTrace();
				}
				
				break;
				}

				}
			}

			return submit;

		}

}