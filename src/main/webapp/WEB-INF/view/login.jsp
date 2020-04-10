<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 10.04.2020
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>My custom login page</h3>
<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST" >
    <c:if test="${param.error != null}" >
        <i>Sorry! You entered invalid username or password</i><br>
    </c:if>
    <label>
        <input type="text" name="username" placeholder="login" />
    </label><br>
    <label>
        <input type="password" name="password" placeholder="password">
    </label><br>
    <input type="submit" value="Login" />
</form:form>

</body>
</html>
