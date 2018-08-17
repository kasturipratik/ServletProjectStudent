<%--
  Created by IntelliJ IDEA.
  User: prati
  Date: 8/16/2018
  Time: 5:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Signup Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <%@include file="base.html" %>

    <div class="row ">

        <div class="col-sm-0 col-md-3">
        </div>
        <div class="col-sm-12 col-md-6">
            <c:set var="message" value="${message}" />
            <c:set var="student" value="${student}"/>

            <c:if test="${student != null}">
                <h2 class="text-center p-3 text-success">Update Student Form</h2>
                 <form action="update" method="post">
                      <input type="hidden" name="id" value="${student.id}" />
            </c:if>
            <c:if test="${student == null}">
                <h2 class="text-center p-3 text-success">Student Sign Up form</h2>
                <form action="Signup" method="post">
            </c:if>

                <label>Name</label>
                <input type="text" name="fName" class="form-control" placeholder="Full Name" value="${student.name}" required />
                <label>Address</label>
                <input type="text" name ="address"  step="0.01" class="form-control" placeholder="Address"  value="${student.address}" required  />
                <label>User Name</label>
                <input type="text" name="username" class="form-control" placeholder="Username"  value="${student.userName}" required/>
                <label>Password</label>
                <input type="password" name="password" class="form-control" placeholder="password" value="${student.password}" required/>
                <div align="center">
                    <c:if test="${student != null}">
                        <input type="submit"  value="Update" class="btn btn-lg btn-warning mt-3"/>
                    </c:if>
                    <c:if test="${student == null}">
                        <input type="submit"  value="Sign Up" class="btn btn-lg btn-warning mt-3"/>
                    </c:if>
                </div>

            </form>
             <h4 class="text-center text-warning"><c:out value="${message}"/></h4>
        </div>
        <div class="col-sm-0 col-md-3">
        </div>
    </div>

</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>