<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>欢迎访问</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="//localhost:8080/Ecommerce/js/x509-1.1.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="//localhost:8080/Ecommerce/js/verify.js"></script>
    <script type="text/javascript" src="//localhost:8080/Ecommerce/js/asn1hex-1.1.js"></script>
    <script type="text/javascript" src="//localhost:8080/Ecommerce/js/base64x-1.1.js"></script>
    <script type="text/javascript" src="//localhost:8080/Ecommerce/js/base64.js"></script>
    <script type="text/javascript" src="//localhost:8080/Ecommerce/js/jsbn.js"></script>
    <script type="text/javascript" src="//localhost:8080/Ecommerce/js/jsrsasign.js"></script>
    <link href="//misc.360buyimg.com/mtd/pc/index_2019/1.0.0/static/css/first-screen.chunk.css" rel="stylesheet"/>
    <link href="//misc.360buyimg.com/mtd/pc/index_2019/1.0.0/static/css/index.chunk.css" rel="stylesheet"/>
    <link href="//localhost:8080/Ecommerce/css/myIndex.chunk.css" rel="stylesheet"/>
</head>
<body>
<div class="mod_container">
    <div id="shortcut">
        <div class="w">
            <ul class="fr">
                <li class="fore1 dropdown" id="ttbar-login">
                    <a target="_blank" href="//localhost:8080/Ecommerce/login" class="link-login">你好，请登录</a>&nbsp;&nbsp;
                    <a href="//localhost:8080/Ecommerce/register" class="link-regist style-red">免费注册</a>
                </li>
                <li class="spacer"></li>
                <li class="fore2">
                    <div class="dt"><a target="_blank" href="">我的订单</a></div>
            </ul>
        </div>
    </div>
    <div id="header">
        <div class="w">
           <div id="logo" class="logo">
                <h1 class="logo_tit">
                    <a href="//localhost:8080/Ecommmerce/image/icon.jpg" class="mylogo_tit_lk" clstag="h|keycount|head|logo_01">京东</a>
                </h1>
                <h2 class="logo_subtit">京东,多快好省</h2>
                <div class="logo_extend" clstag="h|keycount|head|logo_02"></div>
            </div>
            <div id="search">
                <div class="search-m">
                    <div class="search_logo">
                        <a href="//www.jd.com" class="search_logo_lk" clstag="h|keycount|head|logo_01" tabindex="-1">京东，多快好省</a>
                    </div>

                    <div class="form" role="serachbox">
                        <ul id="shelper" class="search-helper" style="display: none"></ul>
                        <input clstag="h|keycount|head|search_c" type="text"
                               onkeydown="javascript:if(event.keyCode==13) search('key');" autocomplete="off" id="key"
                               accesskey="s"
                               class="text"
                               aria-label="搜索"/>
                        <button clstag="h|keycount|head|search_a" onclick="search('key');return false;" class="button" aria-label="搜索">
                            <i
                                    class="iconfont">&#xe60b;</i></button>
                    </div>

                    <div id="settleup" class="dropdown" clstag="h|keycount|head|cart_null">
                        <div class="cw-icon">
                            <i class="iconfont">&#xe60c;</i>
                            <a target="_blank" href="//cart.jd.com/cart.action">我的购物车</a>
                            <i class="ci-count" id="shopping-amount"></i>
                        </div>
                        <div class="dropdown-layer">
                            <div id="J_cart_pop">
                                <span class="loading"></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>