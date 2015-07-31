package com.cdy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import com.cdy.cons.CommonConstant;
import com.cdy.domain.UserEntity;
import com.cdy.exception.NotLoginException;

public class MainInterceptor extends WebContentInterceptor  {
	private String[] allowUrls={"/login","/logout"};
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) {
		String requestUrl=request.getRequestURI();
		UserEntity user=(UserEntity)request.getSession().getAttribute(CommonConstant.USER_ENTITY);
		if(user!=null)return true;
		
		for(String allowRrl : allowUrls){
			if(requestUrl.equals(allowRrl)){
				return true;
			}
		}
		
		throw new NotLoginException("not login");
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

	public void setAllowUrls(String[] allowUrls) {
		this.allowUrls = allowUrls;
	}

}