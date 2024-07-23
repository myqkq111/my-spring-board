<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

</head>
<body>
    <form action="/board/insert" method="post">
        <input type="text" name="title" placeholder="title">
        <input type="text" name="content" placeholder="content">
        <input type="text" value="${username}" disabled>
        <button type="submit">등록</button>
    </form>
    <form action="/board/list" method="get">
        <button type="submit">닫기</button>
    </form>
</body>
</html>