package com.service;

import com.entity.Clients;

import java.util.List;
import java.util.Map;


public interface ClientsService {

//  添加客户表
  public int add(Clients po);
//  获取单个客户表信息
  public Clients getById(int id);
//  修改客户表
  public int update(Clients po);
//  删除客户表
  public int delete(int id);
//  查询客户表
  public List<Clients> getAll(Map<String, Object> map);
//  验证客户表名称
  public Clients checkName(Map<String, Object> account);
//  分页显示
  public List<Clients> getByPage(Map<String, Object> map);
//  获取信息的条数
  public int getCount(Map<String, Object> po);

}