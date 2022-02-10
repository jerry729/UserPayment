package com.service.impl;

import com.dao.MessageMapper;
import com.entity.Message;
import com.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService {
	@Resource
    private MessageMapper messagedao;

	@Override
	public int add(Message po) {
		return messagedao.insertSelective(po);
	}
	@Override
	public int update(Message po) {
		return messagedao.updateByPrimaryKeySelective(po);
	}
	@Override
	public int delete(int id) {
		return messagedao.deleteByPrimaryKey(id);
	}
	@Override
	public List<Message> getAll(Map<String, Object> map) {
		return messagedao.getAll(map);
	}
	@Override
	public Message checkName(Map<String, Object> account) {
		return messagedao.checkName(account);
	}
	@Override
	public List<Message> getByPage(Map<String, Object> map) {
		return messagedao.getByPage(map);
	}
	@Override
	public int getCount(Map<String, Object> po) {
		return messagedao.getCount(po);
	}
	@Override
	public Message getById(int id) {
		return messagedao.selectByPrimaryKey(id);
	}

}
