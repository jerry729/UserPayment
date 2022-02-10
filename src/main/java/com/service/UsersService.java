package com.service;

import com.entity.Users;

import java.util.List;
import java.util.Map;


public interface UsersService {
//  验证后台登录
  public Users adminLogin(Map<String, Object> po);
//  添加用户
  public int add(Users po);
//  获取单个用户信息
  public Users getById(int id);
//  修改用户
  public int update(Users po);
//  删除用户
  public int delete(int id);
//  查询用户
  public List<Users> getAll(Map<String, Object> map);
//  验证用户名
  public Users checkUname(Map<String, Object> account);
//  分页显示
  public List<Users> getByPage(Map<String, Object> map);
//  获取信息的条数
  public int getCount(Map<String, Object> po);

}
