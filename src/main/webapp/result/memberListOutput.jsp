<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="com.example.ch16.vo.MemberVo" %>

<html>
<head>
    <title>전체 조회</title>
</head>
<body>
<%
    List<MemberVo> members = (List<MemberVo>) request.getAttribute("members");
    if (!members.isEmpty()) {
%>
    <table border="1">
        <tr>
            <th>아이디</th>
            <th>비밀번호</th>
            <th>이름</th>
            <th>이메일</th>
        </tr>
        <%
            for (int i = 0; i < members.size(); i++) {
                MemberVo member = members.get(i); %>
                <tr>
                    <td><%=member.getId()%></td>
                    <td><%=member.getPassword()%></td>
                    <td><%=member.getName()%></td>
                    <td><%=member.getEmail()%></td>
                </tr>
<%
            }
    } else {
        out.print("<h3>등록된 회원정보가 없습니다.</ㅗ3>");
    }
%>
    </table>

    <%@ include file="home.jsp"%>
</body>
</html>
