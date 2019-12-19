<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/12/15
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/boc2013_index.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/boc2013_common.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/boc2013_reset.css" type="text/css" />
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/css/myIndex_chunk.css" type="text/css" />--%>
    <link source="widget" type="text/css" rel="stylesheet" href="//misc.360buyimg.com/user/reg/3.0.0/widget/??/common/common.css,/progress-bar/progress-bar.css,/reg-steps/reg-steps.css,/foreign-number-layer-170524/foreign-number-layer-170524.css,/footer/footer.css">
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="wrapper">
    <%@include file="accounthead.jsp"%>
    <div class="content">
        <div class="bn_img">
            <a href="" title="携百年匠心 览万物芳华—中国银行：中国国际进口博览会战略合作伙伴"><img src="https://pic.bankofchina.com/bocappd/ad/cnad2/201811/W020191105333150948244.jpg" width=980 height=200/></a>
        </div>
    </div>
    <div class="main">
        <!--com_box-->
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
    </div>
</div>
</body>
</html>
