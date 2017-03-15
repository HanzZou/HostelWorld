<%--
  Created by IntelliJ IDEA.
  User: Hanz
  Date: 2017/3/14
  Time: 上午9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body class="col-md-4 center">
    <s:form action="user_register" method="POST">
        <div class="form-group">
            <label>姓名:</label>
            <input class="form-control" name="name">
        </div>
        <div class="form-group">
            <label>密码:</label>
            <input type="password" class="form-control" name="password">
        </div>
        <div class="form-group">
            <label>手机号码:</label>
            <input class="form-control" name="telephone">
        </div>
        <div class="form-group">
            <label>地址:</label>
            <input class="form-control" name="address">
        </div>
        <div class="form-group">
            <label>银行卡号:</label>
            <input class="form-control" name="card_id">
        </div>
        <input class="btn btn-default col-md-4" type="submit" value="注册"/>
    </s:form>
</body>
</html>
