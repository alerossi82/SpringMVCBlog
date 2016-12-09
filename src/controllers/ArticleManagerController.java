package controllers;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
	
	//use InitBinder to define date format
	@InitBinder
	public void customizeBinding (WebDataBinder binder) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); //set date format
		dateFormat.setLenient(false); //match exactly date format
		CustomDateEditor dateEditor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, dateEditor); 
		
	}
	
	@RequestMapping (value="/ArticleManager", method= RequestMethod.GET)
	
	//creates model and pass it to view ARTICLEMANAGER.JSP
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
	
	// insert, edit or delete article in DB
	@RequestMapping (value="/ArticleManager", method=RequestMethod.POST)
	
	public String editArticle (	Model model,
								@Valid @ModelAttribute (value="nea") NewEditArticolo nea, //create NewEditArticolo object, autowire attributes from ArticleManager.jsp, add to model and validate
							 	BindingResult result, //collect validation errors
							 	@RequestParam (value="submit") String submit) { //get input value from ArticleManager.jsp
		
		Articolo articolo1=nea.getArticolo();
		
		DAOArticolo daoArt = new DAOArticolo();
		
		//if validation fails, return form to display validation errors
		if (result.hasErrors()) {
			System.out.println("VALIDATION FAILED");
			return "ArticleManager";
		}

		else {
			System.out.println("VALIDATION WAS SUCCESFULL");
		}
		
		
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
		
		return submit;
		
	}
}