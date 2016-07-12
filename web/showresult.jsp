<%--
  Created by IntelliJ IDEA.
  User: Meiling
  Date: 2016/7/12
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>结果预览</title>
    <script src="ckeditor/ckeditor.js"></script>
    <script src="ckeditor/samples/js/sample.js"></script>
    <link rel="stylesheet" href="styles/default.css">
    <script src="js/highlight.pack.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>

    <link rel="stylesheet" href="ckeditor/samples/css/samples.css">
    <link rel="stylesheet" href="ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css">
</head>
<body>
<%--${requestScope.preResults[1].isCorrect}1<br>           如果bean用getIsCorrect()这个额可以--%>
<%--${requestScope.preResults[1].Correct} 2<br>--%>
<%--${requestScope.preResults[1].correct}3<br>                如果bean用isCorrect这个可以--%>
<c:forEach items="${preResults}" var="preResult" varStatus="vs">
    题目：${preResult.topic}<br>
    选项：<br>
    <c:forEach items="${preResult.options}" var="option" varStatus="s">
        <c:if test="${preResult.userAnswer==s.index+1&&preResult.userAnswer!=preResult.answer}">
            <font color="red"><c:out value="${s.index+1}."/>${option}<br></font>
        </c:if>
        <c:if test="${preResult.answer==s.index+1}">
            <font color="green"><c:out value="${s.index+1}."/>${option}<br></font>
        </c:if>
        <c:if test="${preResult.answer!=s.index+1&&preResult.userAnswer!=s.index+1}">
            <c:out value="${s.index+1}."/>${option}<br>
        </c:if>
    </c:forEach>

</c:forEach>
<div>
    ${requestScope.preReport}
</div>

</body>
</html>
