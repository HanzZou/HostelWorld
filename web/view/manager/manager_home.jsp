<%--
  Created by IntelliJ IDEA.
  User: Hanz
  Date: 2017/3/7
  Time: 下午12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>经理首页</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body class="col-md-8 center">
    欢迎使用, ${sessionScope.get("managerName")}
    <br/>
    <s:form action="user_logout" method="POST">
        <input class="btn btn-default col-md-2" type="submit" value="注销">
    </s:form>

    <br/>
    <ul class="nav nav-tabs" id="managerContent">
        <li class="active"><a href="#examination" data-toggle="tab">审批</a></li>
        <li><a href="#settle" data-toggle="tab">结算</a></li>
        <li><a href="#check" data-toggle="tab">查看报表</a></li>
    </ul>
    <div id="myContent" class="tab-content">
        <div class="tab-pane fade in active" id="examination">
            开店申请:
            <table class="table">
                <thead>
                    <tr>
                        <th>编号</th>
                        <th>客栈名</th>
                        <th>客栈地址</th>
                        <th>客栈电话</th>
                        <th>银行卡号</th>
                        <th>批准</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="#request.hotelToOpen" var="hotel">
                        <tr>
                            <th><s:property value="#hotel.id"/></th>
                            <th><s:property value="#hotel.name"/></th>
                            <th><s:property value="#hotel.address"/></th>
                            <th><s:property value="#hotel.telephone"/></th>
                            <th><s:property value="#hotel.cardId"/></th>
                            <th></th>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
            <br/>
            客栈信息修改:
            <table class="table">
                <thead>
                    <tr>
                        <th>客栈编号</th>
                        <th>客栈名</th>
                        <th>客栈地址</th>
                        <th>客栈电话</th>
                        <th>银行卡号</th>
                        <th>批准</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="#request.hotelInfo" var="hotel">
                        <tr>
                            <th><s:property value="#hotel.id"/></th>
                            <th><s:property value="#hotel.name"/></th>
                            <th><s:property value="#hotel.address"/></th>
                            <th><s:property value="#hotel.telephone"/></th>
                            <th><s:property value="#hotel.cardId"/></th>
                            <th></th>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
            <br/>
            会员信息修改:
            <table class="table">
                <thead>
                    <tr>
                        <th>编号</th>
                        <th>顾客姓名</th>
                        <th>手机号码</th>
                        <th>地址</th>
                        <th>手机号</th>
                        <th>银行卡号</th>
                        <th>批准</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="#request.customerInfo" var="customer">
                        <tr>
                            <th><s:property value="#customer.id"/></th>
                            <th><s:property value="#customer.name"/></th>
                            <th><s:property value="#customer.telephone"/></th>
                            <th><s:property value="#customer.address"/></th>
                            <th><s:property value="#customer.telephone"/></th>
                            <th><s:property value="#customer.cardId"/></th>
                            <th></th>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
