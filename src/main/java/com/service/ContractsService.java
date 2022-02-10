package com.service;

import com.entity.Contracts;

import java.util.List;
import java.util.Map;


public interface ContractsService {

//  添加合同表
  public int add(Contracts po);
//  获取单个合同表信息
  public Contracts getById(int id);
//  修改合同表
  public int update(Contracts po);
//  删除合同表
  public int delete(int id);
//  查询合同表
  public List<Contracts> getAll(Map<String, Object> map);
//  验证合同表名称
  public Contracts checkName(Map<String, Object> account);
//  分页显示
  public List<Contracts> getByPage(Map<String, Object> map);
//  获取信息的条数
  public int getCount(Map<String, Object> po);

}