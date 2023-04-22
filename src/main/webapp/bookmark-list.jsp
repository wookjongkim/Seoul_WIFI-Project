<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>와이파이 정보 구하기</title>
    <link rel="stylesheet" href="CSS/style.css">
    <script src = "JS/main.js"></script>
</head>
<body>
<h1>위치 히스토리 목록</h1>
    <p>
        <a href = 'index.jsp'>홈</a>
        <span>|</span>
        <a href = "/history.jsp">위치 히스토리 목록</a>
        <span>|</span>
        <a href = "/load-wifi-data">Open API 와이파이 정보 가져오기</a>
        <span>|</span>
        <a href = '#'>즐겨 찾기 보기</a>
        <span>|</span>
        <a href = 'bookmark-group.jsp'>즐겨 찾기 그룹 관리</a>
    </p>
    <table id = "wifiFavoriteTable">
        <tr>
            <th class="standard">ID</th>
            <th class="standard">북마크 이름</th>
            <th class="standard">와이파이명</th>
            <th class="standard">등록일자</th>
            <th class="standard">비고</th>
        </tr>
        <tr>
            <td colspan = "5" class = "default_comment">즐겨찾기 추가후 조회해주세요.</td>
        </tr>
    </table>
</body>
</html>
