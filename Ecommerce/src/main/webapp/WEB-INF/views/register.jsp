<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/11/10
  Time: 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人注册</title>
     <link type="text/css" rel="stylesheet" href="//misc.360buyimg.com/jdf/1.0.0/unit/??ui-base/1.0.0/ui-base.css">
    <link type="text/css" rel="stylesheet" href="//misc.360buyimg.com/user/reg/3.0.0/css/tinyscrollbar-170524.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="//localhost:8080/Ecommerce/js/reg.js"></script>
    <script type="text/javascript" src="//localhost:8080/Ecommerce/js/verify.js"></script>
    <script type="text/javascript" src="//localhost:8080/Ecommerce/js/jsencrypt.js"></script>
    <script type="text/javascript" src="//localhost:8080/Ecommerce/js/base.js"></script>
    <script type="text/javascript" src="//localhost:8080/Ecommerce/js/jsbn.js"></script>
    <link source="widget" type="text/css" rel="stylesheet" href="//misc.360buyimg.com/user/reg/3.0.0/widget/??/header/header.css,/common/common.css,/progress-bar/progress-bar.css,/reg-steps/reg-steps.css,/foreign-number-layer-170524/foreign-number-layer-170524.css,/footer/footer.css">
    <link href="//localhost:8080/Ecommerce/css/myIndex.chunk.css" rel="stylesheet"/>
</head>
<body>
<div class="header">
    <div class="logo-con w clearfix">
        <%--<a href="https://www.jd.com" class="logo ">--%>
        </a>
        <div class="logo-title">欢迎注册</div>

        <div class="have-account">已有账号？ <a href="//localhost:8080/Ecommerce/login">
            请登录&gt;
        </a>
        </div>
    </div>
</div>

<div>
    <div class="container w">
        <%--widget prograss-bar begin--%>
        <div class="progress-bar clearfix">
            <div class="pro-step cur-step ">
                <span class="step-index">1</span>
                <p class="step-desc">填写账号信息</p>
            </div>
            <div class="pro-line pro-line1 person-pro-line person-pro-line1"></div>
            <div class="pro-step pro-step2 person-pro-step2">
                <span class="step-index">2</span>
                <p class="step-desc">注册成功</p>
            </div>
        </div>
        <%--widget prograss-bar end--%>

        <%--widget reg-steps begin--%>
        <div class="main">
            <div class="reg-form">
                <%--<form action="register-form" method="GET">--%>
                <form action="" id="reg-form" onsubmit="return false">
                    <input id="slideScene" value="reg" type="hidden"></input>
                    <input id="slideProduct" value="embed" type="hidden"></input>
                    <input id="slideWidth" value="100%" type="hidden"></input>
                    <input id="slidePlaceHolder" value="" type="hidden"></input>
                    <input id="slideSuccessMsg" value="" type="hidden"></input>
                    <input id="rsaPwd", name="rsapwd" type="hidden">
                    <input id="pubkey" type="hidden" value="-----BEGIN PUBLIC KEY-----
MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCuXbbEYtjL8+BEoLGiB0Bha615
QjFQlY9vnMdgGuluXIrBqlbOdv9/cQEtjJVQuSgzno0wXYr6C7X2wTB13TDbvukt
Oq+LiEs29xWTy8ghkrdhvUhndUhIcEaGC3bopth0tntRunrH03yWWa+tePMgBve/
vLRNLr+uu8KuD82tnQIDAQAB
-----END PUBLIC KEY-----">
                    <input type="hidden" id="popupProtocol" value="1">
                    <div id="step1-wrap">
                        <div class="form-item form-item-account" id="form-item-account">
                            <label>用 户 名</label>
                            <input type="text" id="form-account" name="regName" class="myfield" autocomplete="off" maxlength="20" placeholder="您的账户名和登录名" default="<i class='i-def'></i>支持中文、英文、数字、“-”、“_”的组合，4-20个字符">
                            <i class="i-status"></i>
                            <i class="i-cancel"></i>
                        </div>
                        <div class="input-tip">
                            <span></span>
                        </div>
                        <div class="form-item">
                            <label>设 置 密 码</label>
                            <input autocomplete="off" type="password" id="form-pwd" class="myfield" maxlength="20" placeholder="建议使用两种或两种以上字符组合" default="<i class='i-def'></i>建议使用字母、数字和符号两种及以上的组合，8-20个字符">
                            <i class="i-status"></i>
                            <i class="i-cancel"></i>
                        </div>
                        <div class="input-tip">
                            <span></span>
                        </div>
                        <div class="form-item">
                            <label>确 认 密 码</label>
                            <input type="password" id="form-equalTopwd" class="myfield" placeholder="请再次输入密码" default="<i class='i-def'></i>请再次输入密码">
                            <i class="i-status"></i>
                            <i class="i-cancel"></i>
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
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
