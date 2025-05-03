<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>생성</title>
</head>
<body>
    <h3>회원 정보 생성</h3>

    <c:if test="${not empty error}">
        <p>${error}</p>
    </c:if>

    <form action="memberInsert.do" method="post">
        <p><input type="text" name="id" placeholder="아이디"></p>
        <p><input type="text" name="password" placeholder="비밀번호"></p>
        <p><input type="text" name="name" placeholder="이름"></p>
        <p><input type="text" name="email" placeholder="이메일"></p>
        <p><input type="submit" value="가입"></p>
    </form>
</body>
</html>
