<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello from SimpleFacebookClient Application
	<div style="position:absolute;top:0;right:0; margin: 0.3em;">
		<a target="_blank" title="find us on Facebook" href="http://www.facebook.com/628891600595274">
			<img alt="find us on facebook" src="//login.create.net/images/icons/user/facebook-b_130x50.png" border=0>
		</a>
	</div>
</h1>

<p>
	<a href="<c:url value="/user"/>">Login to facebook</a>
</p>

</body>
</html>
