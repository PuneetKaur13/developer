package com.ncs.action;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ncs.dto.BuyerBiddingDTO;
import com.ncs.dto.CompanyProductIntersectionDTO;
import com.ncs.dto.ProductDTO;
import com.ncs.dto.UserDTO;
import com.ncs.form.ProductForm;
import com.ncs.services.ProductServiceI;
import com.ncs.utill.PropertyReader;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.action.NcsResponseData;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceI;

@RestController
@RequestMapping(value = "rest/product")
public class ProductCtl extends BaseCtl<ProductForm> {

	private static Logger logger = Logger.getLogger(ProductCtl.class);

	@Override
	@Autowired
	@Qualifier("productService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}

	@Autowired
	private ProductServiceI productService;
	
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
	public NcsResponseData displayAdd() {
		return new NcsResponseData();
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public NcsResponseData uploadFileHandler(@RequestPart(value = "file", required = false) MultipartFile file,
			@RequestParam("form") String data, HttpServletRequest request) {
		ncsResponseData = new NcsResponseData();
		try {
			ProductForm form = new ObjectMapper().readValue(data, ProductForm.class);
			ProductDTO dto = (ProductDTO) form.makeDto();
			if (file != null && !file.isEmpty()) {
				dto.setImagePath(PropertyReader.getValue("userImage") + file.getOriginalFilename());
				byte[] bytes = file.getBytes();
				String rootPath = request.getServletContext().getRealPath("/");
				File dir = new File(rootPath + "/userImage");
				if (!dir.exists()) {
					dir.mkdirs();
				}
				File serverFile = new File(dir.getAbsolutePath() + "/" + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
			}
			if (dto.getId() != null && dto.getId() > 0) {
				service.update(dto, null);
			} else {
				service.add(dto, null);
			}
			ncsResponseData.setForm(form);
			ncsResponseData.setSuccess(true);
			ncsResponseData.setMessage("Record has been saved successfully.");
		} catch (Exception e) {
			ncsResponseData.setSuccess(false);
			ncsResponseData.setMessage(e.getMessage());
		}
		return ncsResponseData;
	}

	public static void main(String[] args) throws Exception {
		File file = new File("C:/Users/ncs-pc/Desktop/OCBC/WebContent/images/userImage/file.jpg");
		System.out.println("file name" + file.getName());

	}
}