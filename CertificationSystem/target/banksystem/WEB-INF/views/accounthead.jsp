<%@page pageEncoding="UTF-8" %>
<%--头部嵌套模板
top--%>
<script type="text/javascript" src="../images/boc2013_jquery-min.js"></script>
<div class="top clearfix">
    <div class="top_links">
        <a href="/index.html">简体中文</a>
        <a href="/big5/index.html">繁体中文</a>
        <a href="/en/index.html">English</a>
    </div>
    <div class="top_menu">
        <p class="p_2013" id="top_network">
            <a href="http://www.bankofchina.com/sourcedb/operations/">客服</a>
            <a href="${pageContext.request.contextPath}/logout">退出</a>
        </p>
    </div>
</div>
<!--header-->
<div class="header">
    <div class="header_area">
        <h1 class="logo">尊敬的${sessionScope.loginAccount.name}你好, 欢迎访问<a href="https://www.bankofchina.com/" title="中国银行"></a></h1>
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
            <li class="li_2013 current"><a href="${pageContext.request.contextPath}/account?method=index" class="current">首页</a></li>
            <li class="li_2013"><a name='PL_MENU_NAME' href="${pageContext.request.contextPath}/account?method=accountinfo">账户</a></li>
            <li class="li_2013"><a name='PL_MENU_NAME' href="${pageContext.request.contextPath}/account?method=deposit">存款</a></li>
            <li class="li_2013"><a name='PL_MENU_NAME' href="${pageContext.request.contextPath}/account?method=transfer">转账</a></li>
            <li class="li_2013"><a name='PL_MENU_NAME' href="${pageContext.request.contextPath}/account?method=detail">明细</a></li>
        </ul>
        <!--子菜单-->
    </div>
</div>