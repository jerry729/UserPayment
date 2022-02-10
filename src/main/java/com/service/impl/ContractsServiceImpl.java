package com.service.impl;

import com.dao.ContractsMapper;
import com.entity.Contracts;
import com.service.ContractsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ContractsServiceImpl implements ContractsService {
	@Resource
    private ContractsMapper contractsdao;

	@Override
	public int add(Contracts po) {
		return contractsdao.insertSelective(po);
	}
	@Override
	public int update(Contracts po) {
		return contractsdao.updateByPrimaryKeySelective(po);
	}
	@Override
	public int delete(int id) {
		return contractsdao.deleteByPrimaryKey(id);
	}
	@Override
	public List<Contracts> getAll(Map<String, Object> map) {
		return contractsdao.getAll(map);
	}
	@Override
	public Contracts checkName(Map<String, Object> account) {
		return contractsdao.checkName(account);
	}
	@Override
	public List<Contracts> getByPage(Map<String, Object> map) {
		return contractsdao.getByPage(map);
	}
	@Override
	public int getCount(Map<String, Object> po) {
		return contractsdao.getCount(po);
	}
	@Override
	public Contracts getById(int id) {
		return contractsdao.selectByPrimaryKey(id);
	}

}
