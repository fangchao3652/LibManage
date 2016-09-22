<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script language="JavaScript" src="js/jquery-3.0.0.min.js"></script>
    <title>实验报告及代码修改</title>

    <script src="ckeditor/ckeditor.js"></script>
    <script src="ckeditor/samples/js/sample.js"></script>
    <link rel="stylesheet" href="css/form.css"/>
    <%--表单校验--%>
    <script type="text/javascript" src="js/Validform_v5.3.2.js"></script>
    <%--表单校验--%>
    <script type="text/javascript">
        window.onload = function () {
            //    CKEDITOR.replace('code',{toolbarGroups:[{ name: 'insert' }] });   //下面的textarea 不要再写class="ckeditor" 否则会显示两个
            CKEDITOR.replace('report', {
                image_previewText: " ",
                height: 400,
                onpaste:false,
                filebrowserImageUploadUrl: "UploadImgCKServlet"
            });
            CKEDITOR.replace('code', {toolbar: [['CodeSnippet']], height: 400});

            $(".subform").Validform({

                tiptype: 4
            });
        }
    </script>


    <link rel="stylesheet" href="ckeditor/samples/css/samples.css">
    <link rel="stylesheet" href="ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css">
</head>
<body id="main">

<nav class="navigation-a">
    <div class="grid-container">
        <ul class="navigation-a-left grid-width-70">
            <li><a href="${pageContext.request.contextPath}/student.jsp">首页</a></li>

        </ul>
        <ul class="navigation-a-right grid-width-30">
            <li><a href="#">${sessionScope.user.name}</a></li>
        </ul>
    </div>
</nav>
<main>
    <div class="adjoined-top">
        <div class="grid-container">
            <div class="content grid-width-100">
            </div>
        </div>
    </div>
    <div class="adjoined-bottom">
        <%--<div class="grid-container">--%>
        <div class="grid-width-100">
            <form action="${pageContext.request.contextPath}/SubmitCodeReportServlet" method="post" class="subform">

<input type="hidden" name="eno" value="${score.eno}">


                代码：<br>
                <textarea name="code" id="TextArea1" onpaste="return false;"  >${score.code}</textarea>
                实验报告：<br>
                <textarea name="report" id="TextArea2" onpaste="return false;" datatype="*"
                          nullmsg="请填写实验报告">${score.report}</textarea>
                <br>
                <input type="submit" value="提	交">
            </form>
        </div>
        <%--</div>--%>
    </div>
</main>
</body>
<script language="JavaScript">
    $().ready(function () {
       // CKEDITOR.instances.TextArea1.insertHtml("df"+${score.code});
       // CKEDITOR.instances.TextArea2.insertHtml(${score.report});



    });

</script>
</html>
