package cn.com.dao.impl;

import cn.com.dao.LoginDao;
import cn.com.pojo.User;

import java.sql.*;

public class LoginDaoImp implements LoginDao {
    @Override
    public User checkLoginDao(String uname, String pwd) {
        //声明jdbc对象
        Connection coon = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //声明数据存储对象
        User user = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接对象
            coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/web","root","123456");
            //创建sql命令
            String sql = "select * from t_user where uname = ? and pwd = ?";
            //创建sql命令对象
            ps = coon.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1,uname);
            ps.setString(2,pwd);
            //执行
            rs = ps.executeQuery();
            //遍历执行结果
            while(rs.next()){
                user = new User();
                user.setUid(rs.getInt("uid"));
                user.setUname(rs.getString("uname"));
                user.setPwd(rs.getString("pwd"));
            }
            //关闭资源
            //返回
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (ps != null){
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (coon != null) {
                    coon.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}
