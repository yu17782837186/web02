package cn.com.ning;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应编码格式
            response.setContentType("text/html;charset=utf-8");
        //获取请求信息
        //处理请求
        //响应处理结果
            //获取request作用域数据
            String str = (String)request.getAttribute("str") == null ? "":(String)request.getAttribute("str");
            System.out.println(str);
            response.getWriter().write("<html>");
            response.getWriter().write("<head>");
            response.getWriter().write("</head>");
            response.getWriter().write("<body>");
            response.getWriter().write("<font color='red' size='20px'>"+str+"</font>");
            response.getWriter().write("<form action='login' method='get'>");
            response.getWriter().write("用户名：<input type='text' name='uname' value=''/><br/>");
            response.getWriter().write("密码：<input type='password' name='pwd' value=''/><br/>");
            response.getWriter().write("<input type='submit' value='登录'/><br/>");
            response.getWriter().write("</form>");
            response.getWriter().write("</body>");
            response.getWriter().write("</html>");
    }
}
