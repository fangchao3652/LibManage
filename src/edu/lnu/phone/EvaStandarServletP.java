package edu.lnu.phone;

import edu.lnu.domain.EvaluateStandard;
import edu.lnu.factory.BasicFactory;
import edu.lnu.service.EvaluateService;
import edu.lnu.web.EvaluateServlet;
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
@WebServlet("/EvaStandarServletP")
public class EvaStandarServletP extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EvaluateService evaluateService = BasicFactory.getFactory().getService(EvaluateService.class);
        //1.获取eno  tno
        String eno = request.getParameter("eno");
        String tno = request.getParameter("tno");

        PrintWriter out = response.getWriter();
        List<EvaluateStandard> evaluateStandardList = evaluateService.findEvaByEno(eno);
      //  response.sendRedirect(request.getContextPath() + "/teacher.jsp");
        if (evaluateStandardList != null) {
            JSONArray jsonArray = JSONArray.fromObject(evaluateStandardList);
            out.print(" {flag:1,result: " + jsonArray.toString() + "}");

        }else{
            out.print(" {flag:0,result:[]}");
        }
        out.flush();

        //{flag:1,result:[{id:1,eno:14241811,stanDesc:'试验方案结果',options:['合理','适中','不合理']},{id:2,eno:14241811,stanDesc:'试验方案结果',options:['合理','适中','不合理']}]}


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
