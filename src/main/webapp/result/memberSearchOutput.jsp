<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>검색 결과</title>
</head>
<body>
    <c:choose>
        <c:when test="${not empty member}">
            <p>${member.id()} / ${member.password()} / ${member.name()} / ${member.email()}</p>
        </c:when>

        <c:when test="${not empty result}">
            <p>${result}</p>
        </c:when>
    </c:choose>

    <%@ include file="home.jsp"%>
</body>
</html>
