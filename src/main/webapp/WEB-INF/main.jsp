<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Login Form</title>
    <meta name="generator" content="Bootply"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="styles.css" rel="stylesheet">
</head>

<body>
<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1 class="display-3">${username}</h1>
        <p class="lead">Welcome to this amazing application!!!<p>
        <h3 class="text-info">List of Users:</h3>
        <c:if test="${not empty users}">

            <table class="table table-striped table-bordered">
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                </tr>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                        <td><button type="submit"><a href="/user/remove/"/>Delete</button> </td>
                    </tr>
                </c:forEach>

            </table>

        </c:if>
    </div>
</div>

</body>
</html>
