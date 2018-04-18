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

<form  action= “register” method = "post"> 

<label> First Name* </label><br/>
<input type="text" name="firstName" placeholder="First Name" required><br/>

<label> Last Name* </label><br/>
<input type="text" name="lastName" placeholder="Last Name" required><br/>

<label> Phone Number* </label><br/>
<input type="text" name="phoneNum" placeholder="Phone Number" required><br/>

<label> Email Address* </label><br/>
<input type="text" name="email" placeholder="Email" required><br/>

<label> Address* </label><br/>
<input type="text" name="address" placeholder="Address" required><br/>

<label> Payment Type* </label><br/>
<input type="text" name="paymentInfo" placeholder="Payment Type" required><br/>

<label> UserName* </label><br/>
<input type="text" name="username" placeholder="UserName" required><br/>

<label> Password* </label><br/>
<input type="password" name="password" placeholder="Password" required><br/>

<br/>
<input type="submit"> <br/>


</form>
</body>
</html>