package edu.lnu.web;

import edu.lnu.domain.QuestionDetail;
import edu.lnu.factory.BasicFactory;
import edu.lnu.service.QuestionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Meiling on 2016/7/21.
 */
@WebServlet("/EditQuestionServletTeacher")
public class EditQuestionServletTeacher extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionService questionService= BasicFactory.getFactory().getService(QuestionService.class);
        //获取要编辑的question 的 id
        int id= Integer.parseInt(request.getParameter("id"));
        QuestionDetail questionDetail=questionService.findQuestionDetailById(id);
        request.setAttribute("questionDetail",questionDetail);
        request.getRequestDispatcher("/question_edit.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
