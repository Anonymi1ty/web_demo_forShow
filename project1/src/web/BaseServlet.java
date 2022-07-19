package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置服务器的字符集
        req.setCharacterEncoding("UTF-8");
        //获取表的action参数
        String action=req.getParameter("action");
        /**
         * 1.获取表的action参数
         * 2.升级后用反射获取对应的
         */

//        if (action.equals("login")){
//            login(req,resp);
//        }//巧妙的用到了action名称和函数名称相同，使用反射化简判断

        //通过表单中的action调用同名称的业务函数
        try {
            Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);//第一个为method名称，后面两个为传入的参数
            //调用反射方法
            method.invoke(this,req,resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
