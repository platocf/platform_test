package com.cn.platform.role.manage.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.cn.platform.common.model.user;
import com.cn.platform.role.manage.dao.IroleDao;

public class RoleServiceImpl implements IroleService {
	private IroleDao Roledao;
	public IroleDao getRoledao() {
		return Roledao;
	}
	public void setRoledao(IroleDao roledao) {
		Roledao = roledao;
	}
	@Override
	public List getallrole() {
		// TODO Auto-generated method stub
		return Roledao.getRoleByList();
	}
	public List getModelPageByName(String name)
	{
		return Roledao.getModelpageByuserName(name);
	}
	public user getUserInfo(String username)
	{
		user temp = Roledao.getUserInfo(username);
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date timetemp=temp.getU_BirthDay();
		System.out.println(f.format(timetemp));
		return Roledao.getUserInfo(username);
	}
	public List getBlockData()
	{
		return Roledao.getBlockData();
	}

}
