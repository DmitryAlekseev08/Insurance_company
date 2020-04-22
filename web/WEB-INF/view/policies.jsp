<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>


<html>
<head>
    <title>Insurance policies</title>
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
            max-width: 75%;
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
            max-height:1000px;
            margin-right: 0px;
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
    <a href="http://localhost:8080/policies" class="update">Insurance policies</a>
</h1>
<h2>
    An insurance policy is a document that is issued by the insurer to the policyholder after
    the insurance contract is concluded and the policyholder pays the established insurance premium.
</h2>
<a href="http://localhost:8080/" class="main_page">Home</a>
<c:url var="addAction" value="/policies/add"></c:url>
<form:form action="${addAction}" commandName="policy" form="">
    <legend>Add/Edit</legend>
    <table>
        <c:if test="${!empty policy.seriesNumber}">
            <tr>
                <td>
                    <form:label path="policyId">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="policyId" readonly="true" size="11" disabled="true"/>
                    <form:hidden path="policyId"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="seriesNumber">
                    <spring:message text="Series and number"/>
                </form:label>
            </td>
            <td>
                <form:input path="seriesNumber" class = "colortext" required="true" pattern="[0-9]{10}" placeholder="1234567891" autocomplete="off"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="objectInsurance">
                    <spring:message text="Object insurance"/>
                </form:label>
            </td>
            <td>
                <form:input path="objectInsurance" class = "colortext" required="true" maxlength="30" placeholder="Flat" autocomplete="off"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="insuranceAmount">
                    <spring:message text="Insurance amount"/>
                </form:label>
            </td>
            <td>
                <form:input path="insuranceAmount" class = "colortext" required="true" type="number" min="1" max="1000000000" placeholder="10000" autocomplete="off"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="insurancePremium">
                    <spring:message text="Insurance premium"/>
                </form:label>
            </td>
            <td>
                <form:input path="insurancePremium" class = "colortext" required="true" type="number" min="1" max="1000000000" placeholder="1000" autocomplete="off"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="dateIn">
                    <spring:message text="Date in"/>
                </form:label>
            </td>
            <td>
                <form:input path="dateIn" class = "colortext" required="true" type="date"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="dateOut">
                    <spring:message text="Date out"/>
                </form:label>
            </td>
            <td>
                <form:input path="dateOut" class = "colortext" required="true" type="date"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="agent">
                    <spring:message text="Id agent"/>
                </form:label>
            </td>
            <td>
                <form:input path="agent" class = "colortext" required="true" type="number" min="1" max="1000000000" placeholder="1" autocomplete="off"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="insurant">
                    <spring:message text="Id insurant"/>
                </form:label>
            </td>
            <td>
                <form:input path="insurant" class = "colortext" required="true" type="number" min="1" max="1000000000" placeholder="2" autocomplete="off"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="beneficiary">
                    <spring:message text="Id beneficiary"/>
                </form:label>
            </td>
            <td>
                <form:input path="beneficiary" class = "colortext" required="true" type="number" min="1" max="1000000000" placeholder="3" autocomplete="off"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${empty policy.seriesNumber}">
                    <input type="submit"
                           value="<spring:message text="Add"/>"/>
                </c:if>
                <c:if test="${!empty policy.seriesNumber}">
                    <input type="submit"
                           value="<spring:message text="Edit"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>




<c:if test="${!empty listPolicies}">
    <table class="tg">
        <tr>
            <th width="50">Policy ID</th>
            <th width="120">Series and number</th>
            <th width="150">Object insurance</th>
            <th width="120">Insurance amount</th>
            <th width="120">Insurance premium</th>
            <th width="100">Date in</th>
            <th width="100">Date out</th>
            <th width="50">Id agent</th>
            <th width="50">Id insurant</th>
            <th width="50">Id beneficiary</th>
            <th width="80">Edit</th>
            <th width="80">Delete</th>
        </tr>
        <c:forEach items="${listPolicies}" var="policy">
            <tr>
                <td align="center">${policy.policyId}</td>
                <td>${policy.seriesNumber}</td>
                <td>${policy.objectInsurance}</td>
                <td>${policy.insuranceAmount}</td>
                <td>${policy.insurancePremium}</td>
                <td>${policy.dateIn}</td>
                <td>${policy.dateOut}</td>
                <td>${policy.agent}</td>
                <td>${policy.insurant}</td>
                <td>${policy.beneficiary}</td>
                <td align="center"><a href="<c:url value="/policies/edit/${policy.policyId}" />">Edit</a></td>
                <td align="center"><a href="<c:url value="/policies/remove/${policy.policyId}" />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<footer>©Alekseev Dmitry 17-SBK</footer>
</body>
</html>