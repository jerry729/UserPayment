<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<!DOCTYPE html>
<html>
<head>
    <title>登录</title>
    <meta charset="utf-8">
    <link href="css/style.css" rel='stylesheet' type='text/css' />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <script src="<%=path%>/admin/assets/js/core/jquery.3.2.1.min.js"></script>
</head>
<body>
<style>
    select{
        text-align: left;
        position: relative;
        width: 100%;
        padding: 3%;
        background: #D3D3D3;
        margin-bottom: 6%;
        font-family: 'Open Sans', sans-serif;
        color: #676767;
        font-weight: 600;
        font-size: 16px;
        outline: none;
        border-radius: 5px;
        border: 1px solid #DED6D6;
    }
</style>
<!-----start-main---->
<div class="main">
    <div class="login-form">
        <h1>后台登录</h1>
        <div class="head">
            <img src="images/user.png" alt=""/>
        </div>
        <form method="post" action="#" ><%--onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'USERNAME';}"--%>
            <input type="text" class="text" name="uname" id="username" placeholder="请输入用户名"  >
            <%--onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}"--%>
            <input type="password"  name="pwd" id="userpwd" placeholder="请输入密码" >
            <select name="utype" id="utype" >
                <option value="管理员">管理员</option>
                <option value="业务员">业务员</option>
                <option value="客户">客户</option>
            </select>
            <div style="color: #f00;" id="loginErro"></div>
            <div style="color: #24FF3F;" id="loginInfo"></div>

            <div class="submit" style="margin-top: 20px;">
                <input type="button" onclick="checkLogin()" value="登录" >
            </div>
            <%--<p><a href="doLossPwd.jsp" &lt;%&ndash;onclick="window.location.href='doLossPwd.jsp'"&ndash;%&gt;>忘记密码？</a></p>--%>
        </form>
    </div>
    <!--//End-login-form-->
    <!-----start-copyright---->
    <div class="copy-right">
        <p>  Copyright &copy; 客户回款系统</p>
    </div>
    <!-----//end-copyright---->
</div>
<!-----//end-main---->

<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='UTF-8'></script></div>
</body>
<script type="text/javascript">
    function checkLogin() {
        var uname = $("#username").val();
        var pwd = $("#userpwd").val();
        var utype = $("#utype").val();
        console.log("uname=1="+uname);
        console.log("pwd=1="+pwd);
        if (uname == "" || pwd == "") {
            $("#loginErro").html("用户名或者密码不能为空！");
            return false;
        } else {
            $.ajax({
                url : "alogin.do",
                type : "post",
                data : {
                    "uname" : uname,
                    "pwd" : pwd,
                    "utype" : utype,
                },
                dataType : "json",
                success : function(result) {
                    console.log("info=11="+result.info);
                    if (result.info == 'ng') {
                        $("#loginInfo").html("");
                        $("#loginErro").html("用户名、角色或者密码不正确，请重新输入！");
                        return false;
                    } else {
                        $("#loginErro").html("");
                        $("#loginInfo").html("登录成功！");
                        window.location.href='index2.jsp'
                        /* window.location.href='UserServlet?method=index' */
                        //$("#loginInfo").html("");
                        return true;
                    }
                },
                error : function() {
                    alert("服务器繁忙，请稍后再试！");
                }
            })
        }
    }
</script>
</html>


