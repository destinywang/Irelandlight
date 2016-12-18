<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/12/6
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>插入</title>
</head>
<body>
<h1>我是插入测试页面</h1>
<form action="/InterMessage/insertMsg" method="post">
    fromId:<input type="text" name="fromId" /></br>
    toId: <input type="text" name="toId" /></br>
    content: <input type="text" name="content" /></br>
    type: <input type="text" name="type" /></br>
    <input type="submit" value="提交">
</form>
</body>
</html>
