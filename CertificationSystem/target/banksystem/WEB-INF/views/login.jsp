<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/11/9
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎登录</title>
    <link type="text/css" href="//g.alicdn.com/sd/ncpc/nc.css?t=2019111921" rel="stylesheet" />
    <link rel="stylesheet" href="https://g.alicdn.com/vip/login/0.5.65/css/new-loginV2.css?t=20151220" />
    <link rel="stylesheet" href="https://g.alicdn.com/vip/login/0.5.65/css/page.css?t=20151220" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/myIndex_chunk.css" type="text/css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/verify.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jsrsasign.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/log.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jsencrypt.js"></script>
</head>
<body body class="chl-reg" data-spm="1">
<div id="page" class="">

    <div id="header" class="clearfix" data-spm="1000340">
        <div class="logo">
            <h1>
                <%--<a href="//www.taobao.com" title="淘宝网">
                    <i class="iconfont tb-logo-cn">
                        &#xe60d;
                    </i>
                    <i class="iconfont tb-logo-url">
                        &#xe624;
                    </i>
                </a>--%>
            </h1>
        </div>
    </div>
    <div id="content">
        <div class="login-newbg" style="background-image: url(https://pic.bankofchina.com/bocappd/ad/cnad2/201811/W020191105333150948244.jpg);">
            <input type="hidden" id="J_adUrl" name="adUrl" value="">
            <input type="hidden" id="J_adImage" name="adImage" value="">
            <input type="hidden" id="J_adText" name="adText" value="">
            <input type="hidden" id="J_viewFd4PC" name="viewFd4PC" value="">
            <input type="hidden" id="J_viewFd4Mobile" name="viewFd4Mobile" value="">
        </div>
        <%--<div class="login-adlink">
            <a href="https://www.taobao.com/m" target="_blank" onclick="javascript:goldlog.record('/member.11.1','','','H46777383')"></a>
        </div>--%>


        <div class="content-layout">
            <div class="login-box-warp">
                <div class="login-box no-longlogin " id="J_LoginBox">
                    <div class="bd">
                        <!--标准登录框-->
                        <div class="static-form " id="J_StaticForm">
                            <div class="login-title">zx网银</div>
                            <%--<form action="/member/login.jhtml?redirectURL=https%3A%2F%2Fai.taobao.com%2Fsearch%2Findex.htm%3Fkey%3D%25E8%25BF%259E%25E8%25A1%25A3%25E8%25A3%2599%26pid%3Dmm_12238993_43806065_714972723%26gclid%3DCjwKCAiAws7uBRAkEiwAMlbZjuTPDRNE0L3FtlHIQhg12ACFatjGAIAHbuFnCyoQ-BdEgqsfHtIQThoCrMAQAvD_BwE"  method="post" id="J_Form">--%>
                            <form action="" id="J_Form" method="post" onsubmit="return false">
                                <div id="J_Message" style="display:none;" class="login-msg error">
                                    <i class="iconfont">&#xe604;</i>
                                    <p class="error"></p>
                                </div>
                                <!-- 手机号登录 -->
                                <div class="field ph-hide username-field ">
                                    <label for="TPL_username_1">
                                        <i class="iconfont" title="会员名">
                                            &#xe601;
                                        </i>
                                    </label>
                                    <span class="ph-label">银行卡号/用户名</span>
                                    <input type="text" name="cardId" id="TPL_username_1" class="mylogin-text J_UserName" value="" maxlength="32"/>
                                </div>
                                <div class="field pwd-field">
                                    <label id="password-label" for="TPL_password_1">
                                        <i class="icon iconfont" title="登录密码">&#xe600;</i>
                                    </label>
                                    <span id="J_StandardPwd">
                                        <input type="password" <%--name="TPL_password"--%> id="TPL_password_1" class="mylogin-text" maxlength="40" autocomplete="off"/>
                                    </span>
                                </div>

                                <!-- use new slide checkcode -->
                                <div id="nocaptcha" class="nc-container tb-login"></div>
                                <div class="submit">
                                    <input id="rsaPwd", name="rsapwd" type="hidden">
                                    <%--<input id="J_NcoSig" name="ncoSig" type="hidden" />
                                    <input id="J_NcoSessionid" name="ncoSessionid" type="hidden" />
                                    <input id="J_NcoToken" type="hidden" name="ncoToken" value="d07312112bbd333d54c71c995a50599a3a9b264c" />
                                    <input id="J_NcoShow" type="hidden" name="slideCodeShow" value="false" />
                                    <input type="hidden" name="useMobile" value="false"/>
                                    <input type="hidden" id="J_lang" name="lang" value="zh_CN"/>
                                    <input type="hidden" name="loginsite" value="0" id="J_loginsite" /> <input type="hidden" name="newlogin" value="" />
                                    <input type="hidden" id="J_TPL_redirect_url" name="TPL_redirect_url" value="https://ai.taobao.com/search/index.htm?key=%E8%BF%9E%E8%A1%A3%E8%A3%99&amp;pid=mm_12238993_43806065_714972723&amp;gclid=CjwKCAiAws7uBRAkEiwAMlbZjuTPDRNE0L3FtlHIQhg12ACFatjGAIAHbuFnCyoQ-BdEgqsfHtIQThoCrMAQAvD_BwE" />
                                    <input type="hidden" id="J_From" name="from" value="tbTop" />
                                    <input type="hidden" name="fc" value="default" />
                                    <input type="hidden" id="J_CssStyle" name="style" value="default" />
                                    <input type="hidden" id="J_CssStyle2" name="css_style" value="" />
                                    <input type="hidden" name="keyLogin" value="false" />
                                    <input type="hidden" name="qrLogin" value="true" />
                                    <input type="hidden" name="newMini" value="false" />
                                    <input type="hidden" name="newMini2" value="false" />
                                    <input type="hidden" name="tid" />
                                    <input type="hidden" name="loginType" value="3" />
                                    <input type="hidden" name="minititle" value="" />
                                    <input type="hidden" name="minipara" value="" />
                                    <input type="hidden" name="pstrong" value="" />
                                    <input type="hidden" id="J_sign" name="sign" value="" />
                                    <input type="hidden" id="J_need_sign" name="need_sign" value="" />
                                    <input type="hidden" id="J_isIgnore" name="isIgnore" value="" />
                                    <input type="hidden" id="J_full_redirect" name="full_redirect" value="" />
                                    <!-- 子账号跳转方式 -->
                                    <input type="hidden" name="sub_jump" value="" />
                                    <input type="hidden" name="popid" value="" />
                                    <input type="hidden" name="callback" value="" />
                                    <input type="hidden" id="J_guf" name="guf"value="" />
                                    <input type="hidden" id="J_not_duplite_str" name="not_duplite_str" value="" />
                                    <input type="hidden" name="need_user_id" value="" />
                                    <input type="hidden" name="poy" />
                                    <input type="hidden" id="gvfdc" name="gvfdcname" value="" />
                                    <input type="hidden" name="gvfdcre" value="" />
                                    <input type="hidden" id="J_from_encoding" name="from_encoding" value="" />
                                    <input type="hidden" id="J_sub" name="sub" value="" />
                                    <input type="hidden" name="TPL_password_2" id="TPL_password_2" />
                                    <input type="hidden" id="J_PBK" value="9a39c3fefeadf3d194850ef3a1d707dfa7bec0609a60bfcc7fe4ce2c615908b9599c8911e800aff684f804413324dc6d9f982f437e95ad60327d221a00a2575324263477e4f6a15e3b56a315e0434266e092b2dd5a496d109cb15875256c73a2f0237c5332de28388693c643c8764f137e28e8220437f05b7659f58c4df94685" />
                                    <input type="hidden" name="loginASR" value="1" />
                                    <input type="hidden" name="loginASRSuc" value="0" />
                                    <input type="hidden" id="J_allp" name="allp" value="" />
                                    <input type="hidden" name="oslanguage" />
                                    <input type="hidden" name="sr" />
                                    <input type="hidden" name="osVer" />
                                    <input type="hidden" name="naviVer" />
                                    <input type="hidden" name="osACN" />
                                    <input type="hidden" name="osAV" />
                                    <input type="hidden" name="osPF" />
                                    <input type="hidden" name="miserHardInfo" id="M_hard_info"/>
                                    <input type="hidden" id="J_Appkey" name="appkey" value="00000000" />
                                    <input type="hidden" name="nickLoginLink" value="" />
                                    <input type="hidden" name="mobileLoginLink" value="https://login.taobao.com/member/login.jhtml?spm=a231o.7712113/g.1997563269.1.771146089sTDZE&amp;prepvid=200_11.186.129.238_3539_1574170578385&amp;extra=&amp;f=top&amp;redirectURL=https://ai.taobao.com/search/index.htm?key=%E8%BF%9E%E8%A1%A3%E8%A3%99&amp;pid=mm_12238993_43806065_714972723&amp;gclid=CjwKCAiAws7uBRAkEiwAMlbZjuTPDRNE0L3FtlHIQhg12ACFatjGAIAHbuFnCyoQ-BdEgqsfHtIQThoCrMAQAvD_BwE&amp;pid=mm_12238993_43806065_714972723&amp;clk1=&amp;unid=&amp;source_id=&amp;app_pvid=200_11.186.129.238_3539_1574170578385&amp;useMobile=true" />
                                    <input type="hidden" name="showAssistantLink" value="" />
                                    <input id="J_UnitClose " value="true" type="hidden" />--%>
                                        <input id="pubkey" type="hidden" value="-----BEGIN PUBLIC KEY-----
MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCuXbbEYtjL8+BEoLGiB0Bha615
QjFQlY9vnMdgGuluXIrBqlbOdv9/cQEtjJVQuSgzno0wXYr6C7X2wTB13TDbvukt
Oq+LiEs29xWTy8ghkrdhvUhndUhIcEaGC3bopth0tntRunrH03yWWa+tePMgBve/
vLRNLr+uu8KuD82tnQIDAQAB
-----END PUBLIC KEY-----">
                                    <button class="J_Submit" id="J_SubmitStatic" data-ing="正在登录..." onclick="login()">登 录</button>
                                </div>
                                <div class="login-links">
                                    <a <%--href="https://passport.taobao.com/ac/password_find.htm?from_site=0&login_id=&lang=zh_CN&app_name=&tracelog=signin_main_pass"--%> tabindex="6" class="forget-pwd" target="_blank">
                                        找回用户名密码
                                    </a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!--标准登录框结束-->
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    TRLang = {
        ERROR_NICK_BLANK : '请填写账户名',
        ERROR_PASSWORD_BLANK :  '请输入密码',
        ERROR_NICK_PASSWORD_BLANK : '请输入账户名和密码',
        ERROR_CHECKCODE_BLANK : '请输入验证码',
        TIPS_REMEMBER_PASSWORD : '记住密码',
        TIPS_NOT_REMEMBER_PSW_ON_PUBLIC : '不要在公共计算机记住密码，防止账户被盗'
    };
</script>
</body>
</html>