package com.service.impl;

import com.dao.BillsMapper;
import com.entity.Bills;
import com.service.BillsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BillsServiceImpl implements BillsService {
	@Resource
    private BillsMapper billsdao;

	@Override
	public int add(Bills po) {
		return billsdao.insertSelective(po);
	}
	@Override
	public int update(Bills po) {
		return billsdao.updateByPrimaryKeySelective(po);
	}
	@Override
	public int delete(int id) {
		return billsdao.deleteByPrimaryKey(id);
	}
	@Override
	public List<Bills> getAll(Map<String, Object> map) {
		return billsdao.getAll(map);
	}
	@Override
	public Bills checkName(Map<String, Object> account) {
		return billsdao.checkName(account);
	}
	@Override
	public List<Bills> getByPage(Map<String, Object> map) {
		return billsdao.getByPage(map);
	}
	@Override
	public int getCount(Map<String, Object> po) {
		return billsdao.getCount(po);
	}
	@Override
	public Bills getById(int id) {
		return billsdao.selectByPrimaryKey(id);
	}

}
