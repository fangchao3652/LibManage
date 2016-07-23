<%--
  Created by IntelliJ IDEA.
  User: Meiling
  Date: 2016/7/20
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/form.css"/>
    <%--表单校验--%>
    <script type="text/javascript" src="js/jquery-1.4.2.js"></script>
    <script type="text/javascript" src="js/Validform_v5.3.2.js"></script>
    <%--表单校验--%>

    <script type="text/javascript">

        $().ready(function () {
            $(".forma").Validform({

                tiptype: 4
            });
        });


    </script>
    <title>提交文件</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/SubQuestionAndEvaStan" method="POST" enctype="multipart/form-data"
      class="forma">
    <table border="1">

        <tr>
            <td>题库上传</td>
            <td><input type="file" name="tk" nullmsg="请选择文件" datatype="*"/></td>
        </tr>
        <tr>
            <td>评价标准</td>
            <td><input type="file" name="pjbz" nullmsg="请选择文件" datatype="*"/></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="上传" style="align-content: center"></td>
        </tr>
    </table>
</form>

</body>
</html>
