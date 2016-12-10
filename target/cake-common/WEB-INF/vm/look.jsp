<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.irelandlight.model.News" %>
<%--suppress JspDirectiveInspection --%>

<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Joyoung
  Date: 2016/12/6
  Time: 2:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/news/write.action" method="post">
    title:<input type="text" name="title"><br/>
    content:<input type="text" name="content"><br/>
    productorId:<input type="number " name="productorId"><br>
    <input type="submit" value="保存">
</form>
<c:forEach items="${list}" var="p">
标题：${p.title}
正文：${p.content}
    <a href="/news/delete.action?id=${p.id}">删除</a><br>
</c:forEach>
</body>
</html>
