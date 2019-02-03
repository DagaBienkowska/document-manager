<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Add new Document</h2>
    <form:form method="post" modelAttribute="documentForm">
        <spring:bind path="fileName">
            <div class="form-group ${status.error ? 'has error' : ''}">
                <form:input path="fileName" type="text" placeholder="file name"></form:input>
                <form:errors path="fileName"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="description">
            <div class="form-group ${status.error ? 'has error' : ''}">
                <form:input path="description" type="textarea" placeholder="Write a description"></form:input>
                <form:errors path="description"></form:errors>
            </div>
        </spring:bind>

        <button type="submit">Submit</button>
    </form:form>
</body>
</html>
