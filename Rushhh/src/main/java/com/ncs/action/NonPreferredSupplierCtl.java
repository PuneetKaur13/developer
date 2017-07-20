package com.ncs.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.form.NonPreferredSupplierForm;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.services.BaseServiceI;


@RestController
@RequestMapping(value = "rest/NonPrefferdSupplier")
public class NonPreferredSupplierCtl extends BaseCtl<NonPreferredSupplierForm> {
	 
	    private static Logger log = Logger.getLogger(NonPreferredSupplierCtl.class);

		@Override
		@Autowired
		@Qualifier("nonPreferredSupplierService")
		public void setService(BaseServiceI service) {
			 this.service = service;
			 
		}
}