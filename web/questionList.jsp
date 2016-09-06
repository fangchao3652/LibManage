<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Meiling
  Date: 2016/7/21
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><script src="ckeditor/ckeditor.js"></script>
    <script src="ckeditor/samples/js/sample.js"></script>
    <link rel="stylesheet" href="ckeditor/samples/css/samples.css">
    <link rel="stylesheet" href="ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css">
    <title>题库列表</title>
</head>
<body>
<nav class="navigation-a">
    <div class="grid-container">
        <c:if test="${sessionScope.user != null}">
            <ul class="navigation-a-left grid-width-70">
                <li><a href="${pageContext.request.contextPath}/SelectClassServletTeacher" >选择课程</a></li>
                <li><a href="${pageContext.request.contextPath}/AddQuestionServletPre" >题库添加</a></li>
                <li><a href="${pageContext.request.contextPath}/QuestionListServletTeacher" >题库编辑</a></li>
                <li><a href="${pageContext.request.contextPath}/LogoutServlet"  >注销</a></li>

            </ul>
            <ul class="navigation-a-right grid-width-30">
                <li><a href="#">欢迎回来,${sessionScope.user.name}</a></li>
            </ul>
        </c:if>
    </div>
</nav>
<table width="100%" border="1" style="text-align: left;margin-top: 31px"   >
    <tr>
       <th>课程名</th>
       <th>课程编号</th>
       <th>题目</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${questionDetailList}" var="question">
        <tr>
            <td>${question.name}</td>
            <td>${question.eno}</td>
            <td>${question.topic}</td>
            <td><a href="${pageContext.request.contextPath}/DelQuestionServlet?id=${question.id}">删除</a></td>
            <td><a href="${pageContext.request.contextPath}/EditQuestionServletTeacher?id=${question.id}">编辑</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
