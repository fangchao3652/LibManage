<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Insert title here</title>
</head>
<body>

<form>
    <table>
        <tr>
            <td>课程号</td>
            <td><input type="text" name="eno" value="${questionDetail.eno}"/></td>
        </tr>
        <tr>
            <td>课程名</td>
            <td><input type="text" name="name" value="${questionDetail.name}"/></td>
        </tr>
         <tr>
            <td>题目</td>
            <td><input type="text" name="topic" value="${questionDetail.topic}"/></td>
        </tr>
          <tr>
            <td>选项</td>
            <td>
                <c:forEach items="${questionDetail.optionList}" var="option">
                    <input type="text" name="option" value="${option}"/>
                </c:forEach>
            </td>
        </tr>

    </table>
</form>
</center>
</body>
</html>