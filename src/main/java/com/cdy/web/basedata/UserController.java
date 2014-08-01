
package com.cdy.web.basedata;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cdy.domain.User;
import com.cdy.exception.UserExistException;
import com.cdy.service.UserService;
import com.cdy.web.BaseController;

/**
 * 
 * <br>
 * <b>类描述:</b>
 * 
 * <pre>
 * 注册用户的Action
 * </pre>
 * 
 * @see
 * @since
 */
@Controller 
@RequestMapping("/user")
public class UserController extends BaseController {
	/**
	 * 自动注入
	 */
	@Autowired
	private UserService userService;
	/**
	 * 用户注册
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request,User user){
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:index");
		try {
			userService.register(user);
		} catch (UserExistException e) {
			view.setViewName("basedata/user/add");
			view.addObject("errorMsg", "用户名已经存在，请选择其它的名字。");
			e.printStackTrace();
		}
        catch (Exception e)
        {
            e.printStackTrace();
        }
		return view;
	}
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request,User user){
		ModelAndView view = new ModelAndView();
		List<User> userlist=null;
		if(StringUtils.isEmpty( user.getUserName())){
			userlist =	userService.getAllUsers();
		}
		else{
			userlist=userService.queryUserByUserName(user.getUserName());
		}
		view.setViewName("basedata/user/index");
		view.addObject("userlist", userlist);
		return view;
	}
	@RequestMapping("/gotoaddnew")
	public ModelAndView gotoaddnew(){
		ModelAndView view = new ModelAndView();
		view.setViewName("basedata/user/add");
		return view;
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.POST })
	@ResponseBody
	public void delete(HttpServletResponse res, @RequestParam(value = "uids[]") String[] uids) throws IOException{
		for(String id:uids){
			userService.remove(id);
		}
		ajaxDoneSuccess(res,"删除成功");
	}
	@RequestMapping(value = "/enable/{id}")
	public ModelAndView enable(@PathVariable("id") String id){
		try {
			userService.unlockUser(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/user/index");
		return view;
	}
	@RequestMapping(value = "/disable/{id}")
	public ModelAndView disable(@PathVariable("id") String id){
		try {
			userService.lockUser(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/user/index");
		return view;
	}
	
}
