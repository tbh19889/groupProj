<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Page</title>
</head>

<body>
<h1>Registration Page</h1>
<h2>All Fields Required*</h2> 

<form  action= “registerServlet” method= “get”> 

<label> Email Address* </label><br/>
<input type="text" name="email" placeholder="Email" required><br/>

<label> Confirm Email Address* </label><br/>
<input type="text" name="email" placeholder="Confirm Email Address" required><br/>

<label> Password* </label><br/>
<input type="password" name="password" placeholder="Password" required><br/>

<label> First Name* </label><br/>
<input type="text" name="firstName" placeholder="First Name" required><br/>

<label> Last Name* </label><br/>
<input type="text" name="lastName" placeholder="Last Name" required><br/>
<br/>
<input type="submit"> <br/>

<button class="button2">Create Account</button>

</form>
</body>
</html>