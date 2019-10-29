package cn.com.dao;

import cn.com.pojo.User;

public interface LoginDao {
    User checkLoginDao(String uname, String pwd);
}
