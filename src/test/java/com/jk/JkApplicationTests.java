package com.jk;

import com.jk.dao.UserDao;
import com.jk.entity.User;
import com.jk.service.impl.UserService;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.List;

class JkApplicationTests extends BaseTest{

  @Resource
  private UserDao userDao;

  @Resource
  private UserService userService;

  @Test
  public void queryLike() {
    List<User> list = userDao.queryLike("皇");
    System.out.println("list = " + list);

  }

//  @Test
//  public void queryAll(){
//    List<User> users = userDao.queryAllUser();
//    System.out.println("users = " + users);
//  }

  @Test
  public void queryAll(){
    List<User> users = userService.queryAllUser();
    System.out.println("users = " + users);
  }
}
