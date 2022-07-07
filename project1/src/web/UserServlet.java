package web;

import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends BaseServlet {
    private UserService userService=new UserServiceImpl();

    /**
     * 处理登录的功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //整合代码，将用户功能进行合并

        //1.获取请求参数
        String username = req.getParameter("logname");
        String password = req.getParameter("logpass");
//        System.out.println(username);
//        System.out.println(password);

        //2.调用UserService.login()登录
        User loginResult = userService.login(new User(null, username, password));
        //3.判断是否登录成功
        if (loginResult==null){
            //登录失败 跳回登录页面
            req.getRequestDispatcher("/login/index.html").forward(req,resp);
        }else {
            //登录成功
            req.getRequestDispatcher("/login/loginSuccess.html").forward(req,resp);
        }
    }

}
