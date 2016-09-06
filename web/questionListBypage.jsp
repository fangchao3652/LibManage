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
    <script src="ckeditor/ckeditor.js"></script>
    <script src="ckeditor/samples/js/sample.js"></script>
    <link rel="stylesheet" href="ckeditor/samples/css/samples.css">
    <link rel="stylesheet" href="ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css">
    <title>题库列表</title>

    <script type="text/javascript">
        function changePage(obj) {
            if (isNaN(obj.value)) {
                alert("必须是数字!");
                obj.value =
                ${page.thispage}
                return;
            } else if (obj.value <= 0 || obj.value >${page.countpage}) {
                alert("页码必须在有效范围内!");
                obj.value =
                ${page.thispage}
                return;
            } else {
                window.location.href = "${pageContext.request.contextPath }/QuestionListServletTeacherPage?thispage=" + obj.value;
            }
        }
    </script>
</head>
<body style="text-align: center;">
<nav class="navigation-a">
    <div class="grid-container">
        <c:if test="${sessionScope.user != null}">
            <ul class="navigation-a-left grid-width-70">
                <li><a href="${pageContext.request.contextPath}/SelectClassServletTeacher">选择课程</a></li>
                <li><a href="${pageContext.request.contextPath}/AddQuestionServletPre">题库添加</a></li>
                <li><a href="${pageContext.request.contextPath}/QuestionListServletTeacher">题库编辑</a></li>
                <li><a href="${pageContext.request.contextPath}/LogoutServlet">注销</a></li>

            </ul>
            <ul class="navigation-a-right grid-width-30">
                <li><a href="#">欢迎回来,${sessionScope.user.name}</a></li>
            </ul>
        </c:if>
    </div>
</nav>
<table width="100%" border="1" style="text-align: left;margin-top: 31px">
    <tr>
        <th>课程名</th>
        <th>课程编号</th>
        <th>题目</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${page.list}" var="question">
        <tr>
            <td>${question.name}</td>
            <td>${question.eno}</td>
            <td>${question.topic}</td>
            <td><a href="${pageContext.request.contextPath}/DelQuestionServlet?id=${question.id}">删除</a></td>
            <td><a href="${pageContext.request.contextPath}/EditQuestionServletTeacher?id=${question.id}">编辑</a></td>
        </tr>
    </c:forEach>
</table>


共${page.countrow }条记录
共${page.countpage }页
<a href="${pageContext.request.contextPath }/QuestionListServletTeacherPage?thispage=${page.firstpage }">首页</a>
<a href="${pageContext.request.contextPath }/QuestionListServletTeacherPage?thispage=${page.prepage }">上一页</a>

<!-- 分页逻辑开始 -->
<c:if test="${page.countpage<=5}">
    <c:set var="begin" value="1" scope="page"></c:set>
    <c:set var="end" value="${page.countpage}" scope="page"></c:set>
</c:if>
<c:if test="${page.countpage>5}">
    <c:choose>
        <c:when test="${page.thispage<=3}">
            <c:set var="begin" value="1" scope="page"></c:set>
            <c:set var="end" value="5" scope="page"></c:set>
        </c:when>
        <c:when test="${page.thispage>=page.countpage-2}">
            <c:set var="begin" value="${page.countpage-4}" scope="page"></c:set>
            <c:set var="end" value="${page.countpage}" scope="page"></c:set>
        </c:when>
        <c:otherwise>
            <c:set var="begin" value="${page.thispage-2}" scope="page"></c:set>
            <c:set var="end" value="${page.thispage+2}" scope="page"></c:set>
        </c:otherwise>
    </c:choose>
</c:if>

<c:forEach begin="${begin}" end="${end}" step="1" var="i">
    <c:if test="${i == page.thispage}">
        ${i }
    </c:if>
    <c:if test="${i != page.thispage}">
        <a href="${pageContext.request.contextPath }/QuestionListServletTeacherPage?thispage=${i}">${i }</a>
    </c:if>
</c:forEach>

<!-- 分页逻辑结束 -->

<a href="${pageContext.request.contextPath }/QuestionListServletTeacherPage?thispage=${page.nextpage }">下一页</a>
<a href="${pageContext.request.contextPath }/QuestionListServletTeacherPage?thispage=${page.lastpage }">尾页</a>
跳到<input type="text" value="${page.thispage }" style="width: 40px" onchange="changePage(this)"/>页


</body>
</html>
