<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Meiling
  Date: 2016/7/14
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生列表</title>
</head>
<body style="margin: 50px">
<table width="100%" border="1" style="text-align: center">
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>预习状态</th>
        <th>签到状态</th>
        <th>评分状态</th>
    </tr>
    <c:forEach items="${situationList}" var="situation">
        <tr>
        <td><a href="${pageContext.request.contextPath}/ShowResultServletTeacher?sno=${situation.sid}&eno=${sessionScope.eno}">${situation.sid }</a></td>
        <td>${situation.name }</td>
        <td>${situation.sex }</td>
        <td>
            <c:if test="${situation.preStatus==0}">
                <font color="red">未预习</font>
            </c:if>
            <c:if test="${situation.preStatus==1}">
                <font color="blue">未填写预习报告</font>
            </c:if>
            <c:if test="${situation.preStatus==2}">
                <font color="green">已预习</font>
            </c:if>
        </td>
        <td>
            <c:if test="${situation.login==0}">
                <font color="red">未签到</font>
            </c:if>
            <c:if test="${situation.login==1}">
                <font color="green">已签到</font>
            </c:if>
        </td
        ><td>
            <c:if test="${situation.evaStatus==0}">
                <font color="red">未评分</font>
            </c:if>
            <c:if test="${situation.evaStatus==1}">
                <font color="green">已评分</font>
            </c:if>
        </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
