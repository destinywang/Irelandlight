<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/12/7
  Time: 6:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>聊天历史</title>
</head>
<body>
<c:forEach items="messageList" var="message">
    <tr>
        <td>${message}</td>
    </tr>
</c:forEach>
</body>
</html>
