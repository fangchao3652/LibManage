<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Meiling
  Date: 2016/7/22
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <script language="JavaScript" src="js/jquery-3.0.0.min.js"></script>
    <script src="ckeditor/samples/js/sample.js"></script>
    <script language="JavaScript">
        function addOne() {
            var fdiv = document.getElementById("fdiv");
            fdiv.insertAdjacentHTML('beforeEnd','<div><input type="text" name="option" style="width: 50%;margin: 2px"   placeholder="请填写新的答案选项"/><input type="button" value="删除" onclick="delOne(this)" id="delBut"></div>');
            // fdiv.innerHTML += '<div><input type="text" name="option" style="width: 50%;margin: 2px"   placeholder="请填写新的答案选项"/><input type="button" value="删除" onclick="delOne(this)" id="delBut"></div>';
        }
        function delOne(obj) {
            obj.parentNode.parentNode.removeChild(obj.parentNode);
        }

    </script>
    <title>增加题目</title>
</head>
<body>
<div class="adjoined-bottom">
    <%--<div class="grid-container">--%>
    <div class="grid-width-100">
        <form action="${pageContext.request.contextPath}/AddQuestionServlet" method="post">


            <div class="con_panel">
                <div class="con_input">
                    <span>课程名：</span>
                    <select name="cno" id="select_k1" class="xla_k">
                        <option value="=">==请选择==</option>
                        <c:forEach items="${requestScope.classList}" var="cla">
                            <option value="${cla.cno}">${cla.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="con_input">
                    <span>实验课：</span>
                    <select name="eno"
                            id="select_k2" class="xla_k"  >
                        <option value="=">==请选择==</option>

                    </select>
                </div>
            </div>
            <table border="1" width="100%">

                <tr>
                    <td>题目</td>
                    <td><input type="text" name="topic" style="width: 50%;"/></td>
                </tr>
                <tr>
                    <td>选项</td>
                    <td>
                        <div id="fdiv">

                            <div><input type="text" name="option" style="width: 50%;margin: 2px"/><input
                                    type="button" value="删除" onclick="delOne(this)" id="delBut"></div>

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
                    <td colspan="2" style="text-align: center;">
                        <input type="submit" value="确认添加"/>
                    </td>
                </tr>
            </table>


        </form>
    </div>
    <%--</div>--%>
</div>
<script language="JavaScript">
    $().ready(function () {
        $("#select_k1").change(function () {
            var urlStr = "${pageContext.request.contextPath}/AjaxServlet";
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
                if (obj.length == 0) {
                    $("#select_k2").append('<option value=""> 无</option>');
                } else {
                    for (i = 0; i < obj.length; i++) {
                        $("#select_k2").append("<option value=" + obj[i].eno + ">" + obj[i].name + "</option>");
                    }
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

</body>
</html>
