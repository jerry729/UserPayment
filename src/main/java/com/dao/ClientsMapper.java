package com.dao;

import com.entity.Clients;

import java.util.List;
import java.util.Map;

public interface ClientsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Clients clients);

    int insertSelective(Clients clients);

    Clients selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Clients clients);

    int updateByPrimaryKeyWithBLOBs(Clients clients);

    int updateByPrimaryKey(Clients clients);

    public Clients checkName(Map<String, Object> uname);
  
    //  查询所有信息
    public List<Clients> getAll(Map<String, Object> map);
    //  获取条数
    public int getCount(Map<String, Object> po);
    //  分页
    public List<Clients> getByPage(Map<String, Object> map);
}