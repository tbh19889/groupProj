<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log In</title>
</head>

<body>
<h1 align="center">Log In</h1>
<h4 align="center">Sign into your Kroger account</h4>


<form  action= "login" method = "post" align="center"> 

<label> Email Address* </label><br/>
<input type="text" name="email" placeholder ="Email" required><br/>

<label> Password* </label><br/>
<input type="password" name="password" placeholder="Password" required><br/><br/>
<input type="submit"> <br/>


${errorMessage}
</form>

</body>
</html>