<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>와이파이 정보 구하기</title>
    <link rel="stylesheet" href="CSS/style.css">
    <script src = "JS/main.js"></script>
</head>
<body>
        <h1>와이파이 정보 구하기</h1>
        <a href="index.jsp">홈</a>
        <span>|</span>
        <a href="history.jsp">위치 히스토리 목록</a>
        <span>|</span>
        <a href="load-wifi.jsp">와이파이 정보 가져오기</a>
        <span>|</span>
        <a href = '#'>북마크 보기</a>
        <span>|</span>
        <a href = '#'> 북마크 그룹 관리</a>
        <span>|</span>

        <p>
            <select>
                <option>북마크 그룹 이름 선택</option>
            </select>
            <button>북마크 추가하기</button>
        </p>

        <table id = "wifiDetailTable">
            <tr>
                <td class = "standard">거리(Km)</td>
                <td id="distanceKm"></td>
            </tr>
            <tr>
                <td class = "standard">관리번호</td>
                <td id = "manageNum"></td>
            </tr>
            <tr>
                <td class = "standard">자치구</td>
                <td id = "district"></td>
            </tr>
            <tr>
                <td class = "standard">와이파이명</td>
                <td id="wifiName"></td>
            </tr>
            <tr>
                <td class = "standard">도로명주소</td>
                <td id = "roadAddress"></td>
            </tr>
            <tr>
                <td class = "standard">상세주소</td>
                <td id = "detailAddress"></td>
            </tr>
            <tr>
                <td class = "standard">설치층</td>
                <td id = "installationFloor"></td>
            </tr>
            <tr>
                <td class = "standard">설치유형</td>
                <td id = "installationType"></td>
            </tr>
            <tr>
                <td class = "standard">설치기관</td>
                <td id = "installationAgency"></td>
            </tr>
            <tr>
                <td class = "standard">서비스 구분</td>
                <td id = "serviceType"></td>
            </tr>
            <tr>
                <td class = "standard">망 종류</td>
                <td id = "networkType"></td>
            </tr>
            <tr>
                <td class = "standard">설치년도</td>
                <td id ="installationYear"></td>
            </tr>
            <tr>
                <td class = "standard">실내외 구분</td>
                <td id="indoorOutdoor"></td>
            </tr>
            <tr>
                <td class = "standard">와이파이 접속환경</td>
                <td id="wifiConnectionEnvironment"></td>
            </tr>
            <tr>
                <td class = "standard">X 좌표</td>
                <td id="xCoordinate"></td>
            </tr>
            <tr>
                <td class = "standard">Y 좌표</td>
                <td id="yCoordinate"></td>
            </tr>
            <tr>
                <td class = "standard">작업일자</td>
                <td id="operationDate"></td>
            </tr>
        </table>
</body>
</html>
