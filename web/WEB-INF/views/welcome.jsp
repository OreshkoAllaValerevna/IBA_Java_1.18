<%--
  Created by IntelliJ IDEA.
  User: Alla
  Date: 03.03.2019
  Time: 14:59
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
            <li><a href="LoginServlet">Login</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="LogoutServlet">Logout</a></li>
        </ul>
    </div>
</nav>
<div class="container">
<h3>Welcome, ${name}</h3>
<div>
    <table border="2">
        <caption>Список вашей группы</caption>
        <tr>
        <th>Имя</th>
        <th>Телефон</th>
        <th>Почта</th>
        </tr>
        <c:forEach items="${group}" var="p">
            <tr>
                <td> ${p.name}</td>
                <td> ${p.phone}</td>
                <td> ${p.email}</td>
            </tr>
        </c:forEach>
    </table>
    <p><font color="red">${errorMessage}</font></p>
    <form method="POST" action="GroupServlet">
    <b>Новый:</b>
        <p> Введите имя <input name="nname" type="text" /></p>
        <p> Введите телефон <input name="nphone" type="text" /></p>
        <p> Введите email <input name="nemail" type="text" /></p>
        <input name="add" type="submit">
    </form>
    <p><jsp:useBean id="beanNow" class="java.util.Date" />
        <fmt:formatDate value="${beanNow}" var="s_now" pattern="yyyy.MMM.dd hh:mm:ss" />
        <c:out value="${s_now}" /></p>
</div>
<footer class="footer">
    <div class="container">
        <p>2019 Все права защищены</p>
    </div>
</footer>
<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
