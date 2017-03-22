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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="col-md-8 center"  style="
    float: none;
    display: block;
    margin-left: auto;
    margin-right: auto;">
    <div>
        <div class="col-md-4">欢迎使用，${sessionScope.get("hotel").name}</div>
        <div class="col-md-4"></div>
        <div class="col-md-4 pull-right">
            <s:form action="user_logout" method="POST">
                <input class="btn btn-default" type="submit" value="注销">
            </s:form>
        </div>
    </div>
    <br/>
    <div>
        <ul class="nav nav-tabs" id="hotelContent">
            <li class="active"><a href="#registration" data-toggle="tab">入/离店登记</a></li>
            <li><a href="#plan" data-toggle="tab">计划发布</a></li>
            <li><a href="#statistical" data-toggle="tab">查看统计</a></li>
            <li><a href="#information" data-toggle="tab">修改信息</a></li>
        </ul>
    </div>
    <div id="myContent" class="tab-content">
        <div class="tab-pane fade in active" id="registration">
            <s:form>

            </s:form>
        </div>
        <div class="tab-pane fade" id="plan">
            <s:form action="release_plan" method="POST">
                <div class="form-group">
                    <label>房间号:</label>
                    <input class="form-control" name="room">
                </div>
                <div class="form-group">
                    <label>开始日:</label>
                    <input class="form-control" name="startDay">
                </div>
                <div class="form-group">
                    <label>结束日:</label>
                    <input class="form-control" name="endDay">
                </div>
                <div class="form-group">
                    <label>价格:</label>
                    <input class="form-control" name="price">
                </div>
                <input class="btn btn-default col-md-2" type="submit" value="创建计划"/>
            </s:form>
        </div>
        <div class="tab-pane fade" id="statistical">

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
