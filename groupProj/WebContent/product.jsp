<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    		String table = (String) request.getAttribute("table");
    %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products</title>
</head>
<body>
<a href="readCart"><img src= "img-cart-empty.png" align="right" height="42" width="42"></a>

<h1 align="center">Available Products</h1> 





<%=table %>



</body>
</html>