<%--
  Created by IntelliJ IDEA.
  User: Hanz
  Date: 2017/2/15
  Time: 下午4:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>登录页面</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body class="col-md-4 center">
<form action="user_login.action" method="post">
  <div class="form-group">
    <label>账号:</label>
    <input class="form-control" name="uid">
  </div>
  <div class="form-group">
    <label>密码:</label>
    <input type="password" class="form-control" name="pwd">
  </div>
  <div class="form-group">
    <input type="radio" name="role" value="CUSTOMER" checked>顾客&nbsp;
    <input type="radio" name="role" value="HOTEL">客栈&nbsp;
    <input type="radio" name="role" value="MANAGER">经理
  </div>
  <input class="btn btn-default" type="submit" value="登录">
</form>
</body>
</html>
