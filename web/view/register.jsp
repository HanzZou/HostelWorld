<%--suppress ALL --%>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body class="col-md-8 center">
<div style="float: none;
            display: block;
            margin-left: auto;
            margin-right: auto;
            margin-top: 120px;">
    <ul class="nav nav-tabs" id="myTab">
        <li class="active"><a href="#customer" data-toggle="tab">顾客注册</a></li>
        <li><a href="#hotel" data-toggle="tab">客栈注册</a></li>
    </ul>
    <div id="myTabContent" class="tab-content">
        <div class="tab-pane fade in active" id="customer">
            <s:form action="register_customer" method="POST">
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
        </div>
        <div class="tab-pane fade" id="hotel">
            <s:form action="register_hotel" method="POST">
                <div class="form-group">
                    <label>客栈名:</label>
                    <input class="form-control" name="name">
                </div>
                <div class="form-group">
                    <label>密码:</label>
                    <input type="password" class="form-control" name="password">
                </div>
                <div class="form-group">
                    <label>客栈地址:</label>
                    <input class="form-control" name="address">
                </div>
                <div class="form-group">
                    <label>客栈联系号码:</label>
                    <input class="form-control" name="telephone">
                </div>
                <div class="form-group">
                    <label>银行卡号:</label>
                    <input class="form-control" name="card_id">
                </div>
                <input class="btn btn-default col-md-4" type="submit" value="注册"/>
            </s:form>
        </div>
    </div>
    <script>
        $(document).ready(function(){
            $(".nav-tabs a").click(function(){
                $(this).tab('show');
            });
        });
    </script>
</div>
</body>
</html>
