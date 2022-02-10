package com.service;

import com.entity.Message;

import java.util.List;
import java.util.Map;


public interface MessageService {

//  添加预警
  public int add(Message po);
//  获取单个预警信息
  public Message getById(int id);
//  修改预警
  public int update(Message po);
//  删除预警
  public int delete(int id);
//  查询预警
  public List<Message> getAll(Map<String, Object> map);
//  验证预警名称
  public Message checkName(Map<String, Object> account);
//  分页显示
  public List<Message> getByPage(Map<String, Object> map);
//  获取信息的条数
  public int getCount(Map<String, Object> po);

}