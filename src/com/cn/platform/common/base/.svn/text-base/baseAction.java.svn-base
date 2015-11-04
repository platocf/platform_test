package com.cn.platform.common.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionSupport;

public abstract class baseAction extends ActionSupport {

	/**
	 * 
	 */
	// private static final long serialVersionUID = -3597711513305341295L;
	private static final long serialVersionUID = 1L;
	private String isAjax = null;

	/* session对象中userid的键值 */
	/**
	 * 获得当前用户
	 * */
	/*
	 * protected User getUser() { return RequestInfoUtil.getUser(); }
	 */

	/**
	 * 国际化一个字符串数组 依赖于getText(String key)方法
	 * 
	 * @param messages
	 *            需要国际化的数组
	 * @return
	 */
	protected String[] getText(String messages[]) {
		String[] newMessage = new String[messages.length];
		for (int i = 0; i < messages.length; i++) {
			newMessage[i] = this.getText(messages[i]);
		}
		return newMessage;
	}

	/**
	 * 国际化一个数组 依赖于getText(String key)方法
	 * 
	 * @param messages
	 * @return
	 */
	protected List getText(List messages) {
		List newMessage = new ArrayList();
		Iterator it = messages.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			if (obj instanceof String && obj != null)
				newMessage.add(getText(obj.toString()));
			else
				newMessage.add(obj);
		}
		return newMessage;
	}

	/**
	 * 国际化一个Map 依赖于getText(String key)方法
	 * 
	 * @param messages
	 * @return
	 */
	protected Map getText(Map messages) {
		Iterator it = messages.keySet().iterator();
		while (it.hasNext()) {
			Object key = it.next();
			Object value = messages.get(key);
			if (value instanceof String && value != null)
				messages.put(key, getText(value.toString()));
		}
		return messages;
	}

	/**
	 * 返回Ajax请求字符串，具体业务的Action应该使用Ajax组件解析这个字符串，获得具体数据对象。
	 */
	protected String readAjaxRequest() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return request.getRequestURI();
	}

	/**
	 * 返回Ajax响应字符串，将处理结果返回
	 */
	protected void sendAjaxResponse(String response) {
		HttpServletResponse res = ServletActionContext.getResponse();
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/json");
		try {
			res.getWriter().print(response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 返回Ajax响应字符串，将处理结果返回
	 */
	protected void sendAjaxResponse(Object response) throws Exception {
		HttpServletResponse res = ServletActionContext.getResponse();
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/json");
		res.getWriter().print(jsonStringBuilder.getAjaxString(response));
	}

	/**
	 * 返回Ajax响应字符串，将处理结果返回
	 * 
	 * @param response
	 *            查询数据
	 * @throws Exception
	 *             异常信息
	 */
	protected void sendAjaxResponse(List response) throws Exception {
		JSONArray array = JSONArray.fromObject(response);
		HttpServletResponse res = ServletActionContext.getResponse();
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/json");
		res.getWriter().print(array.toString());
	}

	public String getIsAjax() {
		return isAjax;
	}

	public void setIsAjax(String isAjax) {
		this.isAjax = isAjax;
	}
}
