package com.service.impl;

import com.dao.RecordMapper;
import com.entity.Record;
import com.service.RecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class RecordServiceImpl implements RecordService {
	@Resource
    private RecordMapper recorddao;

	@Override
	public int add(Record po) {
		return recorddao.insertSelective(po);
	}
	@Override
	public int update(Record po) {
		return recorddao.updateByPrimaryKeySelective(po);
	}
	@Override
	public int delete(int id) {
		return recorddao.deleteByPrimaryKey(id);
	}
	@Override
	public List<Record> getAll(Map<String, Object> map) {
		return recorddao.getAll(map);
	}
	@Override
	public Record checkName(Map<String, Object> account) {
		return recorddao.checkName(account);
	}
	@Override
	public List<Record> getByPage(Map<String, Object> map) {
		return recorddao.getByPage(map);
	}
	@Override
	public int getCount(Map<String, Object> po) {
		return recorddao.getCount(po);
	}
	@Override
	public Record getById(int id) {
		return recorddao.selectByPrimaryKey(id);
	}

}
