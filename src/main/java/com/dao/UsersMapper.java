package com.dao;

import com.entity.Users;

import java.util.List;
import java.util.Map;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKeyWithBLOBs(Users record);

    int updateByPrimaryKey(Users record);

    public Users checkUname(Map<String, Object> uname);
    //  验证后台登录
    public Users adminLogin(Map<String, Object> po);
    //  查询所有信息
    public List<Users> getAll(Map<String, Object> map);
    //  获取条数
    public int getCount(Map<String, Object> po);
    //  分页
    public List<Users> getByPage(Map<String, Object> map);
}