<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forum</title>
    </head>
    <body>
        <h1>Welcome to My Forum</h1>
        <c:forEach items="${Genres}" var="genre">
            <a href="Forum/Topics/${genre.id}"><div style="border:1px solid red; margin: 5px; padding: 5px;"> ${genre.title}</div></a>
            </c:forEach>
    </body>
</html>
