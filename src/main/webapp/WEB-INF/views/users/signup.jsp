<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

</head>
<body>
<form action="/users/signup" method="post">
    <label for="username">username</label>
    <input type="text" name="username" id="username">
    <label for="password">password</label>
    <input type="text" name="password" id="password">

    <button type="submit">회원가입</button>
</form>
<form action="/board/list" method="get">
    <button type="submit">닫기</button>
</form>
</body>
</html>