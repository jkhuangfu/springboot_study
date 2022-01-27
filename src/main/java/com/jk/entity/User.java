package com.jk.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Bean;

public class User {
  // @JsonIgnore注解使用表示返回前端时 过滤此字段
  @JsonIgnore private int id;
  private String userName;
  private int userAge;

  public User() {}

  public User(int id, String userName, int userAge) {
    this.userName = userName;
    this.userAge = userAge;
  }

  @Override
  public String toString() {
    return "User{" + "id=" + id + ", userName='" + userName + '\'' + ", userAge=" + userAge + '}';
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public int getUserAge() {
    return userAge;
  }

  public void setUserAge(int userAge) {
    this.userAge = userAge;
  }
}
