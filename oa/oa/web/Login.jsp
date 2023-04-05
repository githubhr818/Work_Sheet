<%--
  Created by IntelliJ IDEA.
  User: hairui
  Date: 2023/3/28
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <style>
        span{
            color : red;
            font-size : 12PX;
        }
    </style>
</head>
<body>
<script>
    window.onload = function(){

        var username = document.getElementById("username");
        var usernamespan = document.getElementById("usernamespan")
        username.onblur = function(){
            if(username.value.trim()){

            }else{
                usernamespan.innerText = "用户名不能为空！"
            }
        }
        username.onfocus = function(){
            usernamespan.innerText = ""
        }

        var password = document.getElementById("password");
        var passwordspan = document.getElementById("passwordspan")
        password.onblur = function(){
            if(password.value.trim()){

            }else{
                passwordspan.innerText = "密码不能为空！"
            }
        }
        password.onfocus = function(){
            passwordspan.innerText = "";
        }

        var login = document.getElementById("login")
        login.onclick = function(){
            username.focus();
            username.blur();

            password.focus();
            password.blur();

            if(usernamespan.innerText === passwordspan.innerText){
                document.getElementById("form").submit();
            }
        }

    }
</script>
<h1 align="center">欢迎登录</h1>
<hr>
<form action="/oa/dept/login" method="post" id="form">
<table align="center">
    <tr>
        <th>
            用户名：
        </th>
        <td><input type="text" name="username" id="username"/></td>
        <td><span id="usernamespan"></span></td>
    </tr>
    <tr>
        <th>密码：</th>
        <td><input type="password" name="userpwd" id="password"/></td>
        <td><span id="passwordspan"></span></td>
    </tr>
    <tr>
        <td colspan="2" align="center"><input type="button" value="Login" id="login"/></td>
    </tr>
</table>
</form>

</body>
</html>
