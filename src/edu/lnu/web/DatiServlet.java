package edu.lnu.web;

import edu.lnu.domain.Score;
import edu.lnu.domain.User;
import edu.lnu.factory.BasicFactory;
import edu.lnu.service.ScoreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Meiling on 2016/7/11.
 */
@WebServlet(name = "DatiServlet")
public class DatiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("答题servlet questions answers:" + request.getParameter("answers"));
        ScoreService scoreService = BasicFactory.getFactory().getService(ScoreService.class);
        /** 答题 题号 及学生 答案
         * [{"id":9, "userAnswer":4},{"id":10, "userAnswer":3},{"id":11, "userAnswer":4},{"id":12, "userAnswer":4}]
         */
        String jsonPreResult = request.getParameter("answers");
        //将其存入数据库 preResult 字段
        Score score = new Score();
        int eno = (int) request.getSession().getAttribute("eno");
        User user = (User) request.getSession().getAttribute("user");
        int sno = user.getSno();
        score.setSno(sno);
        score.setEno(eno);
        score.setPreResult(jsonPreResult);

         request.getSession().setAttribute("score",score);
        //插入一条score 记录 初始化三个字段
        scoreService.addScore(score);

        // String jsonstr=request.getParameter("answers");
        // JSONArray jsonArray=JSONArray.fromObject(jsonstr);
        // response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
