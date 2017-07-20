package com.ncs.pdf;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.dto.SellerBiddingDTO;
import com.ncs.dto.UserDTO;
import com.ncs.form.SellerBiddingForm;
import com.ncs.services.SellerBiddingServiceI;
import com.nenosystems.common.action.NcsResponseData;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.util.DataValidator;

@RestController
@RequestMapping(value = "/PDFSellerAdmin")
public class PdfControllerAdminSeller {
	
	@Autowired
	private SellerBiddingServiceI durationService;

	@RequestMapping(value = "/downloadPDFSellerAdmin", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData downloadPDFSellerAdmin(@RequestBody SellerBiddingForm form, HttpSession session,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(SellerBiddingDTO.class);
		if (!DataValidator.isNull(form.getPackaging())) {
			sc.setAttribute("=packaging", form.getPackaging());
		}

		if (!DataValidator.isNull(form.getStateName())) {
			sc.setAttribute("=stateName", form.getStateName());
		}
		if (!DataValidator.isNull(form.getStartDate())) {
			sc.setAttribute(">=startDate", form.getStartDate());
		}
		if (!DataValidator.isNull(form.getEnddate())) {
			sc.setAttribute("<=enddate", form.getEnddate());
		}

		List list = durationService.find(sc, ctx);
		final ServletContext servletContext = request.getSession().getServletContext();
		final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		final String temperotyFilePath = tempDirectory.getAbsolutePath();

		String fileName = "testpdf.pdf";
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "attachment; filename=" + fileName);

		try {

			PdfBuilderAdminSeller.createPDF(temperotyFilePath + "\\" + fileName, list, form);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "\\" + fileName);
			OutputStream os = response.getOutputStream();
			baos.writeTo(os);
			os.flush();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return ncsResponseData;
	}

	private ByteArrayOutputStream convertPDFToByteArrayOutputStream(String fileName) {

		InputStream inputStream = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {

			inputStream = new FileInputStream(fileName);
			byte[] buffer = new byte[1024];
			baos = new ByteArrayOutputStream();

			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesRead);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return baos;
	}

	private UserContext getUserContext(HttpSession session) {
		UserContext context = (UserContext) session.getAttribute("ctx");
		if (context == null) {
			context = new UserContext();
		}
		return context;
	}

}
