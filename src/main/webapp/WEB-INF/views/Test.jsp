
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/static/csstest.css" rel="stylesheet" type="text/css">
<html>
<%@include file="header.jsp"%>
<c:if test="${!loggedIn}">
    Cokolwiek3
</c:if>
<c:if test="${loggedIn}" >
    ${DBUser.username}
    Cokolwiek2
</c:if>
<p>Cokolwiek co powiedziałeś</p>
</body>
</html>
