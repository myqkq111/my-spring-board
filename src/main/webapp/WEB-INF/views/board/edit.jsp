<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

</head>
<body>
    <form action="/board/update" method="post">
        <input type="text" name="id" readonly value="${board.id}">
        <input type="text" name="title"  value="${board.title}">
        <input type="text" name="content" value="${board.content}">
        <input type="text" name="userId" value="${board.userId}">
        <input type="text" name="createAt" value="${board.createdAt}">
        <button type="submit">수정</button>
    </form>
    <form action="/board/list" method="get">
        <button type="submit">닫기</button>
    </form>
</body>
</html>