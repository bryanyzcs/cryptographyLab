<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>提示页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body class="body">

<div class="my-page-box">
    <i class="layui-icon"><img src="${pageContext.request.contextPath}/image/sucess.jpg" width=200 height=200/></i>

    <p class="text">成功</p>
    <div class="my-btn-box">
        <a class="layui-btn layui-btn-small" href="${returnURL}">${msg}</a>
      <%--  <a class="layui-btn layui-btn-danger layui-btn-small " href="javascript:;">返回上页</a>--%>
    </div>
</div>
</body>
</html>