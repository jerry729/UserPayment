package com.service.impl;

import com.dao.ClientsMapper;
import com.entity.Clients;
import com.service.ClientsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ClientsServiceImpl implements ClientsService {
	@Resource
    private ClientsMapper clientsdao;

	@Override
	public int add(Clients po) {
		return clientsdao.insertSelective(po);
	}
	@Override
	public int update(Clients po) {
		return clientsdao.updateByPrimaryKeySelective(po);
	}
	@Override
	public int delete(int id) {
		return clientsdao.deleteByPrimaryKey(id);
	}
	@Override
	public List<Clients> getAll(Map<String, Object> map) {
		return clientsdao.getAll(map);
	}
	@Override
	public Clients checkName(Map<String, Object> account) {
		return clientsdao.checkName(account);
	}
	@Override
	public List<Clients> getByPage(Map<String, Object> map) {
		return clientsdao.getByPage(map);
	}
	@Override
	public int getCount(Map<String, Object> po) {
		return clientsdao.getCount(po);
	}
	@Override
	public Clients getById(int id) {
		return clientsdao.selectByPrimaryKey(id);
	}

}
