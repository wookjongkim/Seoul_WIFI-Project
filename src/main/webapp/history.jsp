<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>위치 히스토리 목록</title>
    <link rel = "stylesheet" href = "CSS/style.css">
    <script src = "JS/main.js"></script>
</head>
<body onload="displayHistory()">
    <h1>위치 히스토리 목록</h1>
    <p>
        <a href = 'index.jsp'>홈</a>
        <span>|</span>
        <a href = 'history.jsp'>위치 히스토리 목록</a>
        <span>|</span>
        <a href = 'load-wifi.jsp'>Open API 와이파이 정보 가져오기</a>
        <span>|</span>
        <a href = ''>북마크 보기</a>
        <span>|</span>
        <a href = ''>북마크 그룹 관리</a>
    </p>
    <table id = "wifiHistoryTable">
      <tr>
        <th class = "standard">ID</th>
        <th class = "standard">X좌표</th>
        <th class = "standard">Y좌표</th>
        <th class = "standard">조회일자</th>
        <th class = "standard">비고</th>
      </tr>
      <tr>
        <td colspan = "5" class = "default_comment">위치 정보를 바탕으로 조회 후 히스토리를 조회해주세요.</td>
      </tr>
    </table>
</body>
</html>
