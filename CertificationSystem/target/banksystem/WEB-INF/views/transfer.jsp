<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>用户转账</title>
    <link type="text/css" href="//g.alicdn.com/sd/ncpc/nc.css?t=2019111921" rel="stylesheet" />
    <link rel="stylesheet" href="https://g.alicdn.com/vip/login/0.5.65/css/new-loginV2.css?t=20151220" />
    <link rel="stylesheet" href="https://g.alicdn.com/vip/login/0.5.65/css/page.css?t=20151220" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/boc2013_columns.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/boc2013_common.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/boc2013_reset.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/myIndex_chunk.css" type="text/css" />

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/transfer.js"></script>
    <link source="widget" type="text/css" rel="stylesheet" href="//misc.360buyimg.com/user/reg/3.0.0/widget/??/common/common.css,/progress-bar/progress-bar.css,/reg-steps/reg-steps.css,/foreign-number-layer-170524/foreign-number-layer-170524.css,/footer/footer.css">
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>



</head>
<body>
<div class="wrapper">
    <%@include file="accounthead.jsp"%>

    <div class="main">
        <div class="reg-form">
            <form action="" id="transfer-form" onsubmit="return false">
                <div id="J_Message" style="display:none;" class="login-msg error">
                    <i class="iconfont">&#xe604;</i>
                    <p class="error"></p>
                </div>
                <br/>
                <div class="form-item">
                    <label>付款账户</label>
                    <input type="text" id="form-payAccount" name="payAccount" class="myfield" placeholder="付款方银行卡号">
                </div>
                <div class="input-tip">
                    <span></span>
                </div>
                <div class="form-item">
                    <label>转账金额</label>
                    <input type="number" step="0.01" id="form-money" name="payMoney" class="myfield">
                </div>
                <div class="input-tip">
                    <span></span>
                </div>
                <div class="form-item">
                    <label>支付密码</label>
                    <input type="password"  id="form-passwd" name="payPasswd" class="myfield">
                </div>
                <div class="input-tip">
                    <span></span>
                </div>
                <HR style="border:3px dashed #5bc0de" width="100%" SIZE=3>
                <div class="input-tip">
                    <span></span>
                </div>
                <div class="form-item">
                    <label>收款方</label>
                    <input type="text" id="form-recvName" name="recvName" class="myfield" placeholder="收款方银行卡号">
                </div>
                <div class="input-tip">
                    <span></span>
                </div>
                <div class="form-item">
                    <label>收款账户</label>
                    <input type="text" id="form-recvAccount" name="recvAccount" class="myfield">
                </div>
                <div class="input-tip">
                    <span></span>
                </div>
                <div>
                    <button class="btn-register" onclick="transfer()">转账</button>
                </div>
            </form>
        </div>
    </div>
</div>
</div>
</body>
</html>