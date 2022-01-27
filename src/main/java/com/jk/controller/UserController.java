package com.jk.controller;

import com.jk.entity.User;
import com.jk.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@RestController
@ConfigurationProperties(prefix = "person")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    private IUserService userService;
    private Calendar calendar;


    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }


    @Value("#{${huangfu}}") // maps注入 #{${属性名}}
    private Map<String, String> huangfu;

    private String name;
    private String sex;
    private long age;


    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(long age) {
        this.age = age;
    }

    @RequestMapping("/user")
    public int InsertUser() {
        User user = new User(0, "张三202", 55);
        int res = userService.insertUser(user);
        log.info("user：===>{}", res);
        return res;
    }

    @RequestMapping("/all")
    public List<User> queryAllUser() {
        List<User> res = null;
        try {
            res = new ArrayList<User>();
            res.addAll(userService.queryAllUser());
            int firstDayOfWeek = calendar.getFirstDayOfWeek();
            System.out.println("firstDayOfWeek = " + firstDayOfWeek);
            System.out.println("huangfu = " + huangfu);
            System.out.println("name = " + name);
            System.out.println("age = " + age);
            System.out.println("sex = " + sex);
            return res;

        } catch (Exception e) {
            e.printStackTrace();
            return res;
        }

    }

    @RequestMapping("/del")
    public int deleteUserById(int id) {
        System.out.println("--------" + id);

        int res = userService.deleteUserById(id);
        // 快捷键 res.sout -->  enter
        System.out.println(res);
        // 快捷键 res.soutv -->  enter
        System.out.println("res = " + res);
        return res;
    }

    @RequestMapping("/forEach")
    public int forEachInsert() {
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 12; i++) {
            users.add(new User(0, "张三" + i, 19));
        }
        System.out.println(users);
        int res = userService.forEachInsert(users);
        return res;
    }

    @RequestMapping("/update")
    public int updateNameById() {
        int res = userService.updateNameById("皇甫", 30L);
        return res;
    }


    @RequestMapping("/like")
    public List<User> queryLike(HttpServletRequest req, HttpServletResponse res) {
        List<User> list = userService.queryLike("皇");
        System.out.println("list = " + list);
        return list;
    }
}
