package controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class imagesManagerController {
	
	// READ ALL FILES FROM IMG FOLDER
	@RequestMapping(value = "/imagesManager",  method = RequestMethod.GET)
	
	public ModelAndView readImages (@RequestParam(value = "error0", required = false) String error0,
									@RequestParam(value = "error1", required = false) String error1) {
		
		/*//get absolute path
		String filePath = new File("").getAbsolutePath();
		System.out.println(filePath);
		
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("/img/pizza nuova");
		System.out.println(path);*/
		
		// create model and link it to jsp imagesManager
		ModelAndView model = new ModelAndView("imagesManager");

		// return content from images folder and add it to model
		File imgsPath = new File("C:/Users/Ale/workspace/SpringMVCBlog/WebContent/resources/img/");
		
		String[] imgsNames = imgsPath.list();
		
		model.addObject("imgsNames", imgsNames);
		
		//if upload fails, display error message
		String error;
		
		if (error0!=null) {
			error="The selected file exceeds the size limit or no file was selected";
			model.addObject("error", error);
		}
		
		else if (error1!=null) {
			error="This file type is not supported";
			model.addObject("error", error);
		}

		return model;
	}
	
	
	
	
	//UPLOAD FILE TO HD
	@RequestMapping(value = "/imagesManager/upload", method = RequestMethod.POST)
	public String handleFileUpload (@RequestParam("file") MultipartFile file) {
		
		//get file name
		String imgName = file.getOriginalFilename();
		
		//get file extension
		int index=imgName.lastIndexOf("."); //get position of last "."
		String extension=imgName.substring(index+1); //get all chars after last "."
		
		//get file size
		long size = file.getSize();
		
		//create file path
		String folder = "C:/Users/Ale/workspace/SpringMVCBlog/WebContent/resources/img/";
		File path = new File (folder+imgName);
		
		//validate file exists, size and type
		if (!file.isEmpty() 
			&& extension.matches("jpg|tif|png|gif|jpeg") 
			&& size <= 1048576) {

			try {
				// get bytes array from file
				byte[] bytes = file.getBytes();

				// create output stream
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(path));

				// write img content on path
				stream.write(bytes);

				// close stream
				stream.close();

				// if upload is successful, reload page
				return "redirect:/imagesManager";

			} catch (Exception e) {
				return "You failed to upload " + imgName + " => " + e.getMessage();
			}
		}
		
		 else if (file.isEmpty()||size>1048576) {
			return "redirect:/imagesManager?error0";
		}

		else if (!extension.matches("jpg|tif|png|gif")) {
			return "redirect:/imagesManager?error1";
		}
		
		return "File upload complete";

	}
	
	
	// DELETE FILE FROM HD
	@RequestMapping(value = "/imagesManager/delete", method = RequestMethod.POST)
	public String deleteFile(@RequestParam (value="imgName") String imgName) {
		
		//create file path to be deleted
		String folder = "C:/Users/Ale/workspace/SpringMVCBlog/WebContent/resources/img/";
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



