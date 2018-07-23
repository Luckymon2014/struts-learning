package com.struts.service;

import com.struts.entity.User;

public class UserService {
	
	public boolean isValid(User user) {
		
		if (user.getUserName().equals("shanxiao")
				&& user.getPassword().equals("1234"))
			return true;
		
		return false;
	}

}
