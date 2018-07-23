package com.struts.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductAction extends Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("product");
	}

}
