package edu.lnu.web;

import edu.lnu.domain.QuestionDetail;
import edu.lnu.factory.BasicFactory;
import edu.lnu.service.QuestionService;
import net.sf.json.JSONArray;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**问题编辑
 * Created by Meiling on 2016/7/22.
 */
@WebServlet( "/UpdateQuestionServlet")
public class UpdateQuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionService questionService= BasicFactory.getFactory().getService(QuestionService.class);
        try {
            //封装数据
            QuestionDetail detail=new QuestionDetail();
            BeanUtils.populate(detail,request.getParameterMap());
            String [] options = request.getParameterValues("option");
            List<String> list=new ArrayList<>();
            for(String op : options){
               if(StringUtils.isNotEmpty(op))
                list.add(op);
            }
            JSONArray jsonArray=JSONArray.fromObject(list);
            detail.setOptions(jsonArray.toString());
            //2.调用Service中修改客户信息的方法
            questionService.updateQuestion(detail);
            //3.重定向到客户列表页面
           response.sendRedirect(request.getContextPath()+"/QuestionListServletTeacher");
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
