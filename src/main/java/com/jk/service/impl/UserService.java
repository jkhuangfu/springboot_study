package com.jk.service.impl;

import com.jk.dao.UserDao;
import com.jk.entity.User;
import com.jk.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional // 事务处理
public class UserService implements IUserService {
  private  UserDao userDao;

  @Autowired
  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }


  @Override
  public int insertUser(User userInfo) {
    return userDao.InsertUser(userInfo);
  }

  @Override
  public List<User> queryAllUser() {
    return userDao.queryAllUser();
  }

  @Override
  public List<User> queryLike(String value) {
    return userDao.queryLike(value);
  }

  @Override
  public int deleteUserById(int id) {
    return userDao.DeleteUserById(id);
  }

  @Override
  public int forEachInsert(List<User> list) {
    return userDao.forEachInsert(list);
  }

  @Override
  public int updateNameById(String name, long id) {
    return (int) userDao.updateUserById(name,id);
  }
}
