package com.dao;

import com.entity.Contracts;

import java.util.List;
import java.util.Map;

public interface ContractsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Contracts contracts);

    int insertSelective(Contracts contracts);

    Contracts selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Contracts contracts);

    int updateByPrimaryKeyWithBLOBs(Contracts contracts);

    int updateByPrimaryKey(Contracts contracts);

    public Contracts checkName(Map<String, Object> uname);
  
    //  查询所有信息
    public List<Contracts> getAll(Map<String, Object> map);
    //  获取条数
    public int getCount(Map<String, Object> po);
    //  分页
    public List<Contracts> getByPage(Map<String, Object> map);
}