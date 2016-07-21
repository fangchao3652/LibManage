package edu.lnu.web;

import edu.lnu.domain.QuestionDetail;
import edu.lnu.domain.Teacher;
import edu.lnu.factory.BasicFactory;
import edu.lnu.service.QuestionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Meiling on 2016/7/21.
 */
@WebServlet("/QuestionListServletTeacher")
public class QuestionListServletTeacher extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionService questionService= BasicFactory.getFactory().getService(QuestionService.class);
//获取老师的工号
        int tno= ((Teacher) request.getSession().getAttribute("user")).getTno();
        //根据tno 查找 该老师可以看到的题库
        List<QuestionDetail> questionDetailList=questionService.findQuestionsByTno(tno);
        //System.out.println(questionList.get(0).getOptionList().get(1));
        //存入 request 域 跳转显示
        request.setAttribute("questionDetailList",questionDetailList);
        request.getRequestDispatcher("/questionList.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
