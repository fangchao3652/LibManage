package edu.lnu.web;

import edu.lnu.domain.Class;
import edu.lnu.domain.Teacher;
import edu.lnu.domain.User;
import edu.lnu.factory.BasicFactory;
import edu.lnu.service.ClassService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**老师选择课程
 * Created by Fang on 2016/7/13.
 */
@WebServlet(name = "SelectClassServletTeacher")
public class SelectClassServletTeacher extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClassService classService= BasicFactory.getFactory().getService(ClassService.class);
        //1.获取教师编号 用户id
        Teacher teacher = (Teacher) request.getSession().getAttribute("user");
        int tno = teacher.getTno();
        //调用service 查找该老师所有的课程
        List<Class> classList=  classService.findClassesByTno(tno);
        //发送到jsp
        request.setAttribute("classList",classList);

        request.getRequestDispatcher("/class_select_teacher.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
    }
}
