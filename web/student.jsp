<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<div style="margin: 20px">
    <c:if test="${sessionScope.user != null}">

        欢迎回来,${sessionScope.user.name}
        <a href="${pageContext.request.contextPath}/SelectClassServlet">预习</a>
        <a href="${pageContext.request.contextPath}/CodeReportEditServlet">代码及实验报告提交</a>
        <%--<a href="${pageContext.request.contextPath}/cart.jsp">查看购物车</a>--%>
        <%--<a href="${pageContext.request.contextPath}/OrderListServlet">查看订单</a>--%>
        <a href="${pageContext.request.contextPath}/LogoutServlet">注销</a>
    </c:if>
</div>
<center>
    <img style="height:140px;width:140px" src="code.jspx"/></center>
</body>
</html>
