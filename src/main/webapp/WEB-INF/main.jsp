<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Web Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          type="text/css"/>
    <!-- script references -->
    <script type="application/javascript" async
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="generator" content="Bootply"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="styles.css" rel="stylesheet">
</head>

<body>

<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1 class="display-3">${user.username}</h1>
        <p class="lead">Welcome to this amazing application!!!<p>
        <form:form method="post" modelAttribute="user">

        <p>Name: <form:input path="username"/></p>

        <p>Password: <form:password path="password"/></p>

        <p>Email: <form:input path="email"/></p>

        <input type="submit" value="Add User"/>

        </form:form>

        <h3 class="text-info">List of Users:</h3>
        <c:if test="${not empty userMap}">
            <table class="table table-striped table-bordered">
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="user" items="${userMap}">
                    <tr>
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                        <td><button type="submit"><a href="/user/remove/${user.username}"/>Delete</button></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</div>

</body>
</html>
