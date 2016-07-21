package com.cdy.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cdy.cons.CommonConstant;
import com.cdy.domain.UserEntity;
import com.cdy.service.UserService;
import com.cdy.utils.CipherUtil;

@Controller
@RequestMapping("/")
public class SecurityController extends BaseController {
	/**
	 * 自动注入
	 */
	@Autowired
	private UserService userService;
	
    /**
     * 用户登陆
     * @param request
     * @param user
     * @return
     */
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,UserEntity user) {
		//刷新主页
		if(request.getSession().getAttribute(CommonConstant.USER_ENTITY)!=null){
			return new ModelAndView("main");
		}
		String verify = request.getParameter("verify");
		String toUrl="index.jsp";
		ModelAndView mav = new ModelAndView();
		if(verifyok(request,verify)){
			mav.addObject("errorMsg", "验证码不正确");
			mav.setViewName(toUrl);
			return mav;
		} 
		
		UserEntity dbUser=userService.getUserByUserName(user.getUserName());
		
		if (dbUser == null) {
			mav.addObject("errorMsg", "用户名不存在");
		} else if (!CipherUtil.validatePassword(dbUser.getPassword(), user.getPassword()) ) {
			mav.addObject("errorMsg", "密码不正确");
		} else if (dbUser.getLocked() == UserEntity.USER_LOCK) {
			mav.addObject("errorMsg", "用户已经被锁定，不能登录。");
		} else {
			toUrl="main";
			setSessionUser(request,dbUser);
		}
		mav.setViewName(toUrl);
		return mav;
	}
	private boolean verifyok(HttpServletRequest request,String code){
		if(null==code) return false;
		return request.getSession().getAttribute("cver_code").equals(code);
	}
	/**
	 * 登录注销
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute(CommonConstant.USER_ENTITY);
		return "forward:/index.jsp";
	}

}
