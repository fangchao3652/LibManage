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
    <title>提交文件</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/SubQuestionAndEvaStan" method="POST" enctype="multipart/form-data"
      onsubmit="return checkData()">
    <table border="1">

        <tr>
            <td>题库上传</td>
            <td><input type="file" name="tk"/></td>
        </tr>
        <tr>
            <td>评价标准</td>
            <td><input type="file" name="pjbz"/></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="上传"></td>
        </tr>
    </table>
</form>

</body>
</html>
