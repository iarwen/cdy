package com.cdy.interceptor;

import com.cdy.cons.CommonConstant;
import com.cdy.domain.User;
import com.cdy.exception.NotLoginException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainInterceptor extends WebContentInterceptor  {
	private String[] allowUrls={"/login","/logout"};
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) {
		String requestUrl=request.getRequestURI();
		User user=(User)request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
		if(user!=null)return true;
		
		for(String allowRrl : allowUrls){
			if(requestUrl.endsWith(allowRrl)){
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