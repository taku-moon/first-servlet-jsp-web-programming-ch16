<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>생성</title>
</head>
<body>
    <h3>회원가입</h3>

    ${error}

    <form action="memberInsert.do" method="post">
        <input type="text" name="id" placeholder="아이디"><br>
        <input type="text" name="password" placeholder="비밀번호"><br>
        <input type="text" name="name" placeholder="이름"><br>
        <input type="text" name="email" placeholder="이메일"><br>
        <input type="submit" value="가입">
    </form>
</body>
</html>
