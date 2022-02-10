package com.dao;

import com.entity.Bills;

import java.util.List;
import java.util.Map;

public interface BillsMapper {
    int deleteByPrimaryKey(Integer billid);

    int insert(Bills record);

    int insertSelective(Bills record);

    Bills selectByPrimaryKey(Integer billid);

    int updateByPrimaryKeySelective(Bills record);

    int updateByPrimaryKey(Bills record);

    //  查询账单表
    public List<Bills> getAll(Map<String, Object> map);
    //  验证账单表名称
    public Bills checkName(Map<String, Object> account);
    //  分页显示
    public List<Bills> getByPage(Map<String, Object> map);
    //  获取信息的条数
    public int getCount(Map<String, Object> po);
}