package edu.lnu.web;

import edu.lnu.factory.BasicFactory;
import edu.lnu.service.QuestionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除 某一道题目
 * Created by Meiling on 2016/7/22.
 */
@WebServlet(  "/DelQuestionServlet")
public class DelQuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionService service= BasicFactory.getFactory().getService(QuestionService.class);

        //1.获取要删除的客户id
        String id = request.getParameter("id");
        //2.调用Servcie中根据id删除客户的方法
        service.delQuestionByID(id);
        //3.请求转发到客户列表页面
        response.sendRedirect(request.getContextPath()+"/QuestionListServletTeacher");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
