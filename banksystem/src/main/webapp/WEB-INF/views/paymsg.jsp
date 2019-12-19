<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>用户登录</title>
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

        <div class="com_box clearfix">
            <table>
                <tbody>
                <tr>
                    <th scope="row">转账单号：</th>
                    <td>${sessionScope.transferRecord.transferNumber}</td>
                </tr>
                <tr>
                    <th scope="row">转账时间：</th>
                    <td>${sessionScope.transferRecord.transferDate}</td>
                </tr>
                <tr>
                    <th scope="row">转账人姓名：</th>
                    <td>${sessionScope.transferRecord.payAccount.name}</td>
                </tr>
                <tr>
                    <th scope="row">转账人卡号：</th>
                    <td>${sessionScope.transferRecord.payAccount.cardid}</td>
                </tr>
                <tr>
                    <th scope="row">转账金额：</th>
                    <td>${sessionScope.transferRecord.transferMoney}</td>
                </tr>
                <tr>
                    <th scope="row">收款人姓名：</th>
                    <td>${sessionScope.transferRecord.recvAccount.name}</td>
                </tr>
                <tr>
                    <th scope="row">收款人卡号：</th>
                    <td>${sessionScope.transferRecord.recvAccount.cardid}</td>
                </tr>
            </table>

        </div>
        <div>
            <a href="${pageContext.request.contextPath}/transfer">
                <button class="btn-register" onclick="transfer()">确认转账</button>
            </a>

        </div>
        <div class="reg-form">
            <form action="" id="transfer-form" onsubmit="return false">
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