<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生首页</title>
    <script src="ckeditor/ckeditor.js"></script>
    <script src="ckeditor/samples/js/sample.js"></script>
    <link rel="stylesheet" href="ckeditor/samples/css/samples.css">
    <link rel="stylesheet" href="ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css">

</head>
<body>


<nav class="navigation-a">
    <div class="grid-container">
        <c:if test="${sessionScope.user != null}">
            <ul class="navigation-a-left grid-width-70">
                <li><a href="${pageContext.request.contextPath}/SelectClassServlet" target="_blank">预习</a></li>
                <li><a href="${pageContext.request.contextPath}/CodeReportEditServlet" target="_blank">代码及实验报告提交</a>
                </li>
                <li><a href="${pageContext.request.contextPath}/LogoutServlet">注销</a></li>
            </ul>
            <ul class="navigation-a-right grid-width-30">
                <li><a href="#">欢迎回来,${sessionScope.user.name}</a></li>
            </ul>
        </c:if>
    </div>
</nav>

<div style="margin-top: 120px">
    <center><img style="height:140px;width:140px" src="code.jspx"/><br><br><br>
        请勿关闭此页,二维码用作老师验收时扫描使用,若不小心关闭请先关闭浏览器重新登录

    </center>
</div>
</body>
</html>
