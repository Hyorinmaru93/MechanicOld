<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Car Form</title>
</head>
<body>
<%@include file="header.jsp" %>
<form:form method="post" modelAttribute="car">
    Brand:
    <form:select path="brand">
        <form:options items="${brands}"/>
    </form:select>
    <form:errors path="brand"/>
    <br>
    Model:<form:input path="model" id="model"/>
    <form:errors path="brand"/>
    <br>
    Category:<form:input path="category" id="category"/>
    <form:errors path="brand"/>
    <br>
    Production Date:<form:input path="productionDate" id="productionDate"/>
    <form:errors path="brand"/>
    <br>
    Custom Name:<form:input path="customName" id="customName"/>
    <form:errors path="brand"/>
    <br>
    <input type="submit" value="Add">
</form:form>
</body>
</html>
