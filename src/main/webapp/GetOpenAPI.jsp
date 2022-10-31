<%--
  Created by IntelliJ IDEA.
  User: DongKuen
  Date: 2022/10/26
  Time: 11:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>JSP - Hello World</title>

</head>
<body>
<h1>
    ${dataSize}개의 WIFI 정보를 정상적으로 저장하였습니다.
</h1>
<a href="index.jsp">홈으로가기</a>
</body>
</html>