<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生首页</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script language="JavaScript" src="js/jquery-3.0.0.min.js"></script>
    <script src="ckeditor/ckeditor.js"></script>
    <script src="ckeditor/samples/js/sample.js"></script>
    <link rel="stylesheet" href="ckeditor/samples/css/samples.css">
    <link rel="stylesheet" href="ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css">
    <script language="JavaScript">

        function qiandao() {


             var urlStr = "${pageContext.request.contextPath}/QianDaoServlet";
               var eno=0;
                eno= ${scoreList[0].eno};
             //调用JQuery提供的Ajax方法
             $.ajax({
             type: "POST",
             url: urlStr,
             data: {eno: eno},
             dataType: "json",//此处要设置成jason
             success: callback
             });//回调函数

             function callback(jasonObj) {
             var str = jasonObj;
            // var obj = eval(str);//解析成JSONObject
                 $("#a1").text('已签到');
                 $("#a1").removeAttr('onclick');
                 $("#a1").attr('href',"#");
                 alert("${experimentList[0].name} 已签到");
             }

        }
    </script>
</head>
<body>


<nav class="navigation-a">
    <div class="grid-container">
        <c:if test="${sessionScope.user != null}">
            <ul class="navigation-a-left grid-width-70">
                <c:if test="${scoreList!=null }&& ${scoreList[0].login==0}">
                    <li><a id="a1" onclick="qiandao()">签到</a></li>
                </c:if>
                <c:if test="${scoreList!=null }&& ${scoreList[0].login!=0}">
                    <li><a  >已签到</a></li>
                </c:if>
                <c:if test="${scoreList==null}">
                    <li><a href="${pageContext.request.contextPath}/SelectClassServlet" target="_blank">预习</a></li>
                </c:if>
                <li><a href="${pageContext.request.contextPath}/CodeReportEditServlet" target="_blank">代码及实验报告提交</a>
                </li>
                <li><a href="${pageContext.request.contextPath}/LogoutServlet">注销</a></li>
            </ul>
            <ul class="navigation-a-right grid-width-30">
                <li><a href="#">欢迎回来,${sessionScope.user.name}</a></li>
            </ul>
        </c:if>
    </div>
</nav>

<div style="margin-top: 120px">
    <center><img style="height:140px;width:140px" src="code.jspx"/><br><br><br>
        请勿关闭此页,二维码用作老师验收时扫描使用,若不小心关闭请先关闭浏览器重新登录

    </center>
</div>
</body>
</html>
