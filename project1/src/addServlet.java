import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class addServlet extends HttpServlet {


    //Servlet自身自带的处理post请求的方法,get同理
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        post方式下设置编码，防止中文乱码
        req.setCharacterEncoding("UTF-8");

        //通过req.getParameter获取服务器发送过来的参数

        String username = req.getParameter("username");
        String psd = req.getParameter("psw");

        System.out.println(psd);
        System.out.println(username);
    }
}
