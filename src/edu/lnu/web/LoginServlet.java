package edu.lnu.web;


import edu.lnu.domain.Score;
import edu.lnu.domain.Teacher;
import edu.lnu.domain.User;
import edu.lnu.factory.BasicFactory;
import edu.lnu.service.ClassService;
import edu.lnu.service.UserService;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Meiling on 2016/7/10.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        UserService service = BasicFactory.getFactory().getService(UserService.class);
        ClassService classService = BasicFactory.getFactory().getService(ClassService.class);
        //1.获取用户名密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        根据role决定调用哪个servie User 还是teacher user 就是student
        String role = request.getParameter("role");
        System.out.println(role);
        if ("student".equals(role)) {
            //2.调用Service中根据用户名密码查找用户的方法（或者id 和密码）
            User user = service.getUserByNameAndPsw(username, password, role);
            if (user == null) {
                request.setAttribute("msg", "用户名密码不正确!");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                return;
            }
            request.getSession().setAttribute("user", user);
            //该学生这个时间段 是该显示预习按钮还是 签到按钮
//根据学号 时间段 看是否能在score查到相应的数据项 若有 说明已经预习需要签到；若在开课时间前则显示预习界面
            List<Score> scoreList = classService.findExperimentsBySnoTime(user.getSno());
            // System.out.println(scoreList);
          if(scoreList!=null&&scoreList.size()>0){
              request.getSession().setAttribute("scoreList", scoreList);

          }
            response.sendRedirect(request.getContextPath() + "/student.jsp");
        } else if ("teacher".equals(role)) {
            //2.调用Service中根据用户名密码查找用户的方法
            Teacher teacher = service.getTeacherByNameAndPsw(username, password, role);
            if (teacher == null) {
                request.setAttribute("msg", "用户名密码不正确!");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                return;
            }
            request.getSession().setAttribute("user", teacher); //为了后面统一  这里属性名统一用user


            response.sendRedirect(request.getContextPath() + "/teacher.jsp");
        }


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }

}
