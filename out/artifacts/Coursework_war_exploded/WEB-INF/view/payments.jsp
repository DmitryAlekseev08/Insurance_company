<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>


<html>
<head>
    <title>Insurance payments</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style_members.css"/>">
    <style type="text/css">
        form{
            max-height:350px;
            margin-right: 40px;
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
                <form:select name="select_policy_id" path="policy" class = "colortext" required="true" autocomplete="off">
                    <c:forEach items="${listPolicyId}" var="policyId">
                        <form:option value="${policyId}">${policyId}</form:option>
                    </c:forEach>
                </form:select>
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
                <td align="center"><a href="<c:url value="/payments/remove/${payment.paymentId}" />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
<footer>©Alekseev Dmitry 17-SBK</footer>
</html>
