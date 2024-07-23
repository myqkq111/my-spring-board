<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <style>
        .pagination {
            display: inline-block;
        }

        .pagination a {
            color: black;
            float: left;
            padding: 8px 16px;
            text-decoration: none;
            transition: background-color .3s;
            border: 1px solid #ddd;
            margin: 0 4px;
        }

        .pagination a.active {
            background-color: #4CAF50;
            color: white;
            border: 1px solid #4CAF50;
        }

        .pagination a:hover:not(.active) {background-color: #ddd;}
    </style>
</head>
<body>
    <form action="/board/filter" method="get">
        <select name="categori">
            <option value="제목">제목</option>
            <option value="작성자">작성자</option>
            <option value="제목+작성자">제목+작성자</option>
        </select>
        <input type="text" name="filter">
        <button type="submit">검색</button>
    </form>
    <table>
        <c:forEach var="board" items="${boards}">
            <tr>
                <td>${board.id}</td>
                <td><a href="/board/${board.id}">${board.title}</a></td>
                <td>${board.username}</td>
                <td>
                    <a href="/board/${board.id}/edit">Edit</a>
                    <form action="/board/${board.id}/delete" method="post" style="display:inline;">
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <form action="/board/add" method="get">
        <button type="submit">게시물 추가</button>
    </form>
    <form action="/users/signup" method="get">
        <button type="submit">회원가입</button>
    </form>
    <div class="pagination">
        <a href="#">&laquo;</a>
        <a href="/board/page/1" class="active">1</a>
        <a href="/board/page/2">2</a>
        <a href="/board/page/3">3</a>
        <a href="/board/page/4">4</a>
        <a href="/board/page/5">5</a>
        <a href="#">&raquo;</a>
    </div>
</body>
</html>