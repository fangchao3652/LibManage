package edu.lnu.web;

import edu.lnu.domain.Score;
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
@WebServlet(name = "PreReportSubServlet")
public class PreReportSubServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取预习报告的内容
        String preReport=request.getParameter("prereport");
       // System.out.println(preReport);
        //更新score 数据表项
        ScoreService scoreService = BasicFactory.getFactory().getService(ScoreService.class);
        Score score= (Score) request.getSession().getAttribute("score");
        score.setPreReport(preReport);
        if(score!=null){
            scoreService.updatePreReport(score,preReport);
            System.out.println("ccccccccdsssssssssssss" + ((Score) request.getSession().getAttribute("score")).getPreReport());
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
