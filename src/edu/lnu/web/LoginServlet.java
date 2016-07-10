package edu.lnu.web;

import edu.lnu.domain.User;
import edu.lnu.factory.BasicFactory;
import edu.lnu.service.UserService;
import edu.lnu.util.MD5Utils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Meiling on 2016/7/10.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,  HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        UserService service = BasicFactory.getFactory().getService(UserService.class);
        //1.获取用户名密码
        String username = request.getParameter("username");
        String password =  request.getParameter("password");
        String role =  request.getParameter("role");
        System.out.println(role);
        //2.调用Service中根据用户名密码查找用户的方法
        User user = service.getUserByNameAndPsw(username,password);
        if(user == null){
            request.setAttribute("msg", "用户名密码不正确!");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
        request.getSession().setAttribute("user", user);
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }

}
