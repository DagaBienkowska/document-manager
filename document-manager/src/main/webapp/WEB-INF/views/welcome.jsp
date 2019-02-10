<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Frog's Lil' PDF Manager</title>
</head>
<body>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="post" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a> </h2>
    </c:if>

    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Created by</th>
            <th>Creation Date</th>
            <th>Last Modification</th>
            <th></th>
        </tr>
        <c:forEach items="${documentList}" var="document">
            <tr>
                <td>${document.docId}</td>
                <td>${document.fileName}</td>
                <td>${document.description}</td>
                <td>${document.creator.username}</td>
                <td>${document.creationDate}</td>
                <td>${document.modificationDate}</td>
                <td>


                    <form id="showDocument" method="post" action="${contextPath}/showDocument">
                        <input type="hidden" name="docName" value="${document.fileName}">
                        <a href="/showDocument">
                        <button type="submit">Show</button></a>
                    </form>

                </td>
            </tr>
        </c:forEach>

    </table>

    <ul>
        <li><a href="${contextPath}/addDocument">Add new file</a></li>
        <li>Show Your files</li>
        <li><a href="${contextPath}/allUsers">Show all users</a></li>
    </ul>
</body>
</html>
