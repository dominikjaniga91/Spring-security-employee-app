<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Home page</title>
</head>
<body>
 Welcome on the settings page


<form:form action="${pageContext.request.contextPath}/logout ">
    <input type="submit" value="Logout">
</form:form>
</body>
</html>
