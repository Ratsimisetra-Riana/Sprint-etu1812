<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    
    <%
        
            out.println(request.getAttribute("id"));
            out.println(request.getAttribute("nom"));
        
    %>
</body>
</html>