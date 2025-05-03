<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>검색</title>
</head>
<body>
    <h3>회원 정보 검색</h3>

    <c:if test="${not empty error}">
        <p>${error}</p>
    </c:if>

    <form action="memberSearch.do" method="post">
        <input type="text" name="id" placeholder="아이디">
        <input type="hidden" name="job" value="search">
        <input type="submit" value="검색">
    </form>
</body>
</html>
