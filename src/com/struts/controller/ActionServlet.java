package com.struts.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 中央Servlet
 */
@WebServlet("/ActionServlet")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取url的操作内容
		String tmpPath = request.getRequestURI();
		String path = tmpPath.substring(tmpPath.lastIndexOf("/") + 1, tmpPath.lastIndexOf("."));
		System.out.println("post path: " + path);

		// 读取配置文件
		Properties props = new Properties();
		props.load(new FileInputStream(this.getServletContext().getRealPath(".") + "/WEB-INF/struts.properties"));
		// 获取url操作内容对应的操作类
		String value = (String) props.get(path);

		// 通过反射机制，获取具体类，执行操作
		Action action;
		try {
			action = (Action) Class.forName(value).newInstance();
			action.excute(request, response);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
