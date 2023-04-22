<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>북마크 그룹 관리</title>
    <link rel="stylesheet" href="CSS/style.css">
    <script src = "JS/main.js"></script>
</head>
<body onload="fillDefault()">
    <h1>북마크 그룹 수정</h1>
    <p>
        <a href="index.jsp">홈</a>
        <span>|</span>
        <a href="/history.jsp">위치 히스토리 목록</a>
        <span>|</span>
        <a href="/load-wifi-data">Open API 와이파이 정보 가져오기</a>
        <span>|</span>
        <a href="bookmark-list.jsp">즐겨 찾기 보기</a>
        <span>|</span>
        <a href="bookmark-group.jsp">즐겨 찾기 그룹 관리</a>
    </p>
    <table>
        <tr>
            <td class = "standard">북마크 이름</td>
            <td><input type = "TEXT"></td>
        </tr>
        <tr>
            <td class = "standard">순서</td>
            <td><input type = "number"></td>
        </tr>
        <tr>
            <td colspan="2" style = "text-align: center;"><a href ="bookmark-group.jsp">돌아가기</a>  |
                <button onclick="updateBookmark()">수정</button></td>
        </tr>
    </table>
</body>
</html>
