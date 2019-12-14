<%--<%@ page language="java" contentType="text/html; charset=UTF-8"--%>
<%--         pageEncoding="UTF-8"%>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>--%>
<%--<%--%>
<%--    String path = request.getContextPath();--%>
<%--    String basePath = request.getScheme() + "://"--%>
<%--            + request.getServerName() + ":" + request.getServerPort()--%>
<%--            + path + "/";--%>
<%--%>--%>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>用户登录</title>--%>
<%--    <base href="<%=basePath%>">--%>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
<%--</head>--%>
<%--<body>--%>
<%--<center>--%>
<%--    <h2>ZXXZ网上虚拟银行欢迎您！</h2>--%>
<%--    <form action="findUser" method="post">--%>
<%--        用户名:<input type="text" name="username"><br>--%>
<%--        密&emsp;码:<input type="password" name="password"><br>--%>
<%--        <input type="submit" value="确定"><br>--%>
<%--    </form>--%>
<%--    <a href="//localhost:8080/banksystem/register">新用户注册</a>--%>
<%--</center>--%>
<%--<h1>name : ${name}</h1>--%>
<%--<h3 style="color:red">${msg}</h3>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>用户登录</title>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="//localhost:8080/banksystem/js/loginn.js"></script>


</head>
<body>
<center>
    <h2>ZXXZ网上虚拟银行欢迎您！请登录</h2>


    <div>
        <div class="main">
        <div class="loginn-form">
<%--            <form action="register-form" method="GET">--%>
            <form action="" id="loginn-form" onsubmit="return false">
                <div class="form-item form-item-account", id="form-item-account">
                    <label>用户名</label>
                    <input type="text" id="form-account" name="userName" class="field" >
                    <i class="i-status"></i>
                    <i class="i-cancel"></i>
                </div>
                <div class="input-tip">
                    <span></span>
                </div>
                <div class="form-item">
                    <label>密&emsp;码</label>
                    <input  type="password" id="form-pwd" name="password" class="filed" >
                    <i class="i-status"></i>
                    <i class="i-cancel"></i>
                </div>
                <div class="input-tip">
                    <span></span>
                </div>

                <div>
                    <button  onclick="login()">确定</button>
                </div>
                <div class="input-tip">
                    <span></span>
                </div>
            </form>
                <a href="//localhost:8080/banksystem/register">注册新用户</a>
        </div>
        </div>
    </div>
</center>
</body>
</html>