<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>검색</title>
</head>
<body>
    <h3>회원 정보 검색</h3>

    ${error}

    <form action="memberSearch.do" method="post">
        <input type="text" name="id" placeholder="아이디"><br>
        <input type="hidden" name="job" value="search"><br>
        <input type="submit" value="검색">
    </form>
</body>
</html>
