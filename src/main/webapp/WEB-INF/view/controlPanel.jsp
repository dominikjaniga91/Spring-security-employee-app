<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Home page</title>
</head>
<body>
 Welcome on the home page<br><br>
 User: <security:authentication property="principal.username" />
 Roles: <security:authentication property="principal.authorities" />
 Password: <security:authentication property="principal" />

    <security:authorize access="hasRole('EMPLOYEE')" >
        <a href="${pageContext.request.contextPath}/employee" >Employee</a><br><br>
    </security:authorize>
    <security:authorize access="hasRole('MANAGER')" >
        <a href="${pageContext.request.contextPath}/leaders" >Leaders</a><br><br>
    </security:authorize>
    <security:authorize access="hasRole('ADMIN')" >
        <a href="${pageContext.request.contextPath}/settings" >Settings</a><br><br>
    </security:authorize>

</body>
</html>
