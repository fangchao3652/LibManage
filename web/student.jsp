<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>

<c:if test="${sessionScope.user != null}">

    欢迎回来,${sessionScope.user.name}
    <a href="${pageContext.request.contextPath}/SelectClassServlet">预习</a>
    <a href="${pageContext.request.contextPath}/codeReportEdit.jsp">代码及实验报告提交</a>
    <%--<a href="${pageContext.request.contextPath}/cart.jsp">查看购物车</a>--%>
    <%--<a href="${pageContext.request.contextPath}/OrderListServlet">查看订单</a>--%>
    <a href="${pageContext.request.contextPath}/LogoutServlet">注销</a>
</c:if>
</body>
</html>
