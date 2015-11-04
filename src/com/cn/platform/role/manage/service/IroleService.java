package com.cn.platform.role.manage.service;

import java.util.List;

import com.cn.platform.common.model.user;

public interface IroleService {
	public List getallrole();
	public List getModelPageByName(String name);
	public user getUserInfo(String username);
	public List getBlockData();
}
