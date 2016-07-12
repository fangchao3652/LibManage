<%--
  Created by IntelliJ IDEA.
  User: Meiling
  Date: 2016/7/11
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>预习报告</title>
    <script src="ckeditor/ckeditor.js"></script>
    <script src="ckeditor/samples/js/sample.js"></script>
    <link rel="stylesheet" href="styles/default.css">
    <script src="js/highlight.pack.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>

    <link rel="stylesheet" href="ckeditor/samples/css/samples.css">
    <link rel="stylesheet" href="ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css">
</head>
<body id="main">

<nav class="navigation-a">
    <div class="grid-container">
        <ul class="navigation-a-left grid-width-70">
            <li><a href="http://ckeditor.com">Project Homepage</a></li>
            <li><a href="http://dev.ckeditor.com/">I found a bug</a></li>
            <li><a href="http://github.com/ckeditor/ckeditor-dev" class="icon-pos-right icon-navigation-a-github">Fork
                CKEditor on GitHub</a></li>
        </ul>
        <ul class="navigation-a-right grid-width-30">
            <li><a href="http://ckeditor.com/blog-list">${sessionScope.user.name}</a></li>
        </ul>
    </div>
</nav>
<main>
    <div class="adjoined-top">
        <div class="grid-container">
            <div class="content grid-width-100">
            </div>
        </div>
    </div>
    <div class="adjoined-bottom">
        <div class="grid-container">
            <div style="height:40%; width: 80%; overflow:auto; ">

<pre>
<code class="language-java">package edu.lnu.web;

import edu.lnu.domain.Score;
import edu.lnu.domain.User;
import edu.lnu.factory.BasicFactory;
import edu.lnu.service.ScoreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Meiling on 2016/7/11.
 */
@WebServlet(name = "DatiServlet")
public class DatiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("答题servlet questions answers:" + request.getParameter("answers"));
        ScoreService scoreService = BasicFactory.getFactory().getService(ScoreService.class);
        /** 答题 题号 及学生 答案
         * [{"id":9, "userAnswer":4},{"id":10, "userAnswer":3},{"id":11, "userAnswer":4},{"id":12, "userAnswer":4}]
         */
        String jsonPreResult = request.getParameter("answers");
        //将其存入数据库 preResult 字段
        Score score = new Score();
        int eno = (int) request.getSession().getAttribute("eno");
        User user = (User) request.getSession().getAttribute("user");
        int sno = user.getSno();
        score.setSno(sno);
        score.setEno(eno);
        score.setPreResult(jsonPreResult);

         request.getSession().setAttribute("score",score);
        //插入一条score 记录 初始化三个字段
        scoreService.addScore(score);

        // String jsonstr=request.getParameter("answers");
        // JSONArray jsonArray=JSONArray.fromObject(jsonstr);
        // response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
</code></pre>

                <p>&nbsp;</p>

            </div>
        </div>
    </div>

</main>
</body>
</html>
