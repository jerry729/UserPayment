package com.service;

import com.entity.Commodity;

import java.util.List;
import java.util.Map;


public interface CommodityService {

//  添加货物表
  public int add(Commodity po);
//  获取单个货物表信息
  public Commodity getById(int id);
//  修改货物表
  public int update(Commodity po);
//  删除货物表
  public int delete(int id);
//  查询货物表
  public List<Commodity> getAll(Map<String, Object> map);
//  验证货物表名称
  public Commodity checkName(Map<String, Object> account);
//  分页显示
  public List<Commodity> getByPage(Map<String, Object> map);
//  获取信息的条数
  public int getCount(Map<String, Object> po);

}