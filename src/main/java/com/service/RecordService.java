package com.service;

import com.entity.Record;

import java.util.List;
import java.util.Map;


public interface RecordService {

//  添加回款记录表
  public int add(Record po);
//  获取单个回款记录表信息
  public Record getById(int id);
//  修改回款记录表
  public int update(Record po);
//  删除回款记录表
  public int delete(int id);
//  查询回款记录表
  public List<Record> getAll(Map<String, Object> map);
//  验证回款记录表名称
  public Record checkName(Map<String, Object> account);
//  分页显示
  public List<Record> getByPage(Map<String, Object> map);
//  获取信息的条数
  public int getCount(Map<String, Object> po);

}