package com.service.impl;

import com.dao.CommodityMapper;
import com.entity.Commodity;
import com.service.CommodityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class CommodityServiceImpl implements CommodityService {
	@Resource
    private CommodityMapper commoditydao;

	@Override
	public int add(Commodity po) {
		return commoditydao.insertSelective(po);
	}
	@Override
	public int update(Commodity po) {
		return commoditydao.updateByPrimaryKeySelective(po);
	}
	@Override
	public int delete(int id) {
		return commoditydao.deleteByPrimaryKey(id);
	}
	@Override
	public List<Commodity> getAll(Map<String, Object> map) {
		return commoditydao.getAll(map);
	}
	@Override
	public Commodity checkName(Map<String, Object> account) {
		return commoditydao.checkName(account);
	}
	@Override
	public List<Commodity> getByPage(Map<String, Object> map) {
		return commoditydao.getByPage(map);
	}
	@Override
	public int getCount(Map<String, Object> po) {
		return commoditydao.getCount(po);
	}
	@Override
	public Commodity getById(int id) {
		return commoditydao.selectByPrimaryKey(id);
	}

}
