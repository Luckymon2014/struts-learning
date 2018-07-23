package com.struts.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.struts.entity.User;
import com.struts.service.UserService;

public class LoginAction extends Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {

		User user = new User();
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));

		UserService userService = new UserService();
		boolean flag = userService.isValid(user);

		try {
			if (flag) {
				// 登录成功
				request.getRequestDispatcher("/success.jsp").forward(request, response);
			} else {
				// 登录失败
				request.getRequestDispatcher("/fail.jsp").forward(request, response);
			}
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
