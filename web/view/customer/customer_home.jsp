<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Hanz
  Date: 2017/3/7
  Time: 下午12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>顾客首页</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="col-md-8 center" style="float: none;
    display: block;
    margin-left: auto;
    margin-right: auto;">
    <div style="margin-top: 20px;
            margin-bottom: 20px;">
        <div class="col-md-4">
            欢迎使用, ${sessionScope.get("customer").getName()}
        </div>
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <s:form action="user_logout" method="POST">
                <input class="btn btn-default col-md-2" style="float:right;" type="submit" value="注销">
            </s:form>
        </div>
    </div>
    <br>
    <br>
    <ul class="nav nav-tabs" id="customerContent">
        <li class="active"><a href="#reserve" data-toggle="tab">预订</a></li>
        <li><a href="#check" data-toggle="tab">查看记录</a></li>
        <li><a href="#manage" data-toggle="tab">会员管理</a></li>
    </ul>

    <div id="myContent" class="tab-content">
        <div class="tab-pane fade in active" id="reserve">

            <%--可选计划--%>
            <h1>可预订</h1>
            <div>
                <s:form action="reserve" method="POST">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>酒店</th>
                            <th>开始时间</th>
                            <th>结束日期</th>
                            <th>房间号</th>
                            <th>价格</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <thead>
                        <s:iterator value="#request.plans" var="plan">
                            <tr>
                                <th><s:property value="#plan.hotelId"/></th>
                                <th><s:property value="#plan.startDay"/></th>
                                <th><s:property value="#plan.endDay"/></th>
                                <th><s:property value="#plan.room"/></th>
                                <th><s:property value="#plan.price"/></th>
                                <th><input type="checkbox" name="planReserved" value=${plan.id}></th>
                            </tr>
                        </s:iterator>
                        </thead>
                    </table>
                    <input class="btn btn-default pull-right" type="submit" value="预订">
                </s:form>
            </div>

            <h1>已预订</h1>
            <div>
                <s:form action="cancelReservation" method="POST">

                </s:form>
            </div>

        </div>

        <div class="tab-pane fade" id="check">

        </div>

        <div class="tab-pane fade" id="manage">
            <table>
                <thead>
                    <tr></tr>
                </thead>
                <tbody>
                    <tr></tr>
                </tbody>
            </table>
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
