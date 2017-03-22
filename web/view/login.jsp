<%--
  Created by IntelliJ IDEA.
  User: Hanz
  Date: 2017/2/15
  Time: 下午4:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>登录页面</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style>
        input {margin: 10px;}
    </style>
</head>
<body>
    <div class="col-md-4 center"
         style="
            float: none;
            display: block;
            margin-left: auto;
            margin-right: auto;">
        <s:form action="user_login" method="post">
            <div class="form-group">
                <label>账号:</label>
                <input class="form-control" name="uid">
            </div>
            <div class="form-group">
                <label>密码:</label>
                <input type="password" class="form-control" name="pwd">
            </div>
            <div class="form-group">
                <input type="radio" name="role" value="CUSTOMER" checked>&nbsp;顾客&nbsp;
                <input type="radio" name="role" value="HOTEL">&nbsp;客栈&nbsp;
                <input type="radio" name="role" value="MANAGER">&nbsp;经理
            </div>
            <input class="btn btn-default col-md-4" type="submit" value="登录"/>
            <input class="btn btn-default col-md-4" onclick="window.location.href='/view/register.jsp'" value="注册"></button>
        </s:form>
    </div>
</body>
</html>
