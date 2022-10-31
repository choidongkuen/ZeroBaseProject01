<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.dong.ServicePack.HistoryService" %>
<%--
  Created by IntelliJ IDEA.
  User: DongKuen
  Date: 2022/10/31
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>와이파이 검색 기록 삭제</title>
</head>
<body>
<%
    String wifi_id = request.getParameter("id");
    HistoryService service = new HistoryService();
    int result = service.deleteHistory(Integer.parseInt(wifi_id));
%>

<%= result%>

</body>
</html>
