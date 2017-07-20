package com.ncs.action;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.dto.BuySupplierDTO;
import com.ncs.dto.BuyerBiddingDTO;
import com.ncs.dto.CompanyDTO;
import com.ncs.dto.NotificationDTO;
import com.ncs.dto.UserDTO;
import com.ncs.form.AdminProductForm;
import com.ncs.form.BuySupplierForm;
import com.ncs.form.BuyerBiddingForm;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.action.NcsResponseData;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.exception.DuplicateRecordException;
import com.nenosystems.common.services.BaseServiceI;

@RestController
@RequestMapping(value = "rest/BuySupplier")
public class BuySupplierCtl extends BaseCtl<BuySupplierForm> {
	private static Logger log = Logger.getLogger(BuySupplierCtl.class);

	@Override
	@Autowired
	@Qualifier("buySupplierService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}
	

	@RequestMapping(value = "/searchByUser", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData search(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(BuySupplierDTO.class);
		sc.setAttribute("=createdBy", userDTO.getLoginId());
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public NcsResponseData submitAdd(@RequestBody BuySupplierForm form, HttpSession session) {
		BuySupplierDTO dto = (BuySupplierDTO) form.makeDto();
		ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		List<Object[]> uniqueAttributes = new ArrayList<Object[]>();
		uniqueAttributes.add(new Object[] { "packaging", dto.getPackaging() });
		uniqueAttributes.add(new Object[] { "&", "&" });
		uniqueAttributes.add(new Object[] { "productId", dto.getProductId() });
		uniqueAttributes.add(new Object[] { "&", "&" });
		uniqueAttributes.add(new Object[] { "createdBy", userDTO.getLoginId()});
		uniqueAttributes.add(new Object[] { "&", "&" });
		uniqueAttributes.add(new Object[] { "productName", dto.getProductName()});
		uniqueAttributes.add(new Object[] { "&", "&" });
		uniqueAttributes.add(new Object[] { "productId", dto.getProductId()});
		uniqueAttributes.add(new Object[] { "&", "&" });
		uniqueAttributes.add(new Object[] { "companyName", dto.getCompanyName()});
		uniqueAttributes.add(new Object[] { "&", "&" });
		uniqueAttributes.add(new Object[] { "companyId", dto.getCompanyId()});
		dto.setUniqueAttributes(uniqueAttributes);
		NcsResponseData ncsResponseData = new NcsResponseData();
		try {
			SearchCriteria sc = new SearchCriteria();
			sc.setDto(BuySupplierDTO.class);
			List list = service.find(sc, ctx);
			dto.setCreatedBy(ctx.getCreatedBy());
			dto.setModifiedBy(ctx.getModifiedBy());
			service.add(dto, ctx);
			ncsResponseData.setForm(form);
			ncsResponseData.setSuccess(true);
			ncsResponseData.setMessage("Record has been added successfully.");
		} catch (DuplicateRecordException e) {
			ncsResponseData.setMessage("Record is already exist.");
		} catch (Exception e) {
			ncsResponseData.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return ncsResponseData;
	}

	

	
}