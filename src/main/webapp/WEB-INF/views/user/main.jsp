<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <style >
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>

<body>
<%@ include file="header.jsp" %>
<c:if test="${carList != null}">
    <table>
        <thead>
        <tr>
            <th>LP.</th>
            <th>Custom Name</th>
            <th>Brand</th>
            <th>Model</th>
            <th>Production Date</th>
            <th>Category</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
    <c:forEach items="${carList}" var="car" varStatus="loop">
        <tr>
            <td>${loop.index+1}</td>
            <td>${car.customName}</td>
            <td>${car.brand}</td>
            <td>${car.model}</td>
            <td>${car.productionDate}</td>
            <td>${car.category}</td>
            <td><a href="schedule.jsp">Schedule a service</a></td>
        </tr>
    </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>
