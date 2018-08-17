<%--
  Created by IntelliJ IDEA.
  User: prati
  Date: 8/17/2018
  Time: 12:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="update" method="post">

        <label>Name</label>
        <input type="text" name="fName" value="hi"/>
        <label>Address</label>
        <input type="text" name ="address"  step="0.01" value="${student.address}" />
        <label>User Name</label>
        <input type="text" name="username" value="${student.userName}" />
        <label>Password</label>
        <input type="password" name="password" value="${student.password}" />
        <div align="center">

                <input type="submit"  value="Update" class="btn btn-lg btn-warning mt-3"/>

        </div>
    </form>
</body>
</html>
