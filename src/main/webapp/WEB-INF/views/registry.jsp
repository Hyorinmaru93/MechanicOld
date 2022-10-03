<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Rejestracja</title>
    <style>
        .error {
            color: red
        }
        .div {
            background-color: blue;
        }
    </style>
</head>
<body>
<div>
    Already have an account? Go to <a href="<c:url value="/login"/>">login page</a>
</div>
<form:form method="post" modelAttribute="user">
    <div>
        <label id="name">Login:</label>
        <form:input path="username" id="username"/>
        <form:errors path="username" element="div" cssClass="error"/>
    </div>
    <div>
        <label id="password">Password:</label>
        <form:password path="password" id="password"/>
        <form:errors path="password" element="div" cssClass="error"/>
    </div>
    <div>
        <button type="submit">Registry</button>
    </div>
</form:form>
<c:if test="${registered == true}">
    <div>
        <p style="color: green">Account created! Please sign in.</p>
    </div>
</c:if>
</body>
</html>