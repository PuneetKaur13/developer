package com.ncs.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.dto.OrganizationDTO;
import com.ncs.form.OrganizationForm;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.dto.UserDTO;
import com.nenosystems.common.services.BaseServiceI;

@RestController
@RequestMapping(value = "rest/Organization")
public class OrganizationCtl extends BaseCtl<OrganizationForm> {
	 
	    private static Logger log = Logger.getLogger(OrganizationCtl.class);

		@Override
		@Autowired
		@Qualifier("organizationService")
		public void setService(BaseServiceI service) {
			 this.service = service;
			 
		}


}
