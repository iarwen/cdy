package com.cdy.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.Assert;

import com.alibaba.fastjson.JSONObject;
import com.cdy.cons.CommonConstant;
import com.cdy.domain.UserEntity;

public class BaseController {
	protected static final String MSG_KEY = "msg";
	protected static final String STATUS_CODE_KEY = "statusCode";

	/**
	 * 获取保存在Session中的用户对象
	 * 
	 * @param request
	 * @return
	 */
	protected UserEntity getSessionUser(HttpServletRequest request) {
		return (UserEntity) request.getSession().getAttribute(
				CommonConstant.USER_ENTITY);
	}

	/**
	 * 将json对象写回到响应流中
	 * 
	 * @param json
	 * @return
	 */
	protected void writeJson(HttpServletResponse response, JSONObject json)
			throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(json.toString());
		out.flush();
		out.close();
	}

	/**
	 * 将json对象写回到响应流中
	 * 
	 * @param json
	 * @return
	 */
	protected void ajaxDoneSuccess(HttpServletResponse response, String msg)
			throws IOException {
		writeBackAjax(response, "2000", msg);
	}

	protected void ajaxDoneError(HttpServletResponse response, String msg)
			throws IOException {
		writeBackAjax(response, "5000", msg);
	}

	private void writeBackAjax(HttpServletResponse response, String code,
			String msg) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();
		json.put(STATUS_CODE_KEY, code);
		json.put(MSG_KEY, msg);
		out.println(json.toString());
		out.flush();
		out.close();
	}

	/**
	 * 保存用户对象到Session中
	 * 
	 * @param request
	 * @param user
	 */
	protected void setSessionUser(HttpServletRequest request, UserEntity user) {
		request.getSession().setAttribute(CommonConstant.USER_ENTITY, user);
	}

	/**
	 * 获取基于应用程序的url绝对路径
	 * 
	 * @param request
	 * @param url
	 *            以"/"打头的URL地址
	 * @return 基于应用程序的url绝对路径
	 */
	public final String getAppbaseUrl(HttpServletRequest request, String url) {
		Assert.hasLength(url, "url不能为空");
		Assert.isTrue(url.startsWith("/"), "URL必须以/开头");
		return request.getContextPath() + url;
	}

}
