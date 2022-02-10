package com.dao;

import com.entity.Message;

import java.util.List;
import java.util.Map;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Message message);

    int insertSelective(Message message);

    Message selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Message message);

    int updateByPrimaryKeyWithBLOBs(Message message);

    int updateByPrimaryKey(Message message);

    public Message checkName(Map<String, Object> uname);
  
    //  查询所有信息
    public List<Message> getAll(Map<String, Object> map);
    //  获取条数
    public int getCount(Map<String, Object> po);
    //  分页
    public List<Message> getByPage(Map<String, Object> map);
}