<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>


<html>
<head>
    <title>Error</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style_members.css"/>">
</head>
<body>
 <h1>Error</h1>
 <h2>The id you entered does not exist.</h2>
 <a class="main_page" onclick="history.back()">Back</a>
</body>
<footer>©Alekseev Dmitry 17-SBK</footer>
</html>
