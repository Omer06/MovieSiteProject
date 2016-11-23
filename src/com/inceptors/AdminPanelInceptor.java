package com.inceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class AdminPanelInceptor extends HandlerInterceptorAdapter {
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		System.out.println("handle çalýþtý-------------------------------------------------------");
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			
			if(username.equals("admin") && password.equals("e050f626b6b5407da68be29e0d8965d9d8d5ec40eca3d3b802a9bf9853a2926bd819401e8884f26de050f626b6b5407da68be29e0d8965d9d8d5ec40eca3d3b802a9bf9853a2926bd819401e8884f26de050f626b6b5407da68be29e0d8965d9d8d5ec40eca3d3b802a9bf9853a2926bd819401e8884f26d")) {
				return true;
			}
		} catch (Exception e) { }
	    
		response.sendRedirect(request.getContextPath() + "/");
		
		return true;
	}

}
