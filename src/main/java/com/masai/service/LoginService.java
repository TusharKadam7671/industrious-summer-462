package com.masai.service;

import com.masai.dto.LoginDto;
import com.masai.exceptions.LoginException;

public interface LoginService {
	
	public String logIntoAccount(LoginDto dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;

}
