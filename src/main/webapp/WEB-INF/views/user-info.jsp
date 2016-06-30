<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: asavitsky
  Date: 6/30/16
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Facebook Access App</title>
</head>
<body>
<h1>Facebook user details</h1>
<p>
    <b>User name:</b> <c:out value="${userName}"></c:out><br/>
    <b>User id:</b> <c:out value="${userId}"></c:out>
</p>
</body>
</html>
