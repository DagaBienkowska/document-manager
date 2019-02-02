<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Frog's Lil' PDF Manager</title>
</head>
<body>
<h2>Registration</h2>
    <form:form method="post" modelAttribute="userForm">
        <spring:bind path="username">
            <form:input path="username" type="text" placeholder="Username" autofocus="true"></form:input>
            <form:errors path="username"></form:errors>
        </spring:bind>

        <spring:bind path="password">
            <form:input path="password" type="password" placeholder="Password"></form:input>
            <form:errors path="password"></form:errors>
        </spring:bind>

        <spring:bind path="name">
            <form:input path="name" type="text" placeholder="Name"></form:input>
            <form:errors path="name"></form:errors>
        </spring:bind>

        <spring:bind path="surname">
            <form:input path="surname" type="text" placeholder="Surname"></form:input>
            <form:errors path="surname"></form:errors>
        </spring:bind>

        <button type="submit">Submit</button>
    </form:form>
</body>
</html>
