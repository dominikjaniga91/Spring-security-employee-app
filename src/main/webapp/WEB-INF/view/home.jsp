<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Home page</title>
</head>
<body>
 Welcome on the home page

<a href="${pageContext.request.contextPath}/employee" >Login</a>
<a href="${pageContext.request.contextPath}/leaders" >Leaders</a>
<a href="${pageContext.request.contextPath}/settings" >Settings</a>

</body>
</html>
