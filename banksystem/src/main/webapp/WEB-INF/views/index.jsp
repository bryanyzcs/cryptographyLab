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
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>



</head>
<body>
    <div class="wrapper">
        <!-- 头部嵌套模板 -->
        <!--top-->
        <script type="text/javascript" src="../images/boc2013_jquery-min.js"></script>
        <div class="top clearfix">
            <div class="top_links">
                <a href="/index.html">简体中文</a>
                <a href="/big5/index.html">繁体中文</a>
                <a href="/en/index.html">English</a>
            </div>
            <div class="top_menu">
                <p class="p_2013" id="top_service">
                    <a href="../custserv/cs1/201312/t20131230_2805579.html">全球服务</a>
                </p>
                <p class="p_2013" id="top_network">
                    <a href="http://www.bankofchina.com/sourcedb/operations/">网点</a>
                    /<a href="http://www.bankofchina.com/sourcedb/atmdist/">ATM分布</a>
                </p>
            </div>
        </div>
    <!--header-->
    <div class="header">
        <div class="header_area">
            <h1 class="logo"><a href="https://www.bankofchina.com/" title="中国银行"></a></h1>
            <div class="header_info">
                <p class="phone">服务热线：<span>95566</span>信用卡热线：<span>40066 95566</span></p>
                <form name="trssearchform" id="trssearchform" action="https://srh.bankofchina.com/search/sitesearch/index.jsp" method="post" target="_blank">
                    <input type="hidden" name="searchColumn" value="all" />
                    <div class="search_bar">
                        <input type="text" class="search_ipt" id="sword" name="sword" value="请输入检索关键词" onfocus="if(this.value=='请输入检索关键词') this.value='';" onblur="if(this.value == '') this.value='请输入检索关键词';" />
                        <input type="button" class="search_btn" onclick="document.trssearchform.submit();" />
                    </div>
                </form>
            </div>
        </div>
        <!--导航-->
        <div class="nav_2013">
            <ul class="menu" id='BOC_NAVIGATOR_UL'>
                <li class="li_2013 current"><a href="/index.html" class="current">首页</a></li>
                <li class="li_2013"><a name='PL_MENU_NAME' href="../cbservice/">个人金融</a></li>
                <li class="li_2013"><a name='PL_MENU_NAME' href="../bcservice/" >银行卡</a></li>
                <li class="li_2013"><a name='PL_MENU_NAME' href="../aboutboc/" >关于中行</a></li>
            </ul>
            <!--子菜单-->
        </div>
    </div>
    <div class="main">
        <div class="content">
            <a href="" title="携百年匠心 览万物芳华—中国银行：中国国际进口博览会战略合作伙伴"><img src="https://pic.bankofchina.com/bocappd/ad/cnad2/201811/W020191105333150948244.jpg" width=716 height=200/></a>
        </div>

        <!--content--end-->
        <div class="slider">
            <div class="box loginBox clearfix">
                  <h3 class="title">网上银行</h3>
                    <ul>
                        <!-- 网上银行嵌套嵌套 -->
                        <li><a href="${pageContext.request.contextPath}/login" title="个人客户网银登陆">个人客户网银登录</a></li>
                        <li style="margin:0;"><a href="/ebanking/bocnet_login/index2.html" title="企业客户网银登陆">企业客户网银登录</a></li>
                        <!-- 网上银行嵌套嵌套 -->
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>