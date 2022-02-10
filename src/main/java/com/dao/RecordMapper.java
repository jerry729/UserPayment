package com.dao;

import com.entity.Record;

import java.util.List;
import java.util.Map;

public interface RecordMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Record record);

    int insertSelective(Record record);

    Record selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);

    //  查询回款记录表
    public List<Record> getAll(Map<String, Object> map);
    //  验证回款记录表名称
    public Record checkName(Map<String, Object> account);
    //  分页显示
    public List<Record> getByPage(Map<String, Object> map);
    //  获取信息的条数
    public int getCount(Map<String, Object> po);
}