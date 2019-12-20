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
    <title>用户信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/boc2013_index.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/boc2013_common.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/boc2013_reset.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/myIndex_chunk.css" type="text/css" />
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
            <table id="table-1">
                <thead>
                <tr>
                    <th scope="col">卡片类型</th>
                    <th scope="col">卡号</th>
                    <th scope="col">余额</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${sessionScope.loginAccount.cardtype}</td>
                    <td>${sessionScope.loginAccount.cardid}</td>
                    <td>￥${sessionScope.loginAccount.balance}</td>
                </tr>
                </table>
        </div>

    </div>
</div>
</body>
</html>
