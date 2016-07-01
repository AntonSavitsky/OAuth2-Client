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
<h1>
    Facebook user details
    <div style="position:absolute;top:0;right:0; margin: 0.3em;">
        <a target="_blank" title="find us on Facebook" href="http://www.facebook.com/628891600595274">
            <img alt="find us on facebook" src="//login.create.net/images/icons/user/facebook-b_130x50.png" border=0>
        </a>
    </div>
</h1>

<p>
    <div style="height: 200px; width: 200px;"><img src="http://graph.facebook.com/<c:out value="${userId}"></c:out>/picture?type=large"></div><br/>
    <b>User name:</b> <c:out value="${userName}"></c:out><br/>
    <b>User id:</b> <c:out value="${userId}"></c:out>

</p>
</body>
</html>
