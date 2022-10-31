<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 홈 JSP 페이지 --%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>와이파이정보구하기</title>
    <style>
        /* table, th, td {
        border: 1px solid;
        } */
        table{
            width: 100%;
            border-top: 1px solid #444444;
            border-collapse: collapse;
        }

        td,th{
            border-bottom: 1px solid #444444;
            border-left: 1px solid #444444;
            padding: 10px;
        }
        th:first-child,td:first-child{
            border-left: none;
        }
    </style>

<%--    <script>--%>
<%--        alert("위치 정보를 입력한 후에 조회해 주세요!");--%>
<%--    </script>--%>
</head>
<body>

<h1 class = "align-items-center center">와이파이 정보 구하기</h1>
<h4>서울시, 자치구가 구축하여 제공해 주는 누구나 사용이 가능한 무선인터넷 서비스 지역(AP)에 대한 위치 정보입니다.</h4>

<a href ="index.jsp">홈</a> |
<a href = "history" > 위치 히스토리 목록 </a> |
<a href = "loadApiData">Open API 와이파이 정보 가져오기</a>

<br><br>

<form action = "aroundWifi" method = "get">
    LAT : <input type = "text" id = "x" name = "x" placeholder="위도 입력">
    LNT : <input type = "text" id = "y" name = "y" placeholder="경도 입력">

    <button type = "button" id = "myLoc">내 위치 가져오기</button>
    <input type = "submit" value = "근처 WIFI 정보 보기"/>
</form>


<!-- 입력 칸 -->
<table>
    <thead>
    <tr bgcolor="#ffebcd">
        <th>거리(km)</th>
        <th>관리번호</th>
        <th>자치구</th>
        <th>와이파이 명</th>
        <th>도로명 주소</th>
        <th>상세 주소</th>
        <th>설치 위치(층)</th>
        <th>설치유형</th>
        <th>설치기관</th>
        <th>서비스구분</th>
        <th>망종류</th>
        <th>설치년도</th>
        <th>실내외구분</th>
        <th>WIFI접속환경</th>
        <th>x좌표</th>
        <th>y좌표</th>
        <th>작업일자</th>
    </tr>
    </thead>


    <tbody>
    <c:forEach var="data" items="${nearWifiData}">
        <tr>
            <td>${data.distance}</td>
            <td>${data.wifi_no}</td>
            <td>${data.gu}</td>
            <td>${data.wifi_name}</td>
            <td>${data.road_Address}</td>
            <td>${data.address}</td>
            <td>${data.installedFloor}</td>
            <td>${data.installType}</td>
            <td>${data.installAgency}</td>
            <td>${data.serviceType}</td>
            <td>${data.networkType}</td>
            <td>${data.installedYear}</td>
            <td>${data.inOutType}</td>
            <td>${data.accessType}</td>
            <td>${data.x}</td>
            <td>${data.y}</td>
            <td>${data.date}</td>
        </tr>
    </c:forEach>
    </tbody>

</table>

<script>

    const button = document.getElementById("myLoc");
    button.addEventListener('click', getUserLocation); // 이벤트 발생

    function getUserLocation() {
        if (!navigator.geolocation) {
            throw "위치 정보가 지원되지 않습니다.";
        }
        navigator.geolocation.getCurrentPosition(success);
    }

    function success({coords, timestamp}) {
        const latitude = coords.latitude; // 위도
        const longitude = coords.longitude; // 경도
        input_text(latitude, longitude);
    }
    function input_text(x, y) {
        document.getElementById("x").value = x;
        document.getElementById("y").value = y;
    }
</script>

</body>
</html>