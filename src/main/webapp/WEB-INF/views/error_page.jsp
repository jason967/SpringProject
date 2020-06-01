<%--
  Created by IntelliJ IDEA.
  User: choi
  Date: 2020-06-01
  Time: 오후 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error_page</title>
</head>
<body>
<h4><c:out value="${exception.getMessage()}"></c:out></h4>

<ul>
    <h2>hi</h2>
    <c:forEach items="${exception.getStackTrace()}" var ="stack">
        <li><c:out value="${stack}"></c:out> </li>
    </c:forEach>
</ul>

</body>
</html>
