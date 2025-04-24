<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>삭제</title>
</head>
<body>
    <h3>삭제 아이디 검색</h3>

    <c:if test="${not empty error}">
        <p>${error}</p>
    </c:if>

    <form action="memberSearch.do" method="post">
        <input type="text" name="id" placeholder="아이디">
        <input type="hidden" name="job" value="delete">
        <input type="submit" value="검색">
    </form>

    <c:choose>
        <c:when test="${not empty member}">
            <h3>회원 정보 삭제</h3>
            <form action="memberDelete.do" method="post">
                <p><input type="text" name="id" value="${member.id()}" readonly><p>
                <p><input type="text" name="password" value="${member.password()}" readonly><p>
                <p><input type="text" name="name" value="${member.name()}" readonly><p>
                <p><input type="text" name="email" value="${member.email()}" readonly><p>
                <p><input type="submit" value="삭제"><p>
            </form>
        </c:when>
        
        <c:when test="${not empty result}">
            <p>${result}</p>
        </c:when>
    </c:choose>
</body>
</html>
