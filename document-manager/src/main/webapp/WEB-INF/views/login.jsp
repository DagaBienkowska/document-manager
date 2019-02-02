<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Frog's Lil' PDF Manager</title>
</head>
<body>
    <form method="post" action="${contextPath}/login">
        <span>${message}</span>
        <input name="username" type="text" placeholder="Username" autofocus="true" />
        <input name="password" type="password" placeholder="Password" />
        <span>${error}</span>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

        <button type="submit">Log In</button>

        <h3><a href="${contextPath}/registration">Create an account</a></h3>
    </form>
</body>
</html>
