package controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class imagesManagerController {
	
	// READ ALL FILES FROM IMG FOLDER
	@RequestMapping(value = "/imagesManager",  method = RequestMethod.GET)
	public ModelAndView readImages
	(@RequestParam(value = "error", required = false) String error) {

		// create model and link it to jsp imagesManager
		ModelAndView model = new ModelAndView("imagesManager");

		// return content from images folder and add it to model
		File imgsPath = new File("C:/Users/Alessandro/workspace/SpringMVCBlog/WebContent/resources/img");
		String[] imgsNames = imgsPath.list();
		model.addObject("imgsNames", imgsNames);
		
		//if upload fails, display error message
		if (error != null) {
			model.addObject("error",
					"Please select a file to upload");
		}

		return model;
	}
	
	
	
	
	//UPLOAD FILE TO HD
	@RequestMapping(value = "/imagesManager/upload", method = RequestMethod.POST)
	public String handleFileUpload (@RequestParam("file") MultipartFile file) {
		
		//get img name
		String imgName = file.getOriginalFilename();
		System.out.println(imgName);
		
		//create file path
		String folder = "C:/Users/Alessandro/workspace/SpringMVCBlog/WebContent/resources/img/";
		File path = new File (folder+imgName);
		System.out.println(path);

		if (!file.isEmpty()) {
			
			try {
				//get bytes array from file
				byte[] bytes = file.getBytes();
				
				//create output stream
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(path));
			
				//write img content on path
				stream.write(bytes);
				
				//close stream
				stream.close();
				
				//if upload is successful, reload page
				return "redirect:/imagesManager";

			} catch (Exception e) {
				return "You failed to upload " + imgName + " => " + e.getMessage();
			}

		} else {
			return "redirect:/imagesManager?error";
		}
    }
	
	
	// DELETE FILE FROM HD
	@RequestMapping(value = "/imagesManager/delete", method = RequestMethod.POST)
	public String deleteFile(@RequestParam (value="imgName") String imgName) {
		
		//create file path to be deleted
		String folder = "C:/Users/Alessandro/workspace/SpringMVCBlog/WebContent/resources/img/";
		File path = new File (folder+imgName);

		// delete file
		if (path.delete()) {
			//if delete is successful, reload page
			return "redirect:/imagesManager";
			
		} else {
			return "Delete operation failed";
		}
	}
}

