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

/** 选择课程后 ajax  获取预置的 table
 * Created by Meiling on 2016/9/22.
 */
@WebServlet(  "/AjaxServletReportTable")
public class AjaxServletReportTable extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int  eno=Integer.parseInt(request.getParameter("eno"));
        ClassService classService= BasicFactory.getFactory().getService(ClassService.class);
        Experiment experiment=classService.findExperimentByEno(eno);
        response.setContentType("application/x-json");//需要设置ContentType 为"application/x-json"
        PrintWriter out = response.getWriter();
        JSONObject jsonObject=JSONObject.fromObject(experiment);
        System.out.println("/AjaxServletReportTable==="+jsonObject);
        out.println(jsonObject.toString());//向客户端输出JSONObject字符串
        out.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
    }
}
