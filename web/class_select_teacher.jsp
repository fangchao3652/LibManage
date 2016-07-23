<!--
该页面是课程和课次选择的页面
-->


<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/xgxt_login.css"/>
    <script type="text/javascript" src="js/jquery-1.4.2.js"></script>
    <title>实验室系统</title>
</head>
<body>
<div id="header">
    <div class="header_title">
        <span class="title_con">实验室系统</span>
    </div>
</div>

<div id="content">
    <center>
        <div class="con">
            <div class="con_title">
                <span class="con_title_sp">选择您要查看的课程</span>
            </div>
            <form name="form1" class="forma" onsubmit="false">

                <div class="con_panel">
                    <span id="msg"> </span>
                    <div class="con_input">
                        <span>课程名：</span>
                        <select name="cno" id="select_k1" class="xla_k">
                            <option value="">==请选择==</option>
                            <c:forEach items="${requestScope.classList}" var="cla">
                                <option value="${cla.cno}">${cla.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="con_input">
                        <span>课&nbsp;&nbsp;&nbsp;&nbsp;次：</span>
                        <select name="eno"
                                id="select_k2" class="xla_k">
                            <option value="">==请选择==</option>

                        </select>
                    </div>
                    <div class="con_select">

                    </div>
                    <input type="button" value="查看学生信息" class="submit-btn" onClick="showList()"/><br>
                    <input type="button" value="提交题库及标准" class="submit-btn" onClick="subQE()"/>
                </div>
            </form>
        </div>
    </center>
</div>

<div style="text-align: center;"></div>
</body>
<script language="JavaScript">
    function showList() {
        var eno = $("#select_k2").val()
        if (eno == null || eno == "") {
            document.getElementById("msg").innerHTML = "<font color='red'> 请选择课程</font>";
            return false;
        } else {
            document.form1.action = "${pageContext.request.contextPath}/StudentListServlet";
            document.form1.submit();
        }
    }

    function subQE() {
        var eno = $("#select_k2").val()
        if (eno == null || eno == "") {
            document.getElementById("msg").innerHTML = "<font color='red'> 请选择课程</font>";
            return false;
        } else {
            document.form1.action = "${pageContext.request.contextPath}/subQE.jsp";
            document.form1.submit();
        }
    }


    $().ready(function () {
        $("#select_k1").change(function () {
            var urlStr = "${pageContext.request.contextPath}/AjaxServlet";
            //var user = JSON.stringify(new User(101,"阿猫"));
            var cno = $(this).val();
            //调用JQuery提供的Ajax方法
            $.ajax({
                type: "POST",
                url: urlStr,
                data: {cno: cno},
                dataType: "json",//此处要设置成jason
                success: callback
            });//回调函数

            function callback(jasonObj) {
                var str = jasonObj;
                var obj = eval(str);//解析成JSONObject
                $("#select_k2").empty();//清空原有的
                for (i = 0; i < obj.length; i++) {
                    $("#select_k2").append("<option value=" + obj[i].eno + ">" + obj[i].name + "</option>");
                }


            }
        });

    });
    /* function change1() {
     document.getElementById("select_k2").length = 0;
     //            var objselect = document.getElementById("select_k1").options(document.getElementById("select_k1").selectedIndex);
     var index = document.getElementById("select_k1").selectedIndex;


     //  alert(index+"=="+
     for (i = 0; classList.size; i++) {

     document.getElementById("select_k2").add(new Option(classList[i], classList[i]));

     }
     }*/
</script>
</html>