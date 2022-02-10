package com.service.impl;

import com.dao.SalesPersonMapper;
import com.entity.SalesPerson;
import com.service.SalesPersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SalesPersonServiceImpl implements SalesPersonService {
	@Resource
    private SalesPersonMapper salesPersondao;

	@Override
	public int add(SalesPerson po) {
		return salesPersondao.insertSelective(po);
	}
	@Override
	public int update(SalesPerson po) {
		return salesPersondao.updateByPrimaryKeySelective(po);
	}
	@Override
	public int delete(int id) {
		return salesPersondao.deleteByPrimaryKey(id);
	}
	@Override
	public List<SalesPerson> getAll(Map<String, Object> map) {
		return salesPersondao.getAll(map);
	}
	@Override
	public SalesPerson checkName(Map<String, Object> account) {
		return salesPersondao.checkName(account);
	}
	@Override
	public List<SalesPerson> getByPage(Map<String, Object> map) {
		return salesPersondao.getByPage(map);
	}
	@Override
	public int getCount(Map<String, Object> po) {
		return salesPersondao.getCount(po);
	}
	@Override
	public SalesPerson getById(int id) {
		return salesPersondao.selectByPrimaryKey(id);
	}

}
