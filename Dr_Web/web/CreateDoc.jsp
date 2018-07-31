<%@page import="moduls.Admins"%>
<!DOCTYPE html>
<% Admins ad=(Admins) session.getAttribute("logedin");
      if(ad==null){response.sendRedirect("./adminlog.html");}

%>
<html>
<head>
<title>CreateDoc</title>
<link rel="stylesheet" type="text/css" href="create.css">
</head>
<body>

<div>
<form method="post" action="./DocCr">
   <h1>Create Doctor</h1>
  <input id="user" type="text" name="user" placeholder="Username">
  <br>
  <input id="pass" type="password" name="pass" placeholder="Password">
  <br>
  <input id="name" type="text" name="name" placeholder="Name">
  <br>
  <input id="location" type="text" name="Location" placeholder="Location">
  <br>
  <input id="opens" type="text" name="opens" placeholder="Opens">
  <br>
  <input id="closes" type="text" name="closes" placeholder="Closes">
  <br>
  <input id="contact" type="text" name="contact" placeholder="Contact">
  <br>
  <input id="sub" type="submit" value="Create">
</form> 
</div>

</body>
</html>