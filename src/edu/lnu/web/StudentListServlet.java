package edu.lnu.web;

import edu.lnu.domain.Situation;
import edu.lnu.factory.BasicFactory;
import edu.lnu.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.List;

/**
 * 老师选择这门课后 查看该实验课学生的实验情况
 * Created by Meiling on 2016/7/14.
 */
@WebServlet(name = "StudentListServlet")
public class StudentListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService= BasicFactory.getFactory().getService(UserService.class);

 //获取参数 sno  cno
        //获取实验课号 和课程号
        int eno = Integer.parseInt(request.getParameter("eno"));
        int cno = Integer.parseInt(request.getParameter("cno"));
        //保存eno 到session
        request.getSession().setAttribute("eno", eno);
        request.getSession().setAttribute("cno", cno);


        //调用service 查找 这节课的所有出勤情况
        List<Situation> situationList=userService.getSituationsByCnoEno(cno,eno);
        //System.out.println(situationList);
        request.setAttribute("situationList",situationList);
        //转发 显示 学生列表
        request.getRequestDispatcher("/situationList.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
