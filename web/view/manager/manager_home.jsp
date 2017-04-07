<%--
  Created by IntelliJ IDEA.
  User: Hanz
  Date: 2017/3/7
  Time: 下午12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>经理首页</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="col-md-8" style="float: none;
    display: block;
    margin-left: auto;
    margin-right: auto;">
    <div class="col-md-4">
    欢迎使用, ${sessionScope.get("manager").getName()}
    </div>
    <div class="col-md-4"></div>
    <div class="col-md-4">
    <s:form action="user_logout" method="POST">
        <input class="btn btn-default col-md-4" type="submit" value="注销">
    </s:form>
    </div>

    <br/>
    <ul class="nav nav-tabs" id="managerContent">
        <li class="active"><a href="#examination" data-toggle="tab">审批</a></li>
        <li><a href="#settle" data-toggle="tab">结算</a></li>
        <li><a href="#check" data-toggle="tab">查看报表</a></li>
    </ul>

    <div id="myContent" class="tab-content">
        <div class="tab-pane fade in active" id="examination">
            <s:form action="approve" method="POST">
            <h3>开店申请:</h3>
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
                            <td><s:property value="#hotel.id"/></td>
                            <td><s:property value="#hotel.name"/></td>
                            <td><s:property value="#hotel.address"/></td>
                            <td><s:property value="#hotel.telephone"/></td>
                            <td><s:property value="#hotel.cardId"/></td>
                            <td><input type="checkbox" name="hotelToOpenList" value=${hotel.id}></td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
            <br/>

            <h3>客栈信息修改:</h3>
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
                    <s:iterator value="#request.hotelInfo" var="info">
                        <tr>
                            <td><s:property value="#info.id"/></td>
                            <td><s:property value="#info.name"/></td>
                            <td><s:property value="#info.address"/></td>
                            <td><s:property value="#info.telephone"/></td>
                            <td><s:property value="#info.cardId"/></td>
                            <td><input type="checkbox" name="hotelInfoList" value=${info.id}></td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
            <br/>

            <h3>会员信息修改:</h3>
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
                    <s:iterator value="#request.customerInfo" var="info">
                        <tr>
                            <td><s:property value="#info.id"/></td>
                            <td><s:property value="#info.name"/></td>
                            <td><s:property value="#info.telephone"/></td>
                            <td><s:property value="#info.address"/></td>
                            <td><s:property value="#info.telephone"/></td>
                            <td><s:property value="#info.cardId"/></td>
                            <td><input type="checkbox" name="customerInfoList" value=${info.id}></td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
                <input class="btn btn-default pull-right" type="submit" value="批准">
            </s:form>
        </div>

        <div class="tab-pane fade" id="settle">
            <table class="table">
                <thead>
                <tr>
                    <th>时间</th>
                    <th>酒店编号</th>
                    <th>用户编号</th>
                    <th>金额</th>
                    <th>结算状态</th>
                </tr>
                </thead>
                <tbody>
                <s:iterator value="#request.finances" var="fi">
                    <tr>
                        <td><s:property value="#fi.time"/></td>
                        <td><s:property value="#fi.hotelId"/></td>
                        <td><s:property value="#fi.memberId"/></td>
                        <td><s:property value="#fi.price"/></td>
                        <td><s:if test="#fi.isSettled=='0'.toString()">未结算</s:if><s:else>已结算</s:else></td>
                    </tr>
                </s:iterator>
                </tbody>
            </table>
            <input class="btn btn-default pull-right" value="结算" onclick="window.location.href='settle'">
        </div>

        <div class="tab-pane fade" id="check">
            <h3>预订记录</h3>
            <div>
                <table class="table">
                    <thead>
                    <tr>
                        <th>预订时间</th>
                        <th>客栈ID</th>
                        <th>客户ID</th>
                        <th>入住时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <s:iterator value="#request.reservations" var="reservation">
                        <tr>
                            <td><s:property value="#reservation.time"/></td>
                            <td><s:property value="#reservation.planId"/></td>
                            <td><s:property value="#reservation.memberId"/></td>
                            <td><s:property value="#reservation.id"/></td>
                        </tr>
                    </s:iterator>
                    </tbody>
                </table>
            </div>

            <h3>入住记录</h3>
            <div>
                <table class="table">
                    <thead>
                    <tr>
                        <th>入住时间</th>
                        <th>酒店ID</th>
                        <th>顾客ID</th>
                        <th>房间号</th>
                        <th>已退房</th>
                    </tr>
                    </thead>
                    <tbody>
                    <s:iterator value="#request.checkinReport" var="c">
                        <tr>
                            <td><s:property value="#c.date"/></td>
                            <td><s:property value="#c.hotelId"/></td>
                            <td><s:property value="#c.member"/></td>
                            <td><s:property value="#c.room"/></td>
                            <td><s:if test="#c.checkout=='1'.toString()">已退房</s:if><s:else>未退房</s:else></td>
                        </tr>
                    </s:iterator>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
