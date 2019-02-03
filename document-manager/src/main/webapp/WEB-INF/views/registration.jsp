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
            <div class="form-group ${status.error ? 'has error' : ''}">
            <form:input path="username" type="text" placeholder="Username" autofocus="true"></form:input>
            <form:errors path="username"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has error' : ''}">
            <form:input path="password" type="password" placeholder="Password"></form:input>
            <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="name">
            <div class="form-group ${status.error ? 'has error' : ''}">
            <form:input path="name" type="text" placeholder="Name"></form:input>
            <form:errors path="name"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="surname">
            <div class="form-group ${status.error ? 'has error' : ''}">
            <form:input path="surname" type="text" placeholder="Surname"></form:input>
            <form:errors path="surname"></form:errors>
            </div>
        </spring:bind>

        <button type="submit">Submit</button>
    </form:form>
</body>
</html>
