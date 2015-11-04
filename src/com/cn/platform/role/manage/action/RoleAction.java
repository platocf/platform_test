package com.cn.platform.role.manage.action;

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.cn.platform.common.base.DESUtils;
import com.cn.platform.common.base.MD5;
import com.cn.platform.common.base.baseAction;
import com.cn.platform.common.model.user;
import com.cn.platform.role.manage.service.IroleService;

public class RoleAction extends baseAction {
	IroleService roleservice;

	public IroleService getRoleservice() {
		return roleservice;
	}
	public void setRoleservice(IroleService roleservice) {
		this.roleservice = roleservice;
	}
	//根据参数名获取参数值
	private Object getValueFromParam(String param)
	{
		return ServletActionContext.getRequest().getParameter(param);
	}
	/***
	 * 无参数
	 */
	public void getallname()
	{
		try {
			String test ="[{ 'firstName':{ 'firstName': 'Elliotte', 'lastName':'Harold', 'email': 'cccc' }, 'lastName':'McLaughlin', 'email': 'aaaa' },{ 'firstName': 'Jason', 'lastName':'Hunter', 'email': 'bbbb'}]";
			JSONArray jo = JSONArray.fromObject(test);
			//this.sendAjaxResponse(roleservice.getallrole());
			this.sendAjaxResponse(jo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/***
	 * 所需参数:user_name_
	 * 根据用户名和密码获取模块信息
	 */
	public void getModelPageByName()
	{
		Map<String,List> map=new HashMap<String,List>(); 
		String getUsername = getValueFromParam("user_name_")==null?"":getValueFromParam("user_name_").toString();
		if(getUsername.equals(""))
		{
			this.sendAjaxResponse("user_name_参数错误!");
			return;
		}
		try {
			map.put("allmodepage", roleservice.getModelPageByName(getUsername));
			this.sendAjaxResponse(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/***
	 * 用户登录第一步:根据用户名和密码判断用户是否登录成功
	 */
	public void getUserInfo()
	{
		String getUsername = getValueFromParam("user_name_")==null?"":getValueFromParam("user_name_").toString();
		String getUserpassword = getValueFromParam("user_password_")==null?"":getValueFromParam("user_password_").toString();
		if(getUsername.equals(""))
		{
			this.sendAjaxResponse("user_name_和user_password_参数错误!");
			return;
		}
		try {
			user userinfo = roleservice.getUserInfo(getUsername);
			userinfo.setU_GetPassword(MD5.Md5(getUserpassword, 0));
			this.sendAjaxResponse(userinfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getusernamefromcookie()
	{
		
		String getUsername = getValueFromParam("user_name_")==null?"":getValueFromParam("user_name_").toString();
		Map<String,String> map=new HashMap<String,String>();
		if(getUsername.equals(""))
			this.sendAjaxResponse("获取数据失败!");
		else
		{
			try {
				map.put("getusernamefromcookie", DESUtils.decryptENOrC(getUsername));
				this.sendAjaxResponse(map);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		
	}
	public void setusercookie()
	{
		Map<String,String> map=new HashMap<String,String>();
		String getUsername = getValueFromParam("user_name_")==null?"":getValueFromParam("user_name_").toString();
		//将获取到的getUsername进行DES加密并返回
		if(getUsername.equals(""))
			this.sendAjaxResponse("获取数据失败!");
		else
		{
			try {
				//DESUtils.encryptENOrC(getUsername);
				map.put("setusercookie", DESUtils.encryptENOrC(getUsername));
				this.sendAjaxResponse(map);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void getBlockData()
	{
		List _blockdata = roleservice.getBlockData();
		try {
			this.sendAjaxResponse(_blockdata);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/***
	 * 图片流形式输出
	 */
	public void imageFlow()
	{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.reset(); 
        response.setContentType("image/*"); 
        try {
            URL u = new URL("http://183.60.192.207/000/16/256x256/12703_4666.jpg"); 
            String _file = u.getFile(); 
            InputStream in = u.openStream(); 
            byte[] bytearray = new byte[1024]; 
            int len=0;
            while((len=in.read(bytearray))!=-1){
                response.getOutputStream().write(bytearray);
            }
            response.getOutputStream().flush();//必须清除流，否则图片不能正常显示 
            u=null; 
            in.close();
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
	}
	
}
