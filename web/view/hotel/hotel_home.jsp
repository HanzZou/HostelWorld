<%--
  Created by IntelliJ IDEA.
  User: Hanz
  Date: 2017/3/7
  Time: 下午1:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>客栈首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/simple-sidebar.css"/>
</head>
<body>
<div id="wrapper">
    <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <li class="sidebar-brand"><a href="#">Hostel World</a></li>
            <li class="active"><a href="#registration">入/离店登记</a></li>
            <li><a href="#plan">计划发布</a></li>
            <li><a href="#statistical">查看统计</a></li>
            <li><a href="#information">修改信息</a></li>
            <li><a href="#analysis">分析</a></li>
        </ul>
    </div>
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div>
                        <div class="col-md-4">欢迎使用，${sessionScope.get("hotel").name}</div>
                        <div class="col-md-4"></div>
                        <div class="col-md-4">
                            <s:form action="user_logout" method="POST">
                                <input class="btn btn-default col-md-4" style="float:right;" type="submit" value="注销">
                            </s:form>
                        </div>
                        <br/>
                        <div id="myContent" class="tab-content">
                            <div class="tab-pane fade in active" id="registration">
                                <h1>入店登记</h1>
                                <s:form action="checkin" method="POST">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th>客人名</th>
                                            <th>房间号</th>
                                            <th>预订时间</th>
                                            <th>入住时间</th>
                                            <th>入住</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <s:iterator value="#request.reservations" var="reservation">
                                            <tr>
                                                <td><s:property value="#reservation.hotelName"/></td>
                                                <td><s:property value="#reservation.room"/></td>
                                                <td><s:property value="#reservation.time"/></td>
                                                <td><s:property value="#reservation.startDay"/></td>
                                                <td><input type="checkbox" name="checkinList" value=${reservation.id}></td>
                                            </tr>
                                        </s:iterator>
                                        </tbody>
                                    </table>
                                    <input class="btn btn-default pull-right" type="submit" value="入住">
                                </s:form>
                                <br>
                                <h1>手动登记</h1>
                                <div>
                                    <s:form action="checkinByHand" method="POST">
                                        <div class="form-group col-md-6">
                                            <label>房间号:</label>
                                            <input class="form-control" name="room">
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label>入住人数:</label>
                                            <input class="form-control" name="pNum">
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label>人员名单:</label>
                                            <input class="form-control" name="names">
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label>付费:</label>
                                            <input class="form-control" name="price">
                                        </div>
                                        <input class="btn btn-default pull-right" type="submit" value="入住">
                                    </s:form>
                                </div>

                                <br>
                                <h1>离店登记</h1>
                                <div>
                                    <s:form action="checkout" method="POST">
                                        <table class="table">
                                            <thead>
                                            <tr>
                                                <th>客房号</th>
                                                <th>入住时间</th>
                                                <th>客人名</th>
                                                <th>退房</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <s:iterator value="#request.rooms" var="croom">
                                                <tr>
                                                    <td><s:property value="#croom.room" /></td>
                                                    <td><s:property value="#croom.date" /></td>
                                                    <td><s:property value="#croom.names" /></td>
                                                    <td><input type="checkbox" name="checkoutList" value=${croom.id}> </td>
                                                </tr>
                                            </s:iterator>
                                            </tbody>
                                        </table>
                                        <input class="btn btn-default pull-right" type="submit" value="退房">
                                    </s:form>
                                </div>
                            </div>

                            <div class="tab-pane fade" id="plan">
                                <s:form action="release_plan" method="POST">
                                    <div class="form-group col-md-6">
                                        <label>房间号:</label>
                                        <input class="form-control" name="room">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>开始日:</label>
                                        <input class="form-control" name="startDay">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>结束日:</label>
                                        <input class="form-control" name="endDay">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>价格:</label>
                                        <input class="form-control" name="price">
                                    </div>
                                    <input class="btn btn-default col-md-2" type="submit" value="创建计划"/>
                                </s:form>
                            </div>

                            <div class="tab-pane fade" id="statistical">
                                <h1>入住记录</h1>
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>入住时间</th>
                                        <th>离店时间</th>
                                        <th>顾客</th>
                                        <th>房间号</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <s:iterator value="#request.checkins" var="c">
                                        <tr>
                                            <td><s:property value="#c.date"/></td>
                                            <td><s:property value="#c.leaveDate"/> </td>
                                            <td><s:property value="#c.names"/> </td>
                                            <td><s:property value="#c.room"/> </td>
                                        </tr>
                                    </s:iterator>
                                    </tbody>
                                </table>

                                <h1>财务记录</h1>
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>时间</th>
                                        <th>客户ID</th>
                                        <th>金额</th>
                                        <th>结算情况</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <s:iterator value="#request.finance" var="record">
                                        <tr>
                                            <td><s:property value="#record.time"/></td>
                                            <td><s:property value="#record.memberId"/></td>
                                            <td><s:property value="#record.price"/></td>
                                            <td><s:if test="#record.isSettled=='0'.toString()">未结算</s:if><s:else>已结算</s:else></td>
                                        </tr>
                                    </s:iterator>
                                    </tbody>

                                </table>
                            </div>

                            <div class="tab-pane fade" id="information">
                                <s:form action="modify_hotel_info" method="post">
                                    <div class="form-group col-md-6">
                                        <label>客栈名:</label>
                                        <input class="form-control" name="name" value=${hotel.name}>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>客栈地址:</label>
                                        <input class="form-control" name="address" value=${hotel.address}>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>客栈联系号码:</label>
                                        <input class="form-control" name="telephone" value=${hotel.telephone}>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>银行卡号:</label>
                                        <input class="form-control" name="cardId" value=${hotel.cardId}>
                                    </div>
                                    <input class="btn btn-default col-md-2" type="submit" value="修改信息">
                                </s:form>
                            </div>

                            <div class="tab-pane fade" id="analysis">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/lib/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/lib/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/lib/echarts.min.js"></script>
<script>
    //        $(document).ready(function(){
    //            $(".nav-side a").click(function(){
    //                $(this).tab('show');
    //            });
    //        });
    $(document).ready(function(){
        $(".sidebar-nav a").click(function(){
            $(this).tab('show');
        });
    });
</script>
</body>
</html>
