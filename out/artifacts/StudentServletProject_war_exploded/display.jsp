<%@ page import="java.util.ArrayList" %>
<%@ page import="com.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: prati
  Date: 8/16/2018
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Display</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<%--jstl configuration--%>

<h3 class="text-center warning">
    <c:set var="message" value="${message}" />
</h3>
<div>
    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Address</th>
            <th>User Name</th>
            <th>Password</th>
            <th>Actions</th>
        </tr>
        </thead>
        <c:forEach var="st" items="${studentList}">
        <tr>
            <td><c:out value="${st.id}" /></td>
            <td><c:out value="${st.name}" /></td>
            <td><c:out value="${st.address}" /></td>
            <td><c:out value="${st.userName}" /></td>
            <td><c:out value="${st.password}" /></td>
            <td>
                <a href="/edit?id=<c:out value='${st.id}' />">Edit</a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="/delete?id=<c:out value='${st.id}' />">Delete</a>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
