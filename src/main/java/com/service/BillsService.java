package com.service;

import com.entity.Bills;

import java.util.List;
import java.util.Map;


public interface BillsService {

//  添加账单表
  public int add(Bills po);
//  获取单个账单表信息
  public Bills getById(int id);
//  修改账单表
  public int update(Bills po);
//  删除账单表
  public int delete(int id);
//  查询账单表
  public List<Bills> getAll(Map<String, Object> map);
//  验证账单表名称
  public Bills checkName(Map<String, Object> account);
//  分页显示
  public List<Bills> getByPage(Map<String, Object> map);
//  获取信息的条数
  public int getCount(Map<String, Object> po);

}