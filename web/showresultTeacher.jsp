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
    <title>学生成绩</title>
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

    <%--折叠start--%>

    <style type="text/css">
        dl, dt, dd, h5, p {
            padding: 0px;
            margin: 0px;
            font-size: 10pt;
        }

        dl {
            width: 80%;
            height: auto;
            display: block;
            overflow: hidden;
            margin: 0 auto;
            font-size: 10pt;
            line-height: 160%;
        }

        dt, dt a {
            width: 100%;
            height: auto;
            display: block;
            font-weight: bold;
            color: #333;
            font-size: 10.5pt;
            cursor: pointer;
            text-decoration: none;
        }

        dt a:hover {
            text-decoration: underline;
            color: #FF0000;
        }

        dd, p {
            text-indent: 2em;
        }
    </style>

    <script>
        var number = 6; //定义条目数

        function LMYC() {
            var lbmc;
            for (i = 1; i <= number; i++) {
                lbmc = eval('LM' + i);
                lbmc.style.display = 'none';
            }
        }

        function ShowFLT(i) {
            lbmc = eval('LM' + i);
            if (lbmc.style.display == 'none') {
                LMYC();
                lbmc.style.display = '';
            }
            else {
                lbmc.style.display = 'none';
            }
        }
    </script>
    <%--折叠end--%>

</head>
<body style="margin: 50px">
<%--${requestScope.preResults[1].isCorrect}1<br>           如果bean用getIsCorrect()这个额可以--%>
<%--${requestScope.preResults[1].Correct} 2<br>--%>
<%--${requestScope.preResults[1].correct}3<br>                如果bean用isCorrect这个可以--%>

<nav class="navigation-a">
    <div class="grid-container">
        <c:if test="${sessionScope.user != null}">
            <ul class="navigation-a-left grid-width-70">
                <li><a href="${pageContext.request.contextPath}/SelectClassServletTeacher">选择课程</a></li>
                <li><a href="${pageContext.request.contextPath}/AddQuestionServletPre">题库添加</a></li>
                    <%--<li><a href="${pageContext.request.contextPath}/QuestionListServletTeacher" >题库编辑</a></li>--%>
                <li><a href="${pageContext.request.contextPath}/QuestionListServletTeacherPage?thispage=1">题库编辑</a></li>
                <li><a href="${pageContext.request.contextPath}/LogoutServlet">注销</a></li>

            </ul>
            <ul class="navigation-a-right grid-width-30">
                <li><a href="#">欢迎回来,${sessionScope.user.name}</a></li>
            </ul>
        </c:if>
    </div>
</nav>
<dl>
    <dt onClick=javascript:ShowFLT(1) href="javascript:void(null)"><a href="javascript:;">预习答题情况</a></dt>
    <div id=LM1 style="DISPLAY: none">
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
    </div>
    <br>
    <dt onClick=javascript:ShowFLT(2) href="javascript:void(null)"><a href="javascript:;">课堂评价结果</a></dt>
    <div id=LM2 style="DISPLAY: none">
        <div>
            <c:forEach items="${evaluateStandardList}" var="eva">
                标准：<strong >${eva.stanDesc}</strong><br>
                <c:forEach items="${eva.optionList}" var="option" varStatus="s">
                    <c:if test="${eva.select==s.index}">
                        <font color="green"> ${option}<br></font>
                    </c:if>
                    <c:if test="${eva.select!=s.index}">
                        ${option}<br>
                    </c:if>

                </c:forEach>
            </c:forEach>

        </div>
    </div>
    <br>
    <dt onClick=javascript:ShowFLT(3) href="javascript:void(null)"><a href="javascript:;">图片</a></dt>
    <dd id=LM3 style="DISPLAY: none">
        <div>
            <table width="100%" style="text-align: center;">
                <c:forEach items="${pictureList}" var="picture">
                    <tr>
                        <td width="80%"><img width="500"
                                             src="${pageContext.request.contextPath}/ImgServlet?imgurl=${picture}"
                                             style="cursor: pointer;"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <hr>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </dd>
    <br>
    <dt onClick=javascript:ShowFLT(4) href="javascript:void(null)"><a href="javascript:;">预习报告</a></dt>
    <dd id=LM4 style="DISPLAY: none">
        <div>

            ${requestScope.score.preReport}
        </div>
    </dd>

    <br>
    <dt onClick=javascript:ShowFLT(5) href="javascript:void(null)"><a href="javascript:;">代码</a></dt>
    <dd id=LM5 style="DISPLAY: none">
        <div>

            ${requestScope.score.code}
        </div>
    </dd>
    <br>
    <dt onClick=javascript:ShowFLT(6) href="javascript:void(null)"><a href="javascript:;">实验报告</a></dt>


        <div id=LM6 style="DISPLAY: none">

            ${requestScope.score.report}
        </div>


    </dl>
    <br>
    <form action="${pageContext.request.contextPath}/EvaluateServlet" method="post" class="evaform">
        <td><font color="red">${errmsg }</font></td>
        <input type="hidden" name="sno" value="${score.sno}">
        <input type="hidden" name="eno" value="${score.eno}">
        预习报告成绩： <input type="text" name="preScore" id="preScore" value="${score.preScore}" datatype="score"
                       errormsg="请填写正确的分数" onchange="changeScore(this)"><br>
        课上操作成绩： <input type="text" name="evaScore" id="evaScore" value="${score.evaScore}" datatype="score"
                       errormsg="请填写正确的分数" onchange="changeScore(this)"><br>
        实验报告成绩： <input type="text" name="reportScore" id="reportScore" value="${score.reportScore}" datatype="score"
                       errormsg="请填写正确的分数" onchange="changeScore(this)"><br>


        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;总成绩： <input type="text" name="score" id="score" datatype="score" errormsg="请填写正确的分数"><br>
        <input type="submit" value="提交">
    </form>
    <script type="text/javascript">
        $().ready(function () {
            var preScore = parseFloat(document.getElementById("preScore").value);
            var evaScore = parseFloat(document.getElementById("evaScore").value);
            var reportScore = parseFloat(document.getElementById("reportScore").value);
            var score = (preScore + evaScore + reportScore) / 3;
            score = score.toFixed(2)
            document.getElementById("score").value = score;
        });

        function changeScore(obj) {
            if (isNaN(obj.value)) {
                alert("必须是数字!");

                return;

            } else {
                var preScore = parseFloat(document.getElementById("preScore").value);
                var evaScore = parseFloat(document.getElementById("evaScore").value);
                var reportScore = parseFloat(document.getElementById("reportScore").value);
                var score = (preScore + evaScore + reportScore) / 3;
                score = score.toFixed(2)
                document.getElementById("score").value = score;
            }
        }
    </script>
</body>
</html>
