<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>

<c:if test="${sessionScope.user != null}">

    欢迎回来,${sessionScope.user.name}
    <a href="${pageContext.request.contextPath}/SelectClassServletTeacher">选择课程</a>

</c:if>
</body>
</html>
