package web;

import pojo.Page;
import pojo.Worker;
import service.WorkerService;
import service.impl.WorkerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class WorkerServlet extends BaseServlet {
    private WorkerService workerService=new WorkerServiceImpl();


    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("workerName");
        String phoneNumber = req.getParameter("phoneNumber");
        workerService.add(new Worker(null,name,phoneNumber));
        //重定向(防止表单反复提交
        resp.sendRedirect(req.getContextPath()+"/workerServlet?action=page&pageNo=1&pageSize=5");
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        workerService.deleteById(id);
        //重定向(防止表单反复提交
        resp.sendRedirect(req.getContextPath()+"/workerServlet?action=page&pageNo=1&pageSize=5");
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("workerName");
        String phoneNumber = req.getParameter("phoneNumber");
        workerService.Update(new Worker(id,name,phoneNumber));
        //重定向(防止表单反复提交
        resp.sendRedirect(req.getContextPath()+"/workerServlet?action=page&pageNo=1&pageSize=5");
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.通过WorkerService查询全部工人
        List<Worker> workerList = workerService.queryAll();
        //2.把数据全部保存到request域中
        req.setAttribute("workers",workerList);
        //3.把请求转发到/manager/Worker_manager.html页面
        req.getRequestDispatcher("/Managers/Worker_manager.jsp").forward(req,resp);
    }
    protected void getWorker(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        //通过id查询worker的信息
        Worker worker = workerService.queryById(id);
        //2.把数据全部保存到request域中
        req.setAttribute("worker",worker);
        //3.把请求转发到/Managers/editWorker.jsp页面
        req.getRequestDispatcher("/Managers/editWorker.jsp").forward(req,resp);
    }

    /**
     * 处理分页的功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数pageNo和pageSize
        Integer pageNo= Integer.valueOf(req.getParameter("pageNo"));
        Integer pageSize= Integer.valueOf(req.getParameter("pageSize"));
        //2.调用workerService.page(pageNo,pageSize)
        Page<Worker> page=workerService.page(pageNo,pageSize);
        //3.保存Page对象到Request域中
        req.setAttribute("page",page);
        //4.请求转发到Worker_manager.jsp
        req.getRequestDispatcher("/Managers/Worker_manager.jsp").forward(req,resp);
    }
}
