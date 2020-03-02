package com.woniu.team2project.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginHandlerInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object user = request.getSession().getAttribute("USER_IN_SESSION");
//		if(user==null) {
//			request.setAttribute("msg", "请先登录");
//					//会去static下找静态页面  但是MyWebMvcConfig里面配置了映射 就回去templates下找login页面
//			request.getRequestDispatcher("/login").forward(request, response);
//			return false;
//		}
		return true;
	}

}
