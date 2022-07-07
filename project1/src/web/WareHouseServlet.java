package web;


import pojo.WareHouse;
import pojo.Worker;
import service.WareHService;
import service.impl.WareHouseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class WareHouseServlet extends BaseServlet {
    private WareHService wareHService=new WareHouseServiceImpl();

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.通过WorkerService查询全部仓库信息
        List<WareHouse> wareHousesList = wareHService.queryAll();
        System.out.println(wareHousesList);

        //2.把数据全部保存到request域中
        req.setAttribute("workers",wareHousesList);
        //3.把请求转发到/Managers/showWareHouse.html页面
        req.getRequestDispatcher("/Managers/showWareHouse.html").forward(req,resp);
    }


    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer  goodNumber= Integer.valueOf(req.getParameter("goodNumber"));
        String goodType = req.getParameter("goodType");
        String goodPosition = req.getParameter("goodPosition");
        wareHService.add(new WareHouse(null,goodNumber,goodType,goodPosition));
        //重定向(防止表单反复提交
        resp.sendRedirect(req.getContextPath()+"/login/loginSuccess.html");
    }
}
