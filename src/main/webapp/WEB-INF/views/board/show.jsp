<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: flex-start; /* 위쪽 정렬 */
            min-height: 100vh;
            background-color: #f0f8ff; /* 연한 파란색 배경 */
            overflow-y: auto; /* 세로 스크롤 허용 */
        }
        .container {
            width: 600px; /* 컨테이너 너비 조정 */
            padding: 20px;
            background-color: #ffffff; /* 흰색 배경 */
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1); /* 그림자 효과 */
        }
        h2 {
            color: #333;
        }
        input[type="text"], textarea, button {
            width: calc(100% - 18px); /* 폭 계산 */
            padding: 8px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 3px;
            font-size: 14px;
            box-sizing: border-box; /* 내부 여백 및 테두리 포함 */
        }
        input[type="text"][readonly] {
            background-color: #f0f0f0;
        }
        button {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
        .comment {
            margin-top: 10px;
            padding: 10px; /* 내부 여백 늘리기 */
            background-color: #f9f9f9;
            border: 1px solid #ddd;
            border-radius: 5px;
            overflow: hidden; /* 내용 넘침 처리 */
        }
        .comment .username {
            font-weight: bold; /* 사용자 이름 굵게 */
            color: #333; /* 사용자 이름 색상 */
            margin-bottom: 5px; /* 아래 여백 */
        }
        .comment .content {
            color: #666; /* 내용 색상 */
        }
        .comment-list {
            display: none; /* 초기에 숨김 */
        }
    </style>
    <script>
        window.onload = function() {
            document.querySelector('.comment-list').style.display = 'block';
        };
    </script>
</head>
<body>
<div class="container">
    아이디
    <input type="text" readonly value="${board.id}">
    제목
    <input type="text" readonly value="${board.title}">
    작성자
    <input type="text" readonly value="${board.username}">
    내용
    <textarea readonly>${board.content}</textarea>
    <h2>댓글</h2>
    <form action="/comment/add" method="post">
        <input type="hidden" value="${board.id}" name="boardId">
        <textarea name="content"></textarea>
        <button type="submit">댓글 입력</button>
    </form>
    <h2>댓글 목록</h2>
    <div class="comment-list">
        <c:forEach var="comment" items="${comments}">
            <div class="comment">
                <div class="username">${comment.username}</div>
                <div class="content">${comment.content}</div>
            </div>
        </c:forEach>
    </div>
    <form action="/board/list" method="get">
        <button type="submit">닫기</button>
    </form>
</div>
</body>
</html>