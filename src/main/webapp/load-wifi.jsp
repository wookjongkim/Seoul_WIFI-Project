<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>와이파이 정보 구하기</title>
    <link rel = "stylesheet" href = "CSS/style.css">
    <script src = "JS/main.js"></script>
    <style>
        .load_success{
            font-size : 30px;
            text-align : center;
        }
        .load_success_home{
            display : block;
            text-align : center;
        }
    </style>
</head>
<body>
    <p class = "load_success"><%= session.getAttribute("total")%> 개의 WIFI 정보를 정상적으로 저장하였습니다.</p>
    <a href = "index.jsp" class="load_success_home">홈으로 가기</a>
</body>
</html>
