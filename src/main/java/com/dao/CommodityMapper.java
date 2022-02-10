package com.dao;

import com.entity.Commodity;

import java.util.List;
import java.util.Map;

public interface CommodityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Commodity commodity);

    int insertSelective(Commodity commodity);

    Commodity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Commodity commodity);

    int updateByPrimaryKeyWithBLOBs(Commodity commodity);

    int updateByPrimaryKey(Commodity commodity);

    public Commodity checkName(Map<String, Object> uname);
  
    //  查询所有信息
    public List<Commodity> getAll(Map<String, Object> map);
    //  获取条数
    public int getCount(Map<String, Object> po);
    //  分页
    public List<Commodity> getByPage(Map<String, Object> map);
}