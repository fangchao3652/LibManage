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
<head>
    <title>题库列表</title>
</head>
<body>

<table width="100%" border="1" style="text-align: center">
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
