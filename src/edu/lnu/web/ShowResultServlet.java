package edu.lnu.web;

import edu.lnu.domain.PreResult;
import edu.lnu.domain.Question;
import edu.lnu.domain.Score;
import edu.lnu.domain.User;
import edu.lnu.factory.BasicFactory;
import edu.lnu.service.QuestionService;
import edu.lnu.service.ScoreService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**学生预习填完实验报告后
 * Created by Meiling on 2016/7/12.
 */
@WebServlet(name = "ShowResultServlet")
public class ShowResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ScoreService scoreService = BasicFactory.getFactory().getService(ScoreService.class);
        QuestionService questionService = BasicFactory.getFactory().getService(QuestionService.class);
        if(request.getSession(false)==null){
            throw  new RuntimeException("请先登录并完成预习");
        }
        //查找score

        int eno = (int) request.getSession().getAttribute("eno");
        User user = (User) request.getSession().getAttribute("user");
        Score score = scoreService.findScoreBySnoEno(user.getSno(), eno);



        //得到preResult  [{"id":9, "userAnswer":2},{"id":10, "userAnswer":4},{"id":11, "userAnswer":2},{"id":12, "userAnswer":4}]
        String preResultstr=score.getPreResult();
        //   String preResultstr = "[{\"id\":9, \"userAnswer\":2},{\"id\":10, \"userAnswer\":4},{\"id\":11, \"userAnswer\":2},{\"id\":12, \"userAnswer\":4}]";
        //解析 preResult 到 List<PreResult>
        JSONArray jsonArray = JSONArray.fromObject(preResultstr);
        List<PreResult> preResults = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);//{"id":9,"userAnswer":2}
            PreResult preResult = (PreResult) JSONObject.toBean(jsonObject, PreResult.class);
            //现在去封装其他几个字段
            //--调用service 根据id(题号）去查question
            Question question = questionService.findQuestionsById(preResult.getId());
            //得到选项json串 并解析它
            String optionStr = question.getOptions();
            List<String> options = new ArrayList<>();
            JSONArray jsonArrayOPtion = JSONArray.fromObject(optionStr);
            for (int m = 0; m < jsonArrayOPtion.size(); m++) {
                String option = jsonArrayOPtion.getString(m);
                options.add(option);
            }

            preResult.setOptions(options);
            preResult.setAnswer(question.getAnswer());
            preResult.setTopic(question.getTopic());

            preResults.add(preResult);
        }


        request.setAttribute("preResults",preResults);//预习答题
        request.setAttribute("preReport",score.getPreReport());//预习报告
        request.setAttribute("code",score.getCode());//code
        request.setAttribute("report",score.getReport());//code

        request.getRequestDispatcher("/showresult.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
