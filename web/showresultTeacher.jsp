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
    <%--ckeditor-Begin--%>
    <script src="ckeditor/ckeditor.js"></script>
    <script src="ckeditor/samples/js/sample.js"></script>
    <link rel="stylesheet" href="ckeditor/samples/css/samples.css">
    <link rel="stylesheet" href="ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css">
    <%--ckeditor-End--%>
    <%--代码高亮显示-Begin--%>
    <link rel="stylesheet" href="styles/default.css">
    <script src="js/highlight.pack.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
    <%--代码高亮显示-End--%>
    <link rel="stylesheet" href="css/form.css"/>
    <%--表单校验--%>
    <script type="text/javascript" src="js/jquery-1.4.2.js"></script>
    <script type="text/javascript" src="js/Validform_v5.3.2.js"></script>
    <%--表单校验--%>


    <script type="text/javascript">

        $().ready(function () {
            $(".evaform").Validform({

                tiptype: 4,
                datatype: {
                    "score": function (gets, obj, curform, regxp) {
                        //参数gets是获取到的表单元素值，obj为当前表单元素，curform为当前验证的表单，regxp为内置的一些正则表达式的引用;
                        var reg1 = /^[0-9]+\.?[0-9]{0,2}$/;
                        if (reg1.test(gets)) {
                            return true;
                        }

                        return false;
                    }
                }
            });
        });


    </script>
</head>
<body style="margin: 50px">
<%--${requestScope.preResults[1].isCorrect}1<br>           如果bean用getIsCorrect()这个额可以--%>
<%--${requestScope.preResults[1].Correct} 2<br>--%>
<%--${requestScope.preResults[1].correct}3<br>                如果bean用isCorrect这个可以--%>
<c:forEach items="${preResults}" var="preResult" varStatus="vs">
    题目：<strong >${preResult.topic}</strong><br>

    <c:forEach items="${preResult.options}" var="option" varStatus="s">
        <c:if test="${preResult.userAnswer==s.index+1&&preResult.userAnswer!=preResult.answer}">
            <font color="red"><c:out value="${s.index+1}. "/>${option}<br></font>
        </c:if>
        <c:if test="${preResult.answer==s.index+1}">
            <font color="green"><c:out value="${s.index+1}. "/>${option}<br></font>
        </c:if>
        <c:if test="${preResult.answer!=s.index+1&&preResult.userAnswer!=s.index+1}">
            <c:out value="${s.index+1}. "/>${option}<br>
        </c:if>
    </c:forEach>

</c:forEach>
<div>
    预习报告：<br><br><br>

    ${requestScope.score.preReport}
</div>
<div>
    代码：<br><br>
    ${requestScope.score.code}
</div>
<div>
    实验报告：<br><br>
    ${requestScope.score.report}
</div>
<form action="${pageContext.request.contextPath}/EvaluateServlet" method="post" class="evaform">
    <td><font color="red">${errmsg }</font></td>
    <input type="hidden" name="sno" value="${score.sno}">
    <input type="hidden" name="eno" value="${score.eno}">
    预习报告成绩： <input type="text" name="preScore" value="${score.preScore}" datatype="score" errormsg="请填写正确的分数"><br>
    课上操作成绩： <input type="text" name="evaScore" value="${score.evaScore}" datatype="score" errormsg="请填写正确的分数"><br>
    实验报告成绩： <input type="text" name="reportScore" value="${score.reportScore}" datatype="score" errormsg="请填写正确的分数"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
