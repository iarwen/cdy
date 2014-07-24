package com.cdy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cdy.cons.CommonConstant;
import com.cdy.domain.User;
import com.cdy.exception.NotLoginException;

public class MainInterceptor implements HandlerInterceptor {
	private String[] allowUrls;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String requestUrl=request.getRequestURI();
		
		if(null!=allowUrls&&allowUrls.length>0){
			for(String allowRrl : allowUrls){
				if(requestUrl.contains(allowRrl)){
					return true;
				}
			}
		}
		User user=(User)request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
		if(user!=null){
			return true;
		}else{
			throw new NotLoginException("not login");
		}
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
