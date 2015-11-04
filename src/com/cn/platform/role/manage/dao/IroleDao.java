package com.cn.platform.role.manage.dao;

import java.util.List;

import com.cn.platform.common.model.blockdata;
import com.cn.platform.common.model.user;

public interface IroleDao {
	public List getRoleByList();
	public List getModelpageByuserName(String userName);
	public user getUserInfo(String U_LoginName);
	public List getBlockData();
}
