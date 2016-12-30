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

//IMAGES MANAGER JSP
@Controller
public class imagesManagerController {
	
	// get the name of all images contained in img folder
	@RequestMapping(value = "/imagesManager", method = RequestMethod.GET)
	public ModelAndView readImages() {

		// create model and link it to jsp imagesManager
		ModelAndView model = new ModelAndView("imagesManager");

		// return content from images folder and add it to model
		File imgsPath = new File("C:/Users/Ale/workspace/SpringMVCBlog/WebContent/resources/img");
		String[] imgsNames = imgsPath.list();
		model.addObject("imgsNames", imgsNames);

		return model;
	}
	
	@RequestMapping(value = "/imagesManager", method = RequestMethod.POST)
	
	//upload new image to img folder
	public @ResponseBody String handleFileUpload (@RequestParam("file") MultipartFile file) {
		
		//get img name
		String imgName = file.getOriginalFilename();
		System.out.println(imgName);
		
		//create file path
		String folder = "C:/Users/Ale/workspace/SpringMVCBlog/WebContent/resources/img/";
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
				
				return "You successfully uploaded " + imgName + " into " + folder + "!";

			} catch (Exception e) {
				return "You failed to upload " + imgName + " => " + e.getMessage();
			}

		} else {
			return "You failed to upload because the file was empty.";
		}
    }

}

