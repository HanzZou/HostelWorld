<%--
  Created by IntelliJ IDEA.
  User: Hanz
  Date: 2017/3/14
  Time: 上午10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册成功</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="col-md-4"  style="
    float: none;
    display: block;
    margin-left: auto;
    margin-right: auto;">
        注册成功！
        <br>
        ${name},您的ID为${id}
        <input class="btn btn-default" onclick="window.location.href='/view/login.jsp'" value="返回登录">
    </div>
</body>
</html>
