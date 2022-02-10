package com.dao;

import com.entity.SalesPerson;

import java.util.List;
import java.util.Map;

public interface SalesPersonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SalesPerson salesPerson);

    int insertSelective(SalesPerson salesPerson);

    SalesPerson selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SalesPerson salesPerson);

    int updateByPrimaryKeyWithBLOBs(SalesPerson salesPerson);

    int updateByPrimaryKey(SalesPerson salesPerson);

    public SalesPerson checkName(Map<String, Object> uname);
  
    //  查询所有信息
    public List<SalesPerson> getAll(Map<String, Object> map);
    //  获取条数
    public int getCount(Map<String, Object> po);
    //  分页
    public List<SalesPerson> getByPage(Map<String, Object> map);
}