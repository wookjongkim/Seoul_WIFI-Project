<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>와이파이 정보 구하기</title>
    <link rel = "stylesheet" href = "CSS/style.css">
    <script src = "JS/main.js"></script>
</head>
<body>
    <h1>와이파이 정보 구하기</h1>
    <p>
        <a href = "">홈</a>
        <span>|</span>
        <a href = "history.jsp">위치 히스토리 목록</a>
        <span>|</span>
        <a href = "/load-wifi-data">Open API 와이파이 정보 가져오기</a>
        <span>|</span>
        <a href = "bookmark-list.jsp">즐겨 찾기 보기</a>
        <span>|</span>
        <a href = "bookmark-group.jsp">즐겨 찾기 그룹 관리</a>
    </p>
    <p>
        LAT : <input id = 'LAT', type = "text", value="0.0">
        LNT : <input id = 'LNT', type = "text", value="0.0">
        <button id = 'getLocationBtn'>내 위치 가져오기</button>
        <button id = 'getWifiInfoBtn'>근처 WIFI 정보 보기</button>
    </p>
    <table id = "wifiInfoTable">
        <tr>
            <th class="standard">거리(km)</th>
            <th class="standard">관리번호</th>
            <th class="standard">자치구</th>
            <th class="standard">와이파이명</th>
            <th class="standard">도로명 주소</th>
            <th class="standard">상세주소</th>
            <th class="standard">설치위치(층)</th>
            <th class="standard">설치유형</th>
            <th class="standard">설치기관</th>
            <th class="standard">서비스구분</th>
            <th class="standard">망종류</th>
            <th class="standard">설치년도</th>
            <th class="standard">실내외구분</th>
            <th class="standard">WIFI접속환경</th>
            <th class="standard">X좌표</th>
            <th class="standard">Y좌표</th>
            <th class="standard">작업일자</th>
        </tr>
        <tr>
            <td colspan="17" class="default_comment">위치 정보를 입력한 후에 조회해주세요</td>
        </tr>
    </table>
</body>
</html>