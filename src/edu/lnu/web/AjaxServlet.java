package edu.lnu.web;

import edu.lnu.domain.Experiment;
import edu.lnu.factory.BasicFactory;
import edu.lnu.service.ClassService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Meiling on 2016/7/10.
 */
@WebServlet(name = "AjaxServlet")
public class AjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ClassService service=BasicFactory.getFactory().getService(ClassService.class);
       int  cno=Integer.parseInt(request.getParameter("cno"));
        System.out.println(cno+"  ============!!!!!==============");


     List<Experiment> experimentList=service.findExperimentsByCno(cno);

        JSONArray jsonArray=JSONArray.fromObject(experimentList);
        System.out.println(jsonArray);


        response.setContentType("application/x-json");//需要设置ContentType 为"application/x-json"
        PrintWriter out = response.getWriter();
        out.println(jsonArray.toString());//向客户端输出JSONObject字符串
        out.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
