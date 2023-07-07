<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
import="java.util.ArrayList"
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
    <p>hello</p>
    <%
        ArrayList<String> lst = (ArrayList<String>) request.getAttribute("lst");
    %>  
            <a href="/Sprint/getId?id=2&nom=Montoya"><%out.println(lst.get(0));%></a>
        
        
        
    
</body>
</html>