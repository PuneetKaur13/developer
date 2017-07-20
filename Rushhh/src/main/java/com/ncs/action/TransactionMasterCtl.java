package com.ncs.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.dto.AccountMasterDTO;
import com.ncs.dto.BuyerBiddingDTO;
import com.ncs.dto.BuyerQuotationDTO;
import com.ncs.dto.TransactionMasterDTO;
import com.ncs.form.BuyerBiddingForm;
import com.ncs.form.TransactionMasterForm;
import com.ncs.services.AccountMasterServiceI;
import com.ncs.services.CompanyServiceI;
import com.ncs.services.TransactionMasterServiceI;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.action.NcsResponseData;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.exception.DuplicateRecordException;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataValidator;

@RestController
@RequestMapping(value = "rest/TransactionMaster")
public class TransactionMasterCtl extends BaseCtl<TransactionMasterForm> {

	private static Logger log = Logger.getLogger(TransactionMasterCtl.class);

	@Override
	@Autowired
	@Qualifier("transactionMasterService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}

	@Autowired
	private AccountMasterServiceI accountMasterService;

	@Autowired
	private TransactionMasterServiceI transactionMasterService;

	@Autowired
	private CompanyServiceI companyService;

	@Override
	public HashMap<String, Object> preload() throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("companyList", companyService.find(ctx));
		return map;
	}


	public SearchCriteria getSearchCriteria(TransactionMasterForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(TransactionMasterDTO.class);
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());
		if (!DataValidator.isNull(form.getCompanyName())) {
			sc.setAttribute("companyName", form.getCompanyName());
		}
		return sc;
	}

/*	@RequestMapping(value = "/searchMain", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData search(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		return ncsResponseData;
	}*/

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public NcsResponseData submitAdd(@RequestBody TransactionMasterForm form, HttpSession session) {
		TransactionMasterDTO dto = (TransactionMasterDTO) form.makeDto();
		NcsResponseData ncsResponseData = new NcsResponseData();
		ctx = getUserContext(session);
		try {
			SearchCriteria sc = new SearchCriteria();
			sc.setDto(AccountMasterDTO.class);
			sc.setAttribute("=userId", dto.getUserId());
			List list = accountMasterService.find(sc, ctx);
			AccountMasterDTO accountMasterDTO = null;
			if (list.size() > 0) {
				accountMasterDTO = (AccountMasterDTO) list.get(0);
				double mainBalance = accountMasterDTO.getBalance();
				if (dto.getType().equals("Payment")) {
					accountMasterDTO.setBalance(mainBalance - dto.getAmount());
				} else {
					accountMasterDTO.setBalance(mainBalance + dto.getAmount());
				}
				accountMasterService.update(accountMasterDTO, ctx);
			} else {
				accountMasterDTO = new AccountMasterDTO();
				accountMasterDTO.setUserId(dto.getUserId());
				accountMasterDTO.setUserName(dto.getUserName());
				accountMasterDTO.setCompanyId(dto.getCompanyId());
				accountMasterDTO.setCompanyName(dto.getCompanyName());
				if (dto.getType().equals("Payment")) {
					accountMasterDTO.setBalance(-dto.getAmount());
				} else {
					accountMasterDTO.setBalance(dto.getAmount());
				}
				accountMasterDTO.setCreatedBy(ctx.getCreatedBy());
				accountMasterDTO.setModifiedBy(ctx.getModifiedBy());
				accountMasterDTO.setCreatedDate(new Timestamp(new Date().getTime()));
				accountMasterService.add(accountMasterDTO, ctx);
			}

			if (dto != null) {
				dto.setCreatedBy(ctx.getCreatedBy());
				dto.setModifiedBy(ctx.getModifiedBy());
				long pk = service.add(dto, ctx);
				form.setId(pk);
				ncsResponseData.setForm(form);
				ncsResponseData.setSuccess(true);
				ncsResponseData.setMessage("Record has been added successfully.");
			}
		} catch (DuplicateRecordException e) {
			ncsResponseData.setMessage("Record is already exist.");
		} catch (Exception e) {
			ncsResponseData.setMessage(e.getMessage());
		}
		return ncsResponseData;
	}

	@RequestMapping(value = "/searchByBox", method = { RequestMethod.GET,
			   RequestMethod.POST })
			 public NcsResponseData searchByBox(@RequestBody TransactionMasterForm form,
			   HttpSession session) throws Exception {
			  System.out.println("in controller");
			  NcsResponseData ncsResponseData = new NcsResponseData();
			  SearchCriteria sc = new SearchCriteria();
			  sc.setDto(TransactionMasterDTO.class);
			  if(!DataValidator.isNull(form.getCompanyName())){
			  sc.setAttribute("=companyName", form.getCompanyName());
			  }
			  List list = transactionMasterService.find(sc, ctx);
			  System.out.println("List"+list);
			  ncsResponseData.setForm(null);
			  ncsResponseData.setSuccess(true);
			  ncsResponseData.setList(list);
			  return ncsResponseData;
			 }
	


}