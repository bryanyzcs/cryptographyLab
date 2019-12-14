<%--
  Created by IntelliJ IDEA.
  User: 18800
  Date: 2019/11/11
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>用户注册</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<center>--%>
<%--    <h2>欢迎注册！</h2>--%>
<%--    <form action="commit" method="post">--%>
<%--        用户名:<input type="text" name="username"><br>--%>
<%--        密&emsp;码:<input type="password" name="password"><br>--%>
<%--        <input type="submit" value="确定"><br>--%>
<%--    </form>--%>
<%--    <a href="//localhost:8080/banksystem/home">返回登陆</a>--%>
<%--</center>--%>
<%--<h3 style="color:red">${msg}</h3>--%>
<%--</body>--%>
<%--</html>--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人注册</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="//localhost:8080/banksystem/js/reg.js"></script>
    <script type="text/javascript" src="//localhost:8080/banksystem/js/base.js"></script>

</head>
<body>
<center>
    <h2>欢迎注册！</h2>


<div>

        <div class="main">
            <div class="reg-form">
<%--                <form action="register-form" method="GET">--%>
                <form action="" id="reg-form" onsubmit="return false">
<%--                    <input id="slideScene" value="reg" type="hidden"></input>--%>
<%--                    <input id="slideProduct" value="embed" type="hidden"></input>--%>
<%--                    <input id="slideWidth" value="100%" type="hidden"></input>--%>
<%--                    <input id="slidePlaceHolder" value="" type="hidden"></input>--%>
<%--                    <input id="slideSuccessMsg" value="" type="hidden"></input>--%>

                   <%-- <input id="pubkey" type="hidden" value="-----BEGIN PUBLIC KEY-------%>
<%--MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCuXbbEYtjL8+BEoLGiB0Bha615--%>
<%--QjFQlY9vnMdgGuluXIrBqlbOdv9/cQEtjJVQuSgzno0wXYr6C7X2wTB13TDbvukt--%>
<%--Oq+LiEs29xWTy8ghkrdhvUhndUhIcEaGC3bopth0tntRunrH03yWWa+tePMgBve/--%>
<%--vLRNLr+uu8KuD82tnQIDAQAB--%>
<%-------END PUBLIC KEY-----">--%>
<%--                    <input type="hidden" id="popupProtocol" value="1">--%>
                        <div class="form-item form-item-account", id="form-item-account">
                            <label>&emsp;用户名</label>
                            <input type="text" id="form-account" name="regName" class="field" autocomplete="off" maxlength="20" placeholder="您的账户名和登录名" default="<i class='i-def'></i>支持中文、英文、数字、“-”、“_”的组合，4-20个字符">
                            <i class="i-status"></i>
                            <i class="i-cancel"></i>
                        </div>
                        <div class="input-tip">
                            <span></span>
                        </div>
                        <div class="form-item">
                            <label>设置密码</label>
                            <input autocomplete="off" type="password" id="form-pwd" name="pwd" class="field" maxlength="20" placeholder="建议使用两种或两种以上字符组合" default="<i class='i-def'></i>建议使用字母、数字和符号两种及以上的组合，8-20个字符">
                            <i class="i-status"></i>
                            <i class="i-cancel"></i>
                        </div>
                        <div class="input-tip">
                            <span></span>
                        </div>
                        <div class="form-item">
                            <label>确认密码</label>
                            <input type="password" id="form-equalTopwd" class="field" placeholder="请再次输入密码" >
<%--                            <i class="i-status"></i>--%>
<%--                            <i class="i-cancel"></i>--%>
                        </div>
                        <div class="input-tip">
                            <span></span>
                        </div>
                    <div>
                        <button class="btn-register" onclick="register()">立即注册</button>
                    </div>
                    <div class="input-tip">
                        <span></span>
                    </div>
                </form>
                    <a href="//localhost:8080/banksystem/home">返回登陆</a>
            </div>
        </div>
    </div>
</center>
</body>
</html>
