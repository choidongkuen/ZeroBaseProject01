<%--
  Created by IntelliJ IDEA.
  User: DongKuen
  Date: 2022/10/26
  Time: 11:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>와이파이 정보 구하기</title>

    <style>
        table{
            width: 100%;
            border-top: 1px solid #444444;
            border-collapse: collapse;
        }

        th,td{
            border-bottom: 1px solid #444444;
            border-left: 1px solid #444444;
            padding: 10px;
        }
        th:first-child,td:first-child{
            border-left: none;
        }

    </style>
</head>
<body>
<h1> 위치 히스토리 목록</h1>
<h2> 해당 페이지는 사용자의 Wifi 검색 내역을 보여주는 페이지입니다.</h2>
<a href ="index.jsp">홈</a> | <a href = "history" > 위치 히스토리 목록 </a> | <a href = "loadApiData">Open API 와이파이 정보 가져오기</a><br>
<br>

<table class = "table table-hover">
    <thead>
    <tr style="background-color:blanchedalmond">
        <th>ID</th>
        <th>X좌표</th>
        <th>Y좌표</th>
        <th>조회일자</th>
        <th>비고</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var = "data" items="${histories}">
        <tr>

            <td>${data.wifi_id}</td>
            <td>${data.x}</td>
            <td>${data.y}</td>
            <td>${data.date}</td>
            <td>
                <button type="button" id = "removeBtn" onclick= "location.href ='removeHistory?id=${data.wifi_id}' ">삭제</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
