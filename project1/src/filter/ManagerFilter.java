package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ManagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //类型转换,为了使用session
        HttpServletRequest httpServletRequest= (HttpServletRequest) servletRequest;
        Object username = httpServletRequest.getSession().getAttribute("username");
        if (username==null)//如果没有登录，强制跳转回登录页面
            httpServletRequest.getRequestDispatcher("/login/index.html").forward(servletRequest,servletResponse);
        else //如果登录成功，放行
            filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
