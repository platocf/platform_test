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
	//���ݲ�������ȡ����ֵ
	private Object getValueFromParam(String param)
	{
		return ServletActionContext.getRequest().getParameter(param);
	}
	/***
	 * �޲���
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
	 * �������:user_name_
	 * �����û����������ȡģ����Ϣ
	 */
	public void getModelPageByName()
	{
		Map<String,List> map=new HashMap<String,List>(); 
		String getUsername = getValueFromParam("user_name_")==null?"":getValueFromParam("user_name_").toString();
		if(getUsername.equals(""))
		{
			this.sendAjaxResponse("user_name_��������!");
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
	 * �û���¼��һ��:�����û����������ж��û��Ƿ��¼�ɹ�
	 */
	public void getUserInfo()
	{
		String getUsername = getValueFromParam("user_name_")==null?"":getValueFromParam("user_name_").toString();
		String getUserpassword = getValueFromParam("user_password_")==null?"":getValueFromParam("user_password_").toString();
		if(getUsername.equals(""))
		{
			this.sendAjaxResponse("user_name_��user_password_��������!");
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
			this.sendAjaxResponse("��ȡ����ʧ��!");
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
		//����ȡ����getUsername����DES���ܲ�����
		if(getUsername.equals(""))
			this.sendAjaxResponse("��ȡ����ʧ��!");
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
	 * ͼƬ����ʽ���
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
            response.getOutputStream().flush();//���������������ͼƬ����������ʾ 
            u=null; 
            in.close();
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
	}
	
}
