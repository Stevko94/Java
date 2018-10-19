<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forum</title>
    </head>

    <body>
        <h1>Topics</h1>
        <c:forEach items="${topics}" var="topic">
            <a href="/Forum/${topic.id}"><div style="border:1px solid red; margin: 5px; padding: 5px;"> ${topic.title}</div></a>
        </c:forEach>
    </body>
</html>
