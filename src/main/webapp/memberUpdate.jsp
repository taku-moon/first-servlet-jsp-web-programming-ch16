<%@ page import="com.example.ch16.vo.MemberVo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>수정</title>
</head>
<body>
    <h3>수정 정보 검색</h3>

    ${error}

    <form action="memberSearch.do" method="post">
        <input type="text" name="id" placeholder="아이디"><br>
        <input type="hidden" name="job" value="update"><br>
        <input type="submit" value="검색">
    </form>

<%
    MemberVo member = (MemberVo) request.getAttribute("member");
    if (member != null) {
%>      <h3>회원 정보 수정</h3>
        <form action="memberUpdate.do" method="post">
            <input type="text" name="id" value="${member.id}" readonly><br>
            <input type="text" name="password" value="${member.password}"><br>
            <input type="text" name="name" value="${member.name}"><br>
            <input type="text" name="email" value="${member.email}"><br>
            <input type="submit" value="수정">
        </form>
<%
    } else {
%>      ${result}
<%
    }
%>
</body>
</html>
