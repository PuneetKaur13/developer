package com.ncs.services;

import com.ncs.dto.UserDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.exception.ForgetPassWordException;
import com.nenosystems.common.exception.UnauthorizedAccessException;
import com.nenosystems.common.exception.UserNotFoundException;
import com.nenosystems.common.services.BaseServiceI;

public interface UsersServiceI extends BaseServiceI {
	/**
	 * Authenticate a User
	 * 
	 * @param userDto
	 * @param userContext
	 * @return
	 * @throws com.nenosystems.common.exception.UserNotFoundException
	 * @throws UnauthorizedAccessException
	 */
	public UserDTO authenticate(UserDTO userDto, UserContext userContext)
			throws com.nenosystems.common.exception.UserNotFoundException, UnauthorizedAccessException;

	public UserDTO authenticateGoogle(String name,String email, UserContext userContext)
			throws com.nenosystems.common.exception.UserNotFoundException, UnauthorizedAccessException;

	public UserDTO forgetPassword(UserDTO userDto)
			throws UserNotFoundException, UnauthorizedAccessException, ForgetPassWordException;

	public long addAndSendActiveMail(BaseDTO dto, UserContext userContext, String url) throws Exception;

	public void update(BaseDTO dto, UserContext userContext, Boolean flag) throws Exception;

	public String registerUserWithOTP(BaseDTO dto, UserContext userContext) throws Exception;

	public void resendOTP(BaseDTO dto, UserContext userContext) throws Exception;
	
	public void  findbyStringSqlUpdate(String sql,UserContext userContext);

}
