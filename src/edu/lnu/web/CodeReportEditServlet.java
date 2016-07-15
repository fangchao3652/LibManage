package edu.lnu.web;


import edu.lnu.domain.Class;
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

/**点击填写报告代码连接后 调到选择界面
 * Created by Meiling on 2016/7/15.
 */
@WebServlet(  "/CodeReportEditServlet")
public class CodeReportEditServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClassService classService= BasicFactory.getFactory().getService(ClassService.class);
        //1.获取用户编号 用户id
        User user = (User) request.getSession().getAttribute("user");
        int sno = user.getSno();
        //调用service 查找该学生所有的课程
        List<Class> classList=  classService.findClassesBySno(sno);
        //发送到jsp
        request.setAttribute("classList",classList);

        request.getRequestDispatcher("/codeReportEdit.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
    }
}
