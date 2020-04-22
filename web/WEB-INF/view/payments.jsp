<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>


<html>
<head>
    <title>Insurance payments</title>
    <style type="text/css">
        body {
            font-family: Droid Serif;
            color: #123C69;
            background-color:#EEE2DC;
        }
        h1{
            color:#AC3B61;
            padding: 0px 0px 0px 50px;
            margin-bottom: 5px;
            font-size: 40px;
        }
        h2{
            color:#BAB2B5;
            padding: 0px 0px 0px 20px;
            margin-top: 0px;
            margin-bottom: 30px;
            font-size: 20px;
        }
        footer {
            background-color: #EDC7B7;
            text-align: center;
            font-size: 20px;
            padding: 15px 0px 15px 0px;
            left: 0;
            bottom: 0;
            width: 100%;
            position: absolute;
        }
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #D6C8BA;
        }

        .tg td {
            font-size: 16px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 3px;
            overflow: hidden;
            word-break: normal;
            background-color: #F7EBD7;
        }

        .tg th {
            font-size: 16px;
            font-weight: bold;
            padding: 10px 5px;
            border-style: solid;
            border-width: 3px;
            overflow: hidden;
            word-break: normal;
            background-color: #D6C8BA;
        }

        .tg .tg-4eph {
            background-color: #D6C8BA;
        }
        form{
            background-color:#D6C8BA;
            border:3px solid #123C69;
            border-radius:20px;
            font-size:30px;
            float:right;
            width:300px;
            max-height:350px;
            margin-right: 40px;
            margin-top: 0px;
        }
        form table{
            border-radius:5px;
            width:300px;
            height:50px;
            font-size:16px;
            font-weight: bold;
            padding: 10px 20px;
        }
        form table td{
            padding-top: 10px;
        }
        form legend{
            font-size: 20px;
            font-weight: bolder;
            text-align: center;
            padding-top: -20px;
        }
        input[type="submit"]
        {
            width:150px;
            height:50px;
            font-size:20px;
            margin:auto;
            display:block;
            background-color: #EEE2DC;
            font-family: Droid Serif;
        }
        input[type="submit"]:hover{
            box-shadow: 0px 0px 10px white;
        }
        .colortext{
            background-color: #F7EBD7;
            color: #123C69;
            border-radius:5px;
            width:150px;
            height:25px;
        }
        .main_page{
            font-size: 24px;
            display: block;
            float: right;
            color: #123C69;
            background-color: #F7EBD7;
            margin-top: -6%;
            margin-right: 5%;
            border: 2px solid #123C69;
            border-bottom: 4px solid #123C69;
            width: 150px;
            height: 50px;
            line-height: 45px;
            text-decoration: none;
            text-align: center;
        }
        .main_page:hover{
            background-color:#ffffff;
            color: #123C69;
            border-color: #123C69;
            box-shadow: 0px 0px 30px #BAB2B5;
        }
        .update{
            text-decoration: none;
            color: #123C69;
        }
        .update:hover{
            color: #AC3B61;
        }
        .tg a{
            text-decoration: none;
            color: #123C69;
        }
        .tg a:hover{
            text-decoration: underline;
            color:#EDC7B7;
        }
    </style>
</head>
<body>
<h1>
    <a href="http://localhost:8080/payments" class="update">Insurance payments</a>
</h1>
<h2>
    Insurance payment is the payment of insurance compensation by the insurance company in the event of an insured event.
</h2>
<a href="http://localhost:8080/" class="main_page">Home</a>
<c:url var="addAction" value="/payments/add"></c:url>
<form:form action="${addAction}" commandName="payment" form="">
    <legend>Add/Edit</legend>
    <table>
        <c:if test="${!empty payment.amount}">
            <tr>
                <td>
                    <form:label path="paymentId">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="paymentId" readonly="true" size="11" disabled="true"/>
                    <form:hidden path="paymentId"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="amount">
                    <spring:message text="Amount"/>
                </form:label>
            </td>
            <td>
                <form:input path="amount" class = "colortext" required="true" type="number" min="1" max="1000000000" placeholder="250000" autocomplete="off"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="datePayment">
                    <spring:message text="Date payment"/>
                </form:label>
            </td>
            <td>
                <form:input path="datePayment" class = "colortext" required="true" type="date"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="conditionsReasons">
                    <spring:message text="Terms and reasons"/>
                </form:label>
            </td>
            <td>
                <form:input path="conditionsReasons" class = "colortext" required="true" maxlength="255" placeholder="Theft of property" autocomplete="off"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="policy">
                    <spring:message text="Id policy"/>
                </form:label>
            </td>
            <td>
                <form:input path="policy" class = "colortext" required="true" type="number" min="1" max="1000000000" placeholder="1" autocomplete="off"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${empty payment.amount}">
                    <input type="submit"
                           value="<spring:message text="Add"/>"/>
                </c:if>
                <c:if test="${!empty payment.amount}">
                    <input type="submit"
                           value="<spring:message text="Edit"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>




<c:if test="${!empty listPayments}">
    <table class="tg">
        <tr>
            <th width="50">Payment ID</th>
            <th width="150">Amount</th>
            <th width="100">Date payment</th>
            <th width="150">Terms and reasons</th>
            <th width="50">Id policy</th>
            <th width="80">Edit</th>
            <th width="80">Delete</th>
        </tr>
        <c:forEach items="${listPayments}" var="payment">
            <tr>
                <td align="center">${payment.paymentId}</td>
                <td>${payment.amount}</td>
                <td>${payment.datePayment}</td>
                <td>${payment.conditionsReasons}</td>
                <td>${payment.policy}</td>
                <td align="center"><a href="<c:url value="/payments/edit/${payment.paymentId}" />">Edit</a></td>
                <td align="center"><a href="<c:url value='/payments/remove/${payment.paymentId}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<footer>©Alekseev Dmitry 17-SBK</footer>
</body>
</html>
