<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>위치 히스토리 목록</title>
    <link rel="stylesheet" href="CSS/style.css">
    <script src = "JS/main.js"></script>
</head>
<body onload = "displayBookmark()">
    <h1>위치 히스토리 목록</h1>
    <p>
        <a href = '#'>홈</a>
        <span>|</span>
        <a href = "/history.jsp">위치 히스토리 목록</a>
        <span>|</span>
        <a href = "/load-wifi-data">Open API 와이파이 정보 가져오기</a>
        <span>|</span>
        <a href = '#'>즐겨 찾기 보기</a>
        <span>|</span>
        <a href = 'bookmark-group.jsp'>즐겨 찾기 그룹 관리</a>
    </p>
    <button onclick="navigateAddBookMark();">북마크 그룹 이름 추가</button>
    <table id = "wifiBookmarkTable">
        <tr>
            <th class="standard">ID</th>
            <th class="standard">북마크 이름</th>
            <th class="standard">순서</th>
            <th class="standard">등록일자</th>
            <th class="standard">수정일자</th>
            <th class="standard">비고</th>
        </tr>
        <tr>
            <td colspan="6" class = "default_comment">북마크 그룹 추가후 조회해주세요</td>
        </tr>
    </table>
</body>
</html>
