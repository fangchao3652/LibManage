package edu.lnu.web;

import edu.lnu.domain.Question;
import edu.lnu.factory.BasicFactory;
import edu.lnu.service.QuestionService;
import jdk.nashorn.api.scripting.JSObject;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Meiling on 2016/7/11.
 */
@WebServlet(name = "GetQuestionsServlet")
public class GetQuestionsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionService questionService = BasicFactory.getFactory().getService(QuestionService.class);
        //获取实验课号 和课程号
        int eno = Integer.parseInt(request.getParameter("eno"));
        int cno = Integer.parseInt(request.getParameter("cno"));
        //
        List<Question> questionList = questionService.findQuestionsByEno(eno);
        //将eno存入session
        request.getSession().setAttribute("eno", eno);
        JSONArray jsonArray = JSONArray.fromObject(questionList);
        JSONObject resultJSON = new JSONObject();//构建一个JSONObject
        resultJSON.accumulate("questions", jsonArray.toString());
        System.out.println("=======getquestions======"+resultJSON);
        request.setAttribute("questions", resultJSON);
        //转发到 页面
        request.getRequestDispatcher("/dati.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
