<%@ page import="banksystem.dao.UserDao"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>ZXXZ</title>
</head>
<body>
<center>
    <h2>
        欢迎进入ZX网上虚拟银行！
    </h2>
    <br><br>
    <%
        /*WebApplicationContext wac = WebApplicationContextUtils
                .getWebApplicationContext(this.getServletContext());
        UserDao userDao = (UserDao) wac.getBean("userDaoImpl");
        String in=(String)request.getParameter("id");
        System.out.println(in);
        int num=Integer.parseInt(in);*/
    %>
   <%-- <%=userDao.findUserById(num)%><br />--%>
    <%-- 	<%=userDao.findUserById(2)%><br />
        <%=userDao.findUserById(3)%><br />
        <%=userDao.findUserById(4)%><br /> --%>
    <h3>成功进入</h3>

</center>
</body>
</html>