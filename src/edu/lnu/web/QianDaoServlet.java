package edu.lnu.web;

import edu.lnu.domain.User;
import edu.lnu.factory.BasicFactory;
import edu.lnu.service.ScoreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 学生签到
 * Created by Meiling on 2016/7/17.
 */
@WebServlet( "/QianDaoServlet")
public class QianDaoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ScoreService service = BasicFactory.getFactory().getService(ScoreService.class);
        //获取学号 及eno
        int sno = ((User) request.getSession().getAttribute("user")).getSno();
        int eno = Integer.parseInt(request.getParameter("eno"));
        //更新 签到状态
        service.updateloginStatus(sno, eno);
        System.out.println("eno=已经更新="+eno);


        response.setContentType("application/x-json");//需要设置ContentType 为"application/x-json"
        PrintWriter out = response.getWriter();
        out.println("{\"a\":1}");//拼一个json 串 要不那边收不到

        out.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
