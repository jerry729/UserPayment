package com.service.impl;

import com.dao.UsersMapper;
import com.entity.Users;
import com.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UsersServiceImpl implements UsersService {
	@Resource
    private UsersMapper userdao;
	@Override
	public Users adminLogin(Map<String, Object> po) {
		return userdao.adminLogin(po);
	}
	@Override
	public int add(Users po) {
		return userdao.insertSelective(po);
	}
	@Override
	public int update(Users po) {
		return userdao.updateByPrimaryKeySelective(po);
	}
	@Override
	public int delete(int id) {
		return userdao.deleteByPrimaryKey(id);
	}
	@Override
	public List<Users> getAll(Map<String, Object> map) {
		return userdao.getAll(map);
	}
	@Override
	public Users checkUname(Map<String, Object> account) {
		return userdao.checkUname(account);
	}
	@Override
	public List<Users> getByPage(Map<String, Object> map) {
		return userdao.getByPage(map);
	}
	@Override
	public int getCount(Map<String, Object> po) {
		return userdao.getCount(po);
	}
	@Override
	public Users getById(int id) {
		return userdao.selectByPrimaryKey(id);
	}

}
