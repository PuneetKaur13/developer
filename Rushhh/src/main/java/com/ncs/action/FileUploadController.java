package com.ncs.action;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ncs.form.ProductForm;
import com.nenosystems.common.action.NcsResponseData;

/**
 * Handles requests for the application file upload requests
 */
@RestController
public class FileUploadController {

	private static final Logger logger = LoggerFactory
			.getLogger(FileUploadController.class);

	@RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
	public NcsResponseData displayAdd() {
		return new NcsResponseData();
	}

	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public NcsResponseData uploadFileHandler(
			@RequestParam("file") MultipartFile file,
			@RequestParam("form") String fo) {
		ProductForm form = null;
		try {
			form = new ObjectMapper().readValue(fo, ProductForm.class);
		} catch (JsonParseException e1) {
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		NcsResponseData ncsResponseData = new NcsResponseData();
		String name = file.getName();
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				System.out.println("From " + form);
				// Creating the directory to store file
				// String rootPath = System.getProperty("catalina.home");
				String rootPath = "C:/mytemp";
				// File dir = new File(rootPath + File.separator + "tmpFiles");
				File dir = new File(rootPath);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server

				System.out.println("Name : " + name);
				// File serverFile = new File(dir.getAbsolutePath()
				// + File.separator + name);
				File serverFile = new File(dir.getAbsolutePath() + "/" + name
						+ ".jpg");
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location="
						+ serverFile.getAbsolutePath());

				// ncsResponseData.setForm(form);
				ncsResponseData.setSuccess(true);
				ncsResponseData
						.setMessage("Record has been added successfully.");
			} catch (Exception e) {
				ncsResponseData.setMessage(e.getMessage());
			}
		} else {
			ncsResponseData.setMessage("Record is already exist.");
		}
		return ncsResponseData;
	}

	/**
	 * Upload multiple file using Spring Controller
	 */
	@RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
	public @ResponseBody
	String uploadMultipleFileHandler(@RequestParam("name") String[] names,
			@RequestParam("file") MultipartFile[] files) {

		if (files.length != names.length)
			return "Mandatory information missing";

		String message = "";
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			String name = names[i];
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location="
						+ serverFile.getAbsolutePath());

				message = message + "You successfully uploaded file=" + name
						+ "<br />";
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		}
		return message;
	}
}
