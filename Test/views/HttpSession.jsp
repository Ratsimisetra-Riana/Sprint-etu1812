<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
import="java.util.HashMap,java.util.ArrayList"
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
    
    <%-- RAHA TSY JSON
        HashMap<String,Object> httpsession = (HashMap<String,Object>) request.getAttribute("HttpSession");
        ArrayList<String> attributs = new ArrayList<String>(httpsession.keySet());
        out.println(attributs.size());
        int i = 0;
        for(i=0;i<attributs.size();i++){
            out.println("("+attributs.get(i)+","+httpsession.get(attributs.get(i))+")");
        }
    --%>
    <% 
        String httpsession = (String) request.getAttribute("data");
        out.println(httpsession);
    %>
</body>
</html>