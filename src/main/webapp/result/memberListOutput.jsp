<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>전체 조회 결과</title>
</head>
<body>
    <c:choose>
        <c:when test="${not empty members}">
            <table border="1">
                <tr>
                    <th>아이디</th><th>비밀번호</th><th>이름</th><th>이메일</th>
                </tr>
                <c:forEach var="member" items="${members}">
                    <tr>
                        <td>${member.id()}</td>
                        <td>${member.password()}</td>
                        <td>${member.name()}</td>
                        <td>${member.email()}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <h3>등록된 회원정보가 없습니다.</h3>
        </c:otherwise>
    </c:choose>

    <%@ include file="home.jsp" %>
</body>
</html>
