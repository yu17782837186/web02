package cn.com.service;

import cn.com.pojo.User;

public interface LoginService {
    User checkLoginService(String uname, String pwd);
}
