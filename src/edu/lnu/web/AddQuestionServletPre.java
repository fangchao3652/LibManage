package edu.lnu.web;

import edu.lnu.domain.Class;
import edu.lnu.domain.Teacher;
import edu.lnu.factory.BasicFactory;
import edu.lnu.service.ClassService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 查询出 该老师教的课  并传递给 addQuetion.jsp  供页面下拉选择课程使用
 * Created by Meiling on 2016/7/22.
 */
@WebServlet("/AddQuestionServletPre")
public class AddQuestionServletPre extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClassService classService= BasicFactory.getFactory().getService(ClassService.class);
        //1.获取教师编号 用户id
        Teacher teacher = (Teacher) request.getSession().getAttribute("user");
        int tno = teacher.getTno();
        //调用service 查找该老师所有的课程
        List<Class> classList=  classService.findClassesByTno(tno);
        //发送到jsp
        request.setAttribute("classList",classList);

        request.getRequestDispatcher("/addQuestion.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
