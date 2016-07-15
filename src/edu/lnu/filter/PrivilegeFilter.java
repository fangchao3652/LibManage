package edu.lnu.filter;

import edu.lnu.domain.Teacher;
import edu.lnu.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Meiling on 2016/7/15.
 */
public class PrivilegeFilter implements Filter {
    private List<String> studetnList = new ArrayList<>();
    private List<String> teachertnList = new ArrayList<>();
    User user = null;
    Teacher teacher = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            BufferedReader teacherReader = new BufferedReader(new FileReader(filterConfig.getServletContext().getRealPath("/WEB-INF/teacher.txt")));
            String line = null;
            while ((line = teacherReader.readLine()) != null) {
                teachertnList.add(line);

            }

            BufferedReader studentReader = new BufferedReader(new FileReader(filterConfig.getServletContext().getRealPath("/WEB-INF/user.txt")));

            while ((line = studentReader.readLine()) != null) {
                studetnList.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(teachertnList+"");
        System.out.println(studetnList+"");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
       uri=uri.substring(uri.indexOf(request.getContextPath())+request.getContextPath().length());
        if (teachertnList.contains(uri) || studetnList.contains(uri)) {//需要权限
            if (request.getSession(false) == null || request.getSession().getAttribute("user") == null) {
                response.getWriter().write("请先登录！");
            } else {
                Object o = request.getSession().getAttribute("user");
                if (studetnList.contains(uri) && o instanceof User) {
                    user = (User) o;
                    filterChain.doFilter(servletRequest, servletResponse);
                } else if (teachertnList.contains(uri) && o instanceof Teacher) {
                    teacher = (Teacher) o;
                    filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    throw new RuntimeException("您没有该资源的访问权限");
                }


            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {

    }


}
