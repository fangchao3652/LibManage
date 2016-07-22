<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title> 编辑试题</title>
    <script type="text/javascript">
        function addOne() {
            var fdiv = document.getElementById("fdiv");
            fdiv.insertAdjacentHTML('beforeEnd','<div><input type="text" name="option" style="width: 50%;margin: 2px"   placeholder="请填写新的答案选项"/><input type="button" value="删除" onclick="delOne(this)" id="delBut"></div>');
           // fdiv.innerHTML += '<div><input type="text" name="option" style="width: 50%;margin: 2px"   placeholder="请填写新的答案选项"/><input type="button" value="删除" onclick="delOne(this)" id="delBut"></div>';
        }
        function delOne(obj) {
            obj.parentNode.parentNode.removeChild(obj.parentNode);
        }

    </script>
</head>
<body style="text-align: left;">

<form action="${pageContext.request.contextPath}/UpdateQuestionServlet" method="post">
    <input type="hidden" name="id" value="${questionDetail.id }">
    <input type="hidden" name="name" value="${questionDetail.name }">
    <input type="hidden" name="eno" value="${questionDetail.eno }">
    <table border="1" width="100%">
        <tr>
            <td>课程号</td>
            <td><input type="text"   style="width: 50%;" value="${questionDetail.eno}" disabled='disabled'/>
            </td>
        </tr>
        <tr>
            <td>课程名</td>
            <td><input style="width: 50%;" type="text"  value="${questionDetail.name}" disabled='disabled'/>
            </td>
        </tr>
        <tr>
            <td>题目</td>
            <td><input type="text" name="topic" style="width: 50%;" value="${questionDetail.topic}"/></td>
        </tr>
        <tr>
            <td>选项</td>
            <td>
                <div id="fdiv">
                    <c:forEach items="${questionDetail.optionList}" var="option">
                        <div><input type="text" name="option" style="width: 50%;margin: 2px" value="${option}"/><input
                                type="button" value="删除" onclick="delOne(this)" id="delBut"></div>
                    </c:forEach>
                </div>
                <input type="button" value="增加选项" onclick="addOne()" id="addBut">
            </td>
        </tr>
        <tr>
            <td>正确答案</td>
            <td><input type="text" name="answer" style="width: 50%;" value="${questionDetail.answer}"
                       placeholder="正确答案（eg:2代表第二个是正确的）"/></td>
        </tr>
        <tr>
            <td colspan="2"  style="text-align: center;">
                <input type="submit" value="提 交 修 改 "/>
            </td>
        </tr>
    </table>

</form>
</center>
</body>
</html>