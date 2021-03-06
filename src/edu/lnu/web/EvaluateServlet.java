package edu.lnu.web;


import edu.lnu.factory.BasicFactory;
import edu.lnu.service.ScoreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * 老师填写成绩 成绩更新
 * Created by Meiling on 2016/7/14.
 */
@WebServlet(name = "EvaluateServlet")
public class EvaluateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ScoreService scoreService = BasicFactory.getFactory().getService(ScoreService.class);
        //获取 sno  eno
        int sno = Integer.parseInt(request.getParameter("sno"));
        int eno = Integer.parseInt(request.getParameter("eno"));
        System.out.println("from phone================1111111111111111");
        //获取各个成绩
        float preScore;
        float evaScore;
        float reportScore;
        float score; //总成绩
        try {
            preScore = Float.parseFloat(request.getParameter("preScore"));//预习成绩
            evaScore = Float.parseFloat(request.getParameter("evaScore"));//课上根据评价标准得出的成绩
            reportScore = Float.parseFloat(request.getParameter("reportScore"));//实验报告的成绩
            score = Float.parseFloat(request.getParameter("score"));//总成绩
        } catch (Exception e) {
            throw new RuntimeException("分数填写错误，请重新填写");
          /* request.setAttribute("errmsg","分数填写错误，请重新填写");
            request.getRequestDispatcher("/showresultTeacher.jsp").forward(request,response);*/
        }
         //更新成绩表存入这几个成绩
        scoreService.updateScore(preScore,evaScore,reportScore,score,sno,eno);
        response.sendRedirect(request.getContextPath()+"/StudentListServlet?cno="+request.getSession().getAttribute("cno")+"&eno="+request.getSession().getAttribute("eno"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    public static void main(String[] args) {
        BigDecimal bigDecimal=new BigDecimal(Double.valueOf(1.12312));
        Double.valueOf("12");
                 System.out.println(0.1f);
                 System.out.println(1.0-0.42);
                 System.out.println(4.015*100);
                 System.out.println(303.1/1000);
             }
}
