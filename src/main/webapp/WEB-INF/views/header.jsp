<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
        }

        li {
            float: left;
        }

        li a {
            display: block;
            padding: 8px;
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<ul>
    <sec:authorize var="loggedIn" access="isAuthenticated()"/>
    <li><a href="/about">About</a></li>
    <li><a href="/test2">Test </a></li>
    <sec:authorize access="hasRole('ADMIN')">
        <li><a href="/admin/main">Admin page</a></li>
    </sec:authorize>
    <c:if test="${!loggedIn}">
        <li><a href="/login">Login</a></li>
        <li><a href="/registry">Registry</a></li>
    </c:if>
    <c:if test="${loggedIn}">
        <li><a href="/user/main">User page</a></li>
        <li><a href="/user/settings">My account</a></li>
        <li><a href="/logout">Logout </a></li>
    </c:if>

</ul>
