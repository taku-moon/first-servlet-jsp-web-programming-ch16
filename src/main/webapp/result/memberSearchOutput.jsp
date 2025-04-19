<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>검색 결과</title>
</head>
<body>
    <h3>검색 결과</h3>
<%
    String result = (String) request.getAttribute("result");
    if (result != null) {
        out.print(result + "<br>");
    } else {
%>
        <h3>
            ${member.id} / ${member.password} / ${member.name} / ${member.email}
        </h3>
<%
    }
%>

    <%@ include file="home.jsp"%>
</body>
</html>
