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
 * 学生 提交代码及实验报告后 修改实验报告
 * Created by Meiling on 2016/9/22.
 */
@WebServlet( "/EditReportServlet")
public class EditReportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ScoreService scoreService = BasicFactory.getFactory().getService(ScoreService.class);
        int eno = (int) request.getSession().getAttribute("eno");
        User user = (User) request.getSession().getAttribute("user");
        Score score = scoreService.findScoreBySnoEno(user.getSno(), eno);

        request.setAttribute("score",score);
        request.getRequestDispatcher("/report_edit.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
