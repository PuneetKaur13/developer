package com.ncs.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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

import com.ncs.dto.BuyerBiddingDTO;
import com.ncs.dto.BuyerQuotationDTO;
import com.ncs.dto.CompanyDTO;
import com.ncs.dto.CounterOfferDTO;
import com.ncs.dto.MakeQuotationDTO;
import com.ncs.dto.NonPreferredSupplierDTO;
import com.ncs.dto.OrganizationDTO;
import com.ncs.dto.PreferredSupplierDTO;
import com.ncs.dto.SellSupplierDTO;
import com.ncs.dto.UserDTO;
import com.ncs.form.BuyerBiddingForm;
import com.ncs.form.BuyerQuotationForm;
import com.ncs.form.OrganizationForm;
import com.ncs.form.PreferredSupplierForm;
import com.ncs.form.SellSupplierForm;
import com.ncs.services.BuyerBiddingServiceI;
import com.ncs.services.CompanyServiceI;
import com.ncs.services.MakeQuotationServiceI;
import com.ncs.services.PreferredSupplierServiceI;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.action.NcsResponseData;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;

import com.nenosystems.common.exception.DuplicateRecordException;
import com.nenosystems.common.services.BaseServiceI;

@RestController
@RequestMapping(value = "rest/PreferredSupllier")
public class PreferredSupplierCtl extends BaseCtl<PreferredSupplierForm> {

	private static Logger log = Logger.getLogger(PreferredSupplierCtl.class);

	@Override
	@Autowired
	@Qualifier("preferredSupplierService")
	public void setService(BaseServiceI service) {
		this.service = service;

	}

	@Autowired
	private CompanyServiceI companyServiceI;

	@Autowired
	private BuyerBiddingServiceI biddingService;

	@Autowired
	private PreferredSupplierServiceI preferredSupplierServiceI;

	@Autowired
	private MakeQuotationServiceI makeQuotationService;

	@RequestMapping(value = "/viewUser/{bidId}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData viewCounter(@PathVariable Long bidId, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(MakeQuotationDTO.class);
		sc.setAttribute("=bidId", bidId);
		List list = makeQuotationService.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	public NcsResponseData submitAdd(@RequestBody SellSupplierForm form, HttpSession session) {
		SellSupplierDTO dto = (SellSupplierDTO) form.makeDto();
		ctx = getUserContext(session);
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		try {
			SearchCriteria sc = new SearchCriteria();
			sc.setDto(BuyerBiddingDTO.class);
			List list = service.find(sc, ctx);
			dto.setCreatedBy(ctx.getCreatedBy());
			dto.setModifiedBy(ctx.getModifiedBy());
			dto.setGroupId(userDTO.getGroupId());
			dto.setGroupIdString(userDTO.getGroupIdString());
			BuyerBiddingDTO buyerBiddingDTO = new BuyerBiddingDTO();
			if (list != null && list.size() > 0) {
				buyerBiddingDTO = (BuyerBiddingDTO) list.get(0);
			}
			String array[] = buyerBiddingDTO.getAllSellerId().split(",");

			for (int i = 0; i < array.length; i++) {
				String string = array[i];
				CompanyDTO cdto = (CompanyDTO) companyServiceI.findByPK(i, ctx);
			}
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