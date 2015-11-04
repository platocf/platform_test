package com.cn.platform.role.manage.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.cn.platform.common.model.Role;
import com.cn.platform.common.model.blockdata;
import com.cn.platform.common.model.modelpage;
import com.cn.platform.common.model.user;

public class roleDaoImpl extends SqlSessionDaoSupport implements IroleDao {

	@Override
	public List getRoleByList() {
		// TODO Auto-generated method stub
		List<Role> list = getSqlSession().selectList(
				"RoleMapper.getRoleByRName");
		return list;
	}
	public List getModelpageByuserName(String userName)
	{
		List<modelpage> list = getSqlSession().selectList("ModelPage.getModelpageByRName", userName);
		return list;
	}
	public user getUserInfo(String U_LoginName)
	{
		return (user) getSqlSession().selectOne("UserMapper.getUserByRName", U_LoginName);
	}
	public List getBlockData()
	{
		List<blockdata> list = getSqlSession().selectList("BlockDataMapper.getData");
		return list;
	}

}
