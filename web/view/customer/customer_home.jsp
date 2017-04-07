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
            <br>
            <s:if test="#session.customer.isBlocked=='1'.toString()">
                <div style="color: red;">您还不是会员</div>
            </s:if>
        </div>
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <s:form action="user_logout" method="POST">
                <input class="btn btn-default col-md-4" style="float:right;" type="submit" value="注销">
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
                        <tbody>
                        <s:iterator value="#request.plans" var="plan">
                            <tr>
                                <td><s:property value="#plan.hotelId"/></td>
                                <td><s:property value="#plan.startDay"/></td>
                                <td><s:property value="#plan.endDay"/></td>
                                <td><s:property value="#plan.room"/></td>
                                <td><s:property value="#plan.price"/></td>
                                <td><input type="checkbox" name="planReserved" value=${plan.id}></td>
                            </tr>
                        </s:iterator>
                        </tbody>
                    </table>
                    <input class="btn btn-default pull-right" type="submit" value="预订">
                </s:form>
            </div>
                <br>
            <h1>已预订</h1>
            <div>
                <s:form action="cancelReservation" method="POST">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>预订时间</th>
                            <th>酒店</th>
                            <th>房间号</th>
                            <th>入住时间</th>
                            <th>离开时间</th>
                            <th>取消预订</th>
                        </tr>
                        </thead>
                        <tbody>
                        <s:iterator value="#request.reservations" var="reservation">
                            <tr>
                                <td><s:property value="#reservation.time"/> </td>
                                <td><s:property value="#reservation.hotelName"/> </td>
                                <td><s:property value="#reservation.room"/> </td>
                                <td><s:property value="#reservation.startDay"/> </td>
                                <td><s:property value="#reservation.endDay"/> </td>
                                <td><input type="checkbox" name="cancelList" value="${reservation.id}"></td>
                            </tr>
                        </s:iterator>
                        </tbody>
                    </table>
                    <input class="btn btn-default pull-right" type="submit" value="取消"></input>
                </s:form>
            </div>

        </div>

        <div class="tab-pane fade" id="check">
            <h1>入住记录</h1>
            <table class="table">
                <thead>
                    <tr>
                        <th>客栈名</th>
                        <th>入住时间</th>
                        <th>离开时间</th>
                        <th>房间号</th>
                    </tr>
                </thead>
                <tbody>
                <s:iterator value="#request.checkinRecord" var="record">
                    <tr>
                        <td><s:property value="#record.hotelId"/></td>
                        <td><s:property value="#record.date"/></td>
                        <td><s:property value="#record.leaveDate"/></td>
                        <td><s:property value="#record.room"/></td>
                    </tr>
                </s:iterator>
                </tbody>
            </table>

            <h1>消费记录</h1>
            <table class="table">
                <thead>
                    <tr>
                        <th>时间</th>
                        <th>酒店名</th>
                        <th>金额</th>
                        <th>结算情况</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="#request.finance" var="record">
                        <tr>
                            <td><s:property value="#record.time"/></td>
                            <td><s:property value="#record.hotelId"/></td>
                            <td><s:property value="#record.price"/></td>
                            <td><s:if test="#record.isSettled=='0'.toString()">未结算</s:if><s:else>已结算</s:else></td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
        </div>

        <div class="tab-pane fade" id="manage">
            <div style="margin-bottom: 20px;">
                <s:form action="modify_customer_info" method="post">
                    <div class="form-group col-md-6">
                        <label>用户名:</label>
                        <input class="form-control" name="name" value=${customer.name}>
                    </div>
                    <div class="form-group col-md-6">
                        <label>地址:</label>
                        <input class="form-control" name="address" value=${customer.address}>
                    </div>
                    <div class="form-group col-md-6">
                        <label>联系号码:</label>
                        <input class="form-control" name="telephone" value=${customer.telephone}>
                    </div>
                    <div class="form-group col-md-6">
                        <label>银行卡号:</label>
                        <input class="form-control" name="cardId" value=${customer.cardId}>
                    </div>
                    <input class="btn btn-default col-md-2" type="submit" value="修改信息">
                </s:form>
            </div>
            <br>
            <div style="margin-top: 20px;">
                <input class="btn btn-default" value="缴纳会费" onclick="window.location.href='unlock'">
                <input class="btn btn-default" value="取消会员" onclick="window.location.href='cancelVIP'">
            </div>
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
