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
									@RequestParam(value = "error1", required = false) String error1,
									@RequestParam(value = "error2", required = false) String error2,
									@RequestParam (value = "uploaded", required = false) String uploaded,
									@RequestParam (value="deleted", required = false) String deleted) {
		
		// create model and link it to jsp imagesManager
		ModelAndView model = new ModelAndView("imagesManager");

		// return content from images folder and add it to model
		File imgsPath = new File("C:/Users/Ale/workspace/SpringMVCBlog/WebContent/resources/img/");
		
		String[] imgsNames = imgsPath.list();
		
		model.addObject("imgsNames", imgsNames);
		
		//if upload fails, display error message
		String message=null;
		
		if (error0!=null) {
			message="No file selected";
		}
		
		else if (error1!=null) {
			message="This file type is not supported";
		}
		
		else if (error2!=null) {
			message="The selected file exceeds the size limit (max. 1 MB)";
			
		}
		
		else if (uploaded!=null) {
			message = "File uploaded";
		}
		
		else if (deleted!=null) {
			message = "File deleted";
		}
		
		model.addObject("message", message);

		return model;
	}
	
	
	//UPLOAD FILE TO HD
	@RequestMapping(value = "/imagesManager/upload", method = RequestMethod.POST)
	public String handleFileUpload (@RequestParam("file") MultipartFile file) {
		
		//get file extension
		String imgName = file.getOriginalFilename(); //get file name
		int index=imgName.lastIndexOf("."); //get position of last "."
		String extension=imgName.substring(index+1); //get all chars after last "."
		
		//get file size
		long size = file.getSize();
		
		
		//validate if a file was selected, file size and type
		 if (file.isEmpty()) {
			return "redirect:/imagesManager?error0";
		}

		if (!extension.matches("jpg|tif|png|gif")) {
			return "redirect:/imagesManager?error1";
		}
		
		if (size>1048576) {
			return "redirect:/imagesManager?error2";
		}
		
		
		//if validation is succefull, upload file to folder
		else {

			// create file path
			String folder = "C:/Users/Ale/workspace/SpringMVCBlog/WebContent/resources/img/";
			File path = new File(folder + imgName);
			
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
				return "redirect:/imagesManager?uploaded";

			} catch (Exception e) {
				return "You failed to upload " + imgName + " => " + e.getMessage();
			}
		}

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
			return "redirect:/imagesManager?deleted";

		} else {
			return "Delete operation failed";
		}
	}
}