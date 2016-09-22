<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script language="JavaScript" src="js/jquery-3.0.0.min.js"></script>
    <title>实验报告及代码编辑</title>
    <%--禁止复制黏贴--%>
    <script>
        document.oncontextmenu = function(){
            return false;
        }
        document.onkeydown = function(){
            if (event.ctrlKey || window.event.keyCode==67){
                return false;
            }
        }
        document.body.oncopy = function (){
            return false;
        }
        document.onselectstart = function(){
return false;
        }
    </script>
    <%--禁止复制黏贴--%>
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


                <div class="con_panel">
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
                        <span>已预习过的课次：</span>
                        <select name="eno" datatype="*" nullmsg="请选择课程"
                                id="select_k2" class="xla_k" style="width:80px">
                            <option value="">==请选择==</option>

                        </select>
                    </div>
                </div>


                代码：<br>
                <textarea name="code" id="TextArea1" onpaste="return false;" nullmsg="请插入代码"></textarea>
                实验报告：<br>
                <textarea name="report" id="TextArea2" onpaste="return false;" datatype="*"
                          nullmsg="请填写实验报告"></textarea>
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
        $("#select_k1").change(function () {
            var urlStr = "${pageContext.request.contextPath}/AjaxServletPred";
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
                    $("#select_k2").append('<option value="">===请选择===</option>');
                    for (i = 0; i < obj.length; i++) {
                        $("#select_k2").append("<option value=" + obj[i].eno + ">" + obj[i].name + "</option>");
                    }
                }

            }
        });

        $("#select_k2").change(function () {
            //获取该实验课 预置的 表格数据
            var urlStr = "${pageContext.request.contextPath}/AjaxServletReportTable";
            var eno = $(this).val();

            //清空值 (防止在后面追加插入)
            CKEDITOR.instances.TextArea2.setData('');
            //调用JQuery提供的Ajax方法
            $.ajax({
                type: "POST",
                url: urlStr,
                data: {eno: eno},
                dataType: "json",//此处要设置成jason
                success: callback
            });//回调函数

            function callback(jasonObj) {
                var str = jasonObj;
                var obj = eval(str);//解析成JSONObject

                //设置值
                CKEDITOR.instances.TextArea2.insertHtml(obj.tablehtml);
                //$("#TextArea2").append(obj.tablehtml);

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
