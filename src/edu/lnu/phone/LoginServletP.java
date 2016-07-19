package edu.lnu.phone;

import edu.lnu.domain.Class;
import edu.lnu.domain.Teacher;
import edu.lnu.factory.BasicFactory;
import edu.lnu.service.ClassService;
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
 * Created by Meiling on 2016/7/18.
 */
@WebServlet("/LoginServletP")
public class LoginServletP extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService service = BasicFactory.getFactory().getService(UserService.class);
        ClassService classService = BasicFactory.getFactory().getService(ClassService.class);
        //1.获取用户名密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        Teacher teacher = service.getTeacherByNameAndPsw(username, password, "teacher");
        PrintWriter out = response.getWriter();


        if (teacher == null) {
            out.print("{flag:0,msg:\"用户名或密码不正确\"}");
        } else {
            List<Class> classList = classService.findClassesByTno(teacher.getTno());
            JSONArray jsonArray=JSONArray.fromObject(classList);
            System.out.println("{flag:1,msg:\"登录成功\",classList:"+jsonArray.toString()+"}");
            out.print("{flag:1,msg:\"登录成功\",classList:"+jsonArray.toString()+"}");

        }

        out.flush();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
