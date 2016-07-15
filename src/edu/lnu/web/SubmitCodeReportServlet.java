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
 * Created by Meiling on 2016/7/12.
 */
@WebServlet(name = "SubmitCodeReportServlet")
public class SubmitCodeReportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取code 及报告内容
        String code=request.getParameter("code");
        String report=request.getParameter("report");
        int cno= Integer.parseInt(request.getParameter("cno"));
        int eno= Integer.parseInt(request.getParameter("eno"));
        int sno=((User)request.getSession().getAttribute("user")).getSno();
        request.getSession().setAttribute("eno", eno);
        //更新score 成绩表项
        ScoreService scoreService = BasicFactory.getFactory().getService(ScoreService.class);
         Score score=  scoreService.findScoreBySnoEno(sno,eno);

        if(score!=null){
            score.setReport(report);
            scoreService.updateCodeReport(score,code,report);
            // System.out.println("ccccccccdsssssssssssss--------" + ((Score) request.getSession().getAttribute("score")).getPreReport());
            //转发到结果展示servlet
            response.sendRedirect(request.getContextPath()+"/ShowResultServlet") ;
        }else{
            throw  new RuntimeException("请先预习并填写预习报告");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
