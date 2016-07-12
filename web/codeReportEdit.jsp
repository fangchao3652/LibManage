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
    <title>实验报告及代码编辑</title>
    <script src="ckeditor/ckeditor.js"></script>
    <script src="ckeditor/samples/js/sample.js"></script>
    <script type="text/javascript">
        window.onload = function () {
            //    CKEDITOR.replace('code',{toolbarGroups:[{ name: 'insert' }] });   //下面的textarea 不要再写class="ckeditor" 否则会显示两个
            CKEDITOR.replace('code', {toolbar: [['CodeSnippet']], height: 400});
        }
    </script>


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
        <%--<div class="grid-container">--%>
        <div class="grid-width-100">
            <form action="${pageContext.request.contextPath}/SubmitCodeReportServlet" method="post">
                代码：<br>
                <textarea name="code" id="TextArea1" onpaste="return false;"></textarea>
                实验报告<br>
                <textarea name="report" id="TextArea1" onpaste="return false;" class="ckeditor"></textarea>
                <br>
                <input type="submit" value="提	交">
            </form>
        </div>
        <%--</div>--%>
    </div>
</main>
</body>
</html>
