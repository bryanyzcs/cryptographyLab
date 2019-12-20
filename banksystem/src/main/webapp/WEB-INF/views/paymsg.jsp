<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>用户登录</title>
    <link type="text/css" href="//g.alicdn.com/sd/ncpc/nc.css?t=2019111921" rel="stylesheet" />
    <link rel="stylesheet" href="https://g.alicdn.com/vip/login/0.5.65/css/new-loginV2.css?t=20151220" />
    <link rel="stylesheet" href="https://g.alicdn.com/vip/login/0.5.65/css/page.css?t=20151220" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/boc2013_columns.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/boc2013_common.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/boc2013_reset.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/myIndex_chunk.css" type="text/css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/orderpay.js"></script>
    <link source="widget" type="text/css" rel="stylesheet" href="//misc.360buyimg.com/user/reg/3.0.0/widget/??/common/common.css,/progress-bar/progress-bar.css,/reg-steps/reg-steps.css,/foreign-number-layer-170524/foreign-number-layer-170524.css,/footer/footer.css">
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style type="text/css">
        p {
            /**/line-height: 140%;
            /*margin: 20px;*/
            font-size: 120%;
        }
    </style>

</head>



</head>
<body>
<div class="wrapper">
   <%-- <%@include file="accounthead.jsp"%>--%>
    <div class="content">
        <div class="bn_img">
            <a href="" title="携百年匠心 览万物芳华—中国银行：中国国际进口博览会战略合作伙伴"><img src="https://pic.bankofchina.com/bocappd/ad/cnad2/201811/W020191105333150948244.jpg" width=980 height=200/></a>
        </div>
    </div>

    <div class="main">

        <div class="com_box clearfix">
            <p >
                <span style="color: #c9302c"> 订单信息</span>：${orderMsg}<br/>
                <span style="color: #c9302c">订单编号</span>：${orderNum}<br/>
                <span style="color: #c9302c">收款方</span>：宋的电子商务平台
            </p>

            <%--<table>
                <tbody>
                <tr>
                    <th scope="row">订单信息：</th>
                    <td>${sessionScope.transferRecord.transferNumber}huawei p30</td>
                </tr>
                <tr>
                    <th scope="row">订单编号：</th>
                    <td>${sessionScope.transferRecord.transferDate}9090909909</td>
                </tr>
                <tr>
                    <th scope="row">收款方：</th>
                    <td>${sessionScope.transferRecord.payAccount.name}电子商务平台</td>
                </tr>
            </table>--%>
            <br/>
            <div class="reg-form">
                <form action="" id="transfer-form" onsubmit="return false">
                    <div id="J_Message" style="display:none;" class="login-msg error">
                        <i class="iconfont">&#xe604;</i>
                        <p class="error"></p>
                    </div>
                    <div class="form-item">
                        <label>付款卡号</label>
                        <input type="text" id="form-payAccount" name="payAccount" class="myfield" placeholder="付款方银行卡号">
                    </div>
                    <div class="input-tip">
                        <span></span>
                    </div>
                    <div class="form-item">
                        <label>付款人姓名</label>
                        <input type="text"  id="form-name" name="payName" class="myfield">
                    </div>
                    <div class="input-tip">
                        <span></span>
                    </div>
                    <div class="form-item">
                        <label>支付密码</label>
                        <input type="password"  id="form-passwd" name="passwd" class="myfield">
                    </div>
                    <div class="input-tip">
                        <span></span>
                    </div>
                    <div>
                        <button class="btn-register" onclick="orderPay()">确认付款  ￥${totalMoney}</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>