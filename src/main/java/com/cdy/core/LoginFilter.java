package com.cdy.core;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter
{
    private FilterConfig filterConfig;

    // Handle the passed-in FilterConfig
    public void init(FilterConfig filterConfig)
    {
        this.filterConfig = filterConfig;
    }

    // Process the request/response pair
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
    {
        try
        {
            String uri = ((HttpServletRequest) request).getRequestURI();
            if (this.checkValidata(uri.lastIndexOf(".do") == -1
                    && this.checkValidata(uri.lastIndexOf("Servlet") == -1 && this.checkValidata(uri.lastIndexOf(".jsp") == -1))))
            {
                filterChain.doFilter(request, response);
            }
            else if (this.checkValidata(uri.lastIndexOf("/servlet/imageServlet") != -1 || uri.lastIndexOf("commons/swfupload/upload.do") != -1
                    || (this.checkValidata(uri.lastIndexOf("userLogin.do") != -1) && this.checkValidata(!"".equals(request.getParameter("loginId"))))
                    || this.checkValidata(uri.lastIndexOf("login.jsp") != -1)))
            {
                filterChain.doFilter(request, response);
            }
            else
            {
                // 判断是否登陆系统
                if (((HttpServletRequest) request).getSession().getAttribute("userMap") == null)
                {
                    ((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/login.jsp");
                }
                else
                {
                    filterChain.doFilter(request, response);
                }
            }
        }
        catch (ServletException sx)
        {
            filterConfig.getServletContext().log(sx.getMessage());
        }
        catch (IOException iox)
        {
            filterConfig.getServletContext().log(iox.getMessage());
        }

    }

    // Clean up resources
    public void destroy()
    {
    }

    /**
     * 判断返回值是否为真
     * 
     * @param flag
     * @return
     */
    private boolean checkValidata(boolean flag)
    {
        return flag;
    }

}
