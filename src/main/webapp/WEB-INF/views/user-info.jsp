<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <div style="height: 200px; width: 200px;"><img src="http://graph.facebook.com/<c:out value="${user.id}"></c:out>/picture?type=large"></div><br/>
    <b>User name:</b> <c:out value="${user.name}"></c:out><br/>
    <b>User id:</b> <c:out value="${user.id}"></c:out><br/><br/>

    Permissions granted to app:<br/>
    <ul>
        <c:forEach var="permission" items="${permissions}">
            <c:if test="${permission.status == 'granted'}">
                <li><i>${permission.name}</i></li>
            </c:if>
        </c:forEach>
    </ul>
</p>
</body>
</html>
