<%--
  Created by IntelliJ IDEA.
  User: Alla
  Date: 03.03.2019
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><font color="red">${error}</font></p>
<form action="LoginServlet" method="post">
    Name : <input type="text" name="name"/><br/>
    Password : <input type="password" name="password">
    <input type="submit">
</form>
</body>
</html>
