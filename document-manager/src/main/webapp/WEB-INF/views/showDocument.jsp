<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
        <th>Created by</th>
        <th>Creation Date</th>
        <th>Last Modification</th>
        <th>Pdf file</th>
    </tr>

        <tr>
            <td>${document.docId}</td>
            <td>${document.fileName}</td>
            <td>${document.description}</td>
            <td>${document.creator.username}</td>
            <td>${document.creationDate}</td>
            <td>${document.modificationDate}</td>
        </tr>

</table>
</body>
</html>
