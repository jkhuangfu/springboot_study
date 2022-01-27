package com.jk.service;

import com.jk.entity.User;

import java.util.List;

public interface IUserService {
  int insertUser(User user);

  List<User> queryAllUser();

  List<User> queryLike(String value);

  int deleteUserById(int id);

  int forEachInsert(List<User> list);

  int updateNameById(String name,long id);
}
