package com.service;

import com.entity.SalesPerson;

import java.util.List;
import java.util.Map;


public interface SalesPersonService {

//  添加业务员表
  public int add(SalesPerson po);
//  获取单个业务员表信息
  public SalesPerson getById(int id);
//  修改业务员表
  public int update(SalesPerson po);
//  删除业务员表
  public int delete(int id);
//  查询业务员表
  public List<SalesPerson> getAll(Map<String, Object> map);
//  验证业务员表名称
  public SalesPerson checkName(Map<String, Object> account);
//  分页显示
  public List<SalesPerson> getByPage(Map<String, Object> map);
//  获取信息的条数
  public int getCount(Map<String, Object> po);

}