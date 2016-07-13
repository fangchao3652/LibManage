<!--
该页面是登录的页面，包括管理员，学生和教师
用户名，密码


-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/xgxt_login.css"/>


    <title>实验室系统</title>
</head>
<body>
<div id="header">
    <div class="header_title">
        <span class="title_con">实验室系统</span>
    </div>
</div>
<c:if test="${sessionScope.user == null}">
    <div id="content">
        <center>
            <div class="con">
                <div class="con_title">
                    <span class="con_title_sp">欢迎登录实验室系统</span>
                </div>
                <div class="con_panel">
                    <font color="red">${msg }</font>

                    <form action="${pageContext.request.contextPath}/LoginServlet" method="POST">
                        <div class="con_input">
                            <span>用户名：</span><input type="text" placeholder="学号/工号" name="username"/>
                        </div>
                        <div class="con_input">
                            <span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span><input type="text" placeholder="密码"
                                                                           name="password"/>
                        </div>
                        <div class="con_select">
                            <input type="radio" name="role" value="student" checked="checked"/>学生
                            <input type="radio" name="role" value="teacher"/>教师
                            <input type="radio" name="role" value="admin"/>管理员
                        </div>
                        <input type="submit" value="登    录" class="submit-btn"/>
                    </form>
                </div>
            </div>
        </center>
    </div>
</c:if>

<c:if test="${sessionScope.user != null}">

    欢迎回来,${sessionScope.user.name}
    <a href="${pageContext.request.contextPath}/SelectClassServlet">预习</a>
    <a href="${pageContext.request.contextPath}/codeReportEdit.jsp">代码及实验报告提交</a>
    <%--<a href="${pageContext.request.contextPath}/cart.jsp">查看购物车</a>--%>
    <%--<a href="${pageContext.request.contextPath}/OrderListServlet">查看订单</a>--%>
    <a href="${pageContext.request.contextPath}/LogoutServlet">注销</a>
</c:if>


<div style="text-align:center;">
</div>


</body>
</html>