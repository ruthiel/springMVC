<%--
  Created by IntelliJ IDEA.
  User: codecadet
  Date: 13/12/16
  Time: 09:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!--
* parallax_login.html
* @Author original @msurguy (tw) -> http://bootsnipp.com/snippets/featured/parallax-login-form
* @Tested on FF && CH
* @Reworked by @kaptenn_com (tw)
* @package PARALLAX LOGIN.
-->
<html>

<head>
    <title>Login Form</title>
    <link rel="stylesheet" type="text/css" href="../styles.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          type="text/css"/>
    <!-- script references -->
    <script type="application/javascript" async
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="generator" content="Bootply"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
</head>

<body>
<div class="login">
    <h1>Login</h1>
    <form:form method="post" modelAttribute="user">
        <form:input type="text" name="username" placeholder="Username" required="required" path="username"/>
        <form:errors path="username" cssClass="error"/>
        <form:input type="password" name="password" placeholder="Password" required="required" path="password"/>
        <button type="submit" class="btn btn-primary btn-block btn-large">Let me in.</button>
    </form:form>
    <br>
    <div style="color:red">${error}</div>
    -
    <script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
    <!-- login bootsnipp -->
    <ins class="adsbygoogle"
         style="display:block"
         data-ad-client="ca-pub-9155049400353686"
         data-ad-slot="9589048256"
         data-ad-format="auto"></ins>
    <script>
        (adsbygoogle = window.adsbygoogle || []).push({});
    </script>
</div>
</body>

</html>




