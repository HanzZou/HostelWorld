<%@ page import="java.util.ArrayList" %>
<%@ page import="edu.nju.hostelworld.model.HotelReport" %>
<%--
  Created by IntelliJ IDEA.
  User: Hanz
  Date: 2017/3/7
  Time: 下午12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<HotelReport> goodHotels = (ArrayList<HotelReport>)request.getAttribute("goodHotels");
int num = goodHotels.size();
String[] names = new String[num];
int[] nums = new int[num];
double[] rates = new double[num];
double[] sums = new double[num];
for (int i =0; i < num; i++) {
    names[i] = goodHotels.get(i).getHotelName();
    nums[i] = goodHotels.get(i).getOrdernum();
    rates[i] = goodHotels.get(i).getRateavg();
    sums[i] = goodHotels.get(i).getMoneyavg();
}
%>
<html>
<head>
    <title>经理首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/simple-sidebar.css">
    <script src="${pageContext.request.contextPath}/js/lib/echarts.min.js"></script>
</head>
<body>
<div id="wrapper">
    <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <li class="sidebar-brand"><a href="#">Hostel World</a></li>
            <li class="active"><a href="#examination">审批</a></li>
            <li><a href="#settle">结算</a></li>
            <li><a href="#check">查看报表</a></li>
            <li><a href="#analysis">分析</a></li>
        </ul>
    </div>

    <div id="page-context-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div>
                        <%--<div class="col-md-4" style="display: block;">--%>
                            <%--欢迎使用, ${sessionScope.get("manager").getName()}--%>
                        <%--</div>--%>
                        <%--<div class="col-md-4"></div>--%>
                        <%--<div class="col-md-4">--%>
                            <%--<s:form action="user_logout" method="POST">--%>
                                <%--<input class="btn btn-default col-md-4" type="submit" value="注销">--%>
                            <%--</s:form>--%>
                        <%--</div>--%>

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

                            <div class="tab-pane fade" id="analysis">
                                <h3>优秀酒店</h3>
                                <div id="GoodHotels" style="width: 800px;height: 600px;"></div>
                                <script type="text/javascript">
                                    var colors = ['#5793f3', '#d14a61', '#675bba'];
                                    var app = echarts.init(document.getElementById("GoodHotels"));
                                    app.title = '优秀酒店';

                                    var names = new Array(
                                        <% out.print("\""+names[0]+"\"");
                                        for(int i=1;i<num;i++){
                                            out.print(",\""+names[i]+"\"");
                                        }
                                        %>
                                    );
                                    var sums = new Array(
                                        <% out.print(sums[0]);
                                        for(int i=1;i<num;i++){
                                            out.print(","+sums[i]);
                                        }
                                        %>
                                    );
                                    var rates = new Array(
                                        <% out.print(rates[0]);
                                        for(int i=1;i<num;i++){
                                            out.print(","+rates[i]);
                                        }
                                        %>
                                    );
                                    var nums = new Array(
                                        <% out.print(nums[0]);
                                        for(int i=1;i<num;i++){
                                            out.print(","+nums[i]);
                                        }
                                        %>
                                    );

                                    option = {
                                        color: colors,
                                        tooltip: {
                                            trigger: 'axis',
                                            axisPointer: {
                                                type: 'cross',
                                                crossStyle: {
                                                    color: '#999'
                                                }
                                            }
                                        },
                                        grid: {
                                            right: '20%'
                                        },
                                        toolbox: {
                                            feature: {
                                                dataView: {show: true, readOnly: false},
                                                magicType: {show: true, type: ['line', 'bar']},
                                                restore: {show: true},
                                                saveAsImage: {show: true}
                                            }
                                        },
                                        legend: {
                                            data:['平均消费','订单数','评分']
                                        },
                                        xAxis: [
                                            {
                                                type: 'category',
                                                data: names,
                                                axisTick: {
                                                    alignWithLabel: true
                                                },
                                                axisPointer: {
                                                    type: 'shadow'
                                                }
                                            }
                                        ],
                                        yAxis: [
                                            {
                                                type: 'value',
                                                name: '金额',
                                                min: 0,
                                                max: 1000,
                                                interval: 100,
                                                position: 'left',
                                                axisLine: {
                                                    lineStyle: {
                                                        color: colors[0]
                                                    }
                                                },
                                                axisLabel: {
                                                    formatter: '{value}￥'
                                                }
                                            },
                                            {
                                                type: 'value',
                                                name: '订单量',
                                                min: 0,
                                                max: 10,
                                                interval: 1,
                                                position: 'right',
                                                axisLine: {
                                                    lineStyle: {
                                                        color: colors[1]
                                                    }
                                                },
                                                axisLabel: {
                                                    formatter: '{value}'
                                                }
                                            },
                                            {
                                                type: 'value',
                                                name: '评分',
                                                min: 0,
                                                max: 5,
                                                interval: 0.5,
                                                position: 'right',
                                                offset: 80,
                                                axisLine: {
                                                    lineStyle: {
                                                        color: colors[2]
                                                    }
                                                },
                                                axisLabel: {
                                                    formatter: '{value}'
                                                }
                                            }
                                        ],
                                        series: [
                                            {
                                                name:'平均消费',
                                                type:'bar',
                                                data:sums
                                            },
                                            {
                                                name:'订单量',
                                                type:'bar',
                                                yAxisIndex: 1,
                                                data:nums
                                            },
                                            {
                                                name:'评分',
                                                type:'line',
                                                yAxisIndex: 2,
                                                data:rates
                                            }
                                        ]
                                    };
                                    app.setOption(option);
                                </script>

                                <h3>房间价格浮动</h3>
                                <div id="price" style="width: 800px;height: 600px;"></div>
                                <script type="text/javascript">
                                    var app = echarts.init(document.getElementById("price"));

                                    app.title("房间价格浮动");
                                    var option = {

                                    };
                                    app.setOption(option);
                                </script>
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
<script>
    $(document).ready(function(){
        $(".sidebar-nav a").click(function(){
            $(this).tab('show');
        });
    });
</script>
</body>
</html>
