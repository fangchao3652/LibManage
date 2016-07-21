package edu.lnu.phone;

import edu.lnu.domain.Situation;
import edu.lnu.factory.BasicFactory;
import edu.lnu.service.UserService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Meiling on 2016/7/19.
 */
@WebServlet("/StudentListServletP")
public class StudentListServletP extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService userService= BasicFactory.getFactory().getService(UserService.class);

        //获取参数 sno  cno
        //获取实验课号 和课程号
        int eno = Integer.parseInt(request.getParameter("eno"));
        int cno = Integer.parseInt(request.getParameter("cno"));
        System.out.println("StudentListServletP==="+eno+"=="+cno );
        //调用service 查找 这节课的所有出勤情况
        List<Situation> situationList=userService.getSituationsByCnoEno(cno,eno);
        PrintWriter printWriter=response.getWriter();
        printWriter.print(JSONArray.fromObject(situationList).toString());
        System.out.println(JSONArray.fromObject(situationList).toString());
        printWriter.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
