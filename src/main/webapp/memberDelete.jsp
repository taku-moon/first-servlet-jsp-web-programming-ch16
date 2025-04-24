<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.ch16.vo.MemberVo" %>

<html>
<head>
    <title>삭제</title>
</head>
<body>
    <h3>삭제 정보 검색</h3>

    ${error}

    <form action="memberSearch.do" method="post">
        <input type="text" name="id" placeholder="아이디"><br>
        <input type="hidden" name="job" value="delete"><br>
        <input type="submit" value="검색">
    </form>

<%
    MemberVo member = (MemberVo) request.getAttribute("member");
    if (member != null) {
%>      <h3>검색 정보 결과</h3>
        <%= member.id() %> / <%= member.password() %> / <%= member.name() %> / <%= member.email() %>

        <form action="memberDelete.do" method="post">
            <input type="hidden" name="id" value="<%= member.id() %>"><br>
            <input type="submit" value="삭제">
        </form>
<%
    } else {
%>      ${result}
<%
    }
%>
</body>
</html>
