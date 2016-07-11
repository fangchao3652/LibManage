<%--
  Created by IntelliJ IDEA.
  User: Meiling
  Date: 2016/7/11
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">--%>
    <title>在线问卷答题系统 </title>

    <link rel="stylesheet" type="text/css" href="css/style.css"/>

    <style type="text/css">
        .demo {
            width: 760px;
            margin: 60px auto 10px auto
        }
    </style>

    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/quiz.js"></script>
    <script type="text/javascript">
        // var init={'questions':[{'id':1,'topic':'jQuery是什么？','options':['JavaScript库','CSS库','PHP框架','以上都不是'],'answer':1},{'id':5,'topic':'找出不同类的一项?','options':['写字台','沙发','电视','桌布'],'answer':3},{'id':9,'topic':'国土面积最大的国家是：','options':['美国','中国','俄罗斯','加拿大'],'answer':3},{'id':15,'topic':'月亮距离地球多远？','options':['18万公里','38万公里','100万公里','180万公里'],'answer':2}]};

        //    var init = '${requestScope.questions}'
        var init=eval(${requestScope.questions});
        $(function () {
            $('#quiz-container').jquizzy({
                questions: init.questions,
                sendResultsURL: "${pageContext.request.contextPath}/DatiServlet",
                BaseUrl: "${pageContext.request.contextPath}"
            });
        });
    </script>
</head>

<body>

<div class="demo">
    <div id='quiz-container'></div>
</div>


</body>
</html>
