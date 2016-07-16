package edu.lnu.web;

import edu.lnu.domain.Experiment;
import edu.lnu.domain.User;
import edu.lnu.factory.BasicFactory;
import edu.lnu.service.ClassService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**select  class 未预习过的
 * Created by Meiling on 2016/7/10.
 */
@WebServlet( "/AjaxServletUnpred")
public class AjaxServletUnpred extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ClassService service=BasicFactory.getFactory().getService(ClassService.class);
       int  cno=Integer.parseInt(request.getParameter("cno"));
       int  sno= ((User)request.getSession().getAttribute("user")).getSno();
       // List<Experiment> experimentList=service.findExperimentsByCno(cno);//该学生 该cno所对应的所有 weiyuxi 的Experiment
        List<Experiment> experimentList=service.findExperimentsByCnoUnRep(sno,cno);//该学生 该cno所对应的所有 weiyuxi 的Experiment

        JSONArray jsonArray=JSONArray.fromObject(experimentList);
        System.out.println(cno+"AjaxServletUnpred=="+jsonArray);


        response.setContentType("application/x-json");//需要设置ContentType 为"application/x-json"
        PrintWriter out = response.getWriter();
        out.println(jsonArray.toString());//向客户端输出JSONObject字符串
        out.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
