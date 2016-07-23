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
    <link rel="stylesheet" href="css/form.css"/>
    <%--表单校验--%>
    <script type="text/javascript" src="js/jquery-1.4.2.js"></script>
    <script type="text/javascript" src="js/Validform_v5.3.2.js"></script>
    <%--表单校验--%>

    <script type="text/javascript">

        $().ready(function () {
            $(".loginform").Validform({

                tiptype: 4
            });
        });


    </script>
    <title>实验室系统</title>
    <style>
        .loginform li {
            padding-bottom: 20px;
        }

        .Validform_checktip {
            margin-left: 10px;
        }

        .loginform .label {
            display: inline-block;
            width: 70px;
        }

    </style>
</head>
<body>
<div id="header">
    <div class="header_title">
        <span class="title_con">实验室系统</span>
    </div>
</div>
<%--<c:if test="${sessionScope.user == null}">--%>
<div id="content">
    <center>
        <div class="con">
            <div class="con_title">
                <span class="con_title_sp">欢迎登录实验室系统</span>
            </div>
            <div class="con_panel">
                <font color="red">${msg }</font>

                <form action="${pageContext.request.contextPath}/LoginServlet" method="POST" class="loginform">

                    <%--<ul  >--%>
                    <%--<li>--%>
                    <%--<label class="label">用户名</label>--%>
                    <%--<input type="text" value="${param.username }" name="username" placeholder="学号/工号" class="inputxt"--%>
                    <%--datatype="*" nullmsg="请输入用户名!">--%>
                    <%--<span class="Validform_checktip">dddddddddddddd</span>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                    <%--<label class="label">密码</label>--%>
                    <%--<input type="password" value="${param.username }" name="password"  placeholder="密码" nullmsg="请输入密码"--%>
                    <%--datatype="*" class="inputxt" >--%>
                    <%--<span class="Validform_checktip"></span>--%>
                    <%--</li>--%>
                    <%--</ul>--%>
                    <div class="con_input">
                        <span>用户名：</span>
                        <input type="text" placeholder="学号/工号" name="username" datatype="*" nullmsg="请输入用户名!" sucmsg=""
                               value="${param.username }"/>

                        <br>
                        <span class="Validform_checktip"></span>
                    </div>
                    <div class="con_input">
                        <span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span>
                        <input type="password" placeholder="密码" nullmsg="请输入密码" datatype="*" name="password" sucmsg=""/>
                        <br>
                        <span class="Validform_checktip"></span>
                    </div>
                    <div class="con_select">
                        <input type="radio" name="role" value="student" checked="checked" id="s"/><label
                            for="s">学生</label>
                        <input type="radio" name="role" value="teacher" id="t"/><label for="t">教师</label>
                        <input type="radio" name="role" value="admin" id="a"/><label for="a">管理员</label>
                    </div>
                    <input type="submit" value="登    录" class="submit-btn"/>
                </form>
            </div>
        </div>
    </center>
</div>
<%--</c:if>--%>
<%--
<c:if test="${sessionScope.user != null}">

    欢迎回来,${sessionScope.user.name}
    <a href="${pageContext.request.contextPath}/SelectClassServlet">预习</a>
    <a href="${pageContext.request.contextPath}/codeReportEdit.jsp">代码及实验报告提交</a>
    &lt;%&ndash;<a href="${pageContext.request.contextPath}/cart.jsp">查看购物车</a>&ndash;%&gt;
    &lt;%&ndash;<a href="${pageContext.request.contextPath}/OrderListServlet">查看订单</a>&ndash;%&gt;
    <a href="${pageContext.request.contextPath}/LogoutServlet">注销</a>
</c:if>--%>


<div style="text-align:center;">
</div>


</body>
</html>