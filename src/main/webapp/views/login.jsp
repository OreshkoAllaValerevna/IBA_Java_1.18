<%--
  Created by IntelliJ IDEA.
  User: Alla
  Date: 03.03.2019
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .footer {
            position: absolute;
            bottom: 0;
            left: 0;
            width: 100%;
            height: 60px;
            background-color: #f2f2f2;
            text-align: center;
        }
        .footer .container {
            width: auto;
            max-width: 680px;
            padding: 0 15px;
        }
        .container {
            margin-left: 100px;
        }
        .navbar {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<nav role="navigation" class="navbar navbar-default">
    <div class="">
        <img src ="https://www.kv.by/sites/default/files/user7743/logo_iba_group.jpg" width="50" height="50">
    </div>
    <div class="navbar-collapse">
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="${pageContext.servletContext.contextPath}/controller?command=login_page">Login</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="${pageContext.servletContext.contextPath}/controller?command=sign_out">Logout</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <br><p><font color="red">${errorMessage}</font></p>
    <p><font color="blue">${fullRegister}</font></p>
<form action="${pageContext.servletContext.contextPath}/controller?command=login" method="post">
    <br>
    <b>Name :</b> <input type="text" name="name"/><br><br>
    <b>Password :</b> <input type="password" name="password"><br><br>
    <input type="submit">
    <br><br>
    <div><a href="${pageContext.servletContext.contextPath}/controller?command=registration_page">Регистрация</a></div>
</form>
    <footer class="footer">
        <div class="container">
            <p>2019 Все права защищены</p>
        </div>
    </footer>
    <script src="webjars/jquery/3.3.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</div>
</body>
</html>
