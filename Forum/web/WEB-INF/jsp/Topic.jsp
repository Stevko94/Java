

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Topic</title>
    </head>
    <body>
        <h1>${topic.title}</h1>
        <p>${topic.description}</p>
        <h3>Comment</h3>
        <form action="./${topic.id}" method="post"><input  type="text" name="Comment" </form>
        <input id="sub" type="submit" value="Post">
    </body>
</html>