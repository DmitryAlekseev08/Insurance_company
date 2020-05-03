<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>
<html>
<head>
    <title>Insurance company</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style_main_page.css"/>">
</head>
<body>
<h1>
    Database of the insurance company
</h1>
<h2>
This site provides information about employees and clients of the insurance company.
</h2>
<div class="members">
  <ul>
      <li><h4>Insurance agents</h4><span class="descr">Insurance agents<br><h3>Carry out the sale of insurance policies</h3><a href="http://localhost:8080/agents">Look</a></span></li>
      <li><h4>Insurants</h4><span class="descr">Insurants<br><h3>Use of insurance services</h3><a href="http://localhost:8080/insurants">Look</a></span></li>
	  <li><h4>Beneficiaries</h4><span class="descr">Beneficiaries<br><h3>Receive insurance payments</h3><a href="http://localhost:8080/beneficiaries">Look</a></span></li>
  </ul>
</div>
<div class="members">
  <ul align = "center">
	  <li><h4>Insurance policies</h4><span class="descr">Insurance policies<br><h3>Document confirming the fact of insurance</h3><a href="http://localhost:8080/policies">Look</a></span></li>
	  <li><h4>Insurance payment</h4><span class="descr">Insurance payment<br><h3>Payments made upon the occurrence of an insured event</h3><a href="http://localhost:8080/payments">Look</a></span></li>
  </ul>
</div>
</body>
<footer>©Alekseev Dmitry 17-SBK</footer>
</html>