package com.jk.dao;

import com.jk.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
  int InsertUser(User user);

  List<User> queryAllUser();

  int DeleteUserById(int id);

  int forEachInsert(List<User> list);

  long updateUserById(@Param("username") String name, @Param("id") long id);

  List<User> queryLike(@Param("value") String value);
}
