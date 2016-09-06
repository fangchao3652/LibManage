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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>预习报告</title>
    <script src="ckeditor/ckeditor.js"></script>
    <script src="ckeditor/samples/js/sample.js"></script>
    <link rel="stylesheet" href="ckeditor/samples/css/samples.css">
    <link rel="stylesheet" href="ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css">
</head>
<body id="main">

<nav class="navigation-a">
    <div class="grid-container">
        <ul class="navigation-a-left grid-width-70">
                <li><a href="${pageContext.request.contextPath}/SelectClassServlet" >预习</a></li>
            <li><a href="${pageContext.request.contextPath}/CodeReportEditServlet"  >代码及实验报告提交</a>
            </li> </ul>
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
            <div class="grid-width-100">
                <form action="${pageContext.request.contextPath}/PreReportSubServlet" method="post">
                    <textarea name="prereport" id="TextArea1" onpaste="return false;" class="ckeditor"  ></textarea>
                    <input type="submit" value="提	交"  />
                </form>
            </div>
        </div>
    </div>
</main>
</body>
</html>
