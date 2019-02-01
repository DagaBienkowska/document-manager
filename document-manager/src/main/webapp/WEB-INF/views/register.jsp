<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Frog's Lil' PDF Manager</title>
</head>
<body>
<h2>Registration</h2>
    <form:form action="/register" method="post" modelAttribute="User">
        Username
        <form:input path="username"></form:input><br>
        <form:input path="password"></form:input><br>
        <form:input path="username"></form:input><br>
        <form:input path="username"></form:input><br>

    </form:form>
</body>
</html>
