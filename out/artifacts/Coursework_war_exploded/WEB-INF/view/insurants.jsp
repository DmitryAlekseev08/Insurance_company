<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>


<html>
<head>
    <title>Insurants</title>
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
    <a href="http://localhost:8080/insurants" class="update">Insurants</a>
</h1>
<h2>
    A insurant is an individual who enters into an insurance contract with an insurance agent.
</h2>
<a href="http://localhost:8080/" class="main_page">Home</a>
<c:url var="addAction" value="/insurants/add"></c:url>
<form:form action="${addAction}" commandName="insurant" form="">
    <legend>Add/Edit</legend>
    <table>
        <c:if test="${!empty insurant.lastName}">
            <tr>
                <td>
                    <form:label path="insurantId">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="insurantId" readonly="true" size="11" disabled="true"/>
                    <form:hidden path="insurantId"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="lastName">
                    <spring:message text="Last name"/>
                </form:label>
            </td>
            <td>
                <form:input path="lastName" class = "colortext" required="true" maxlength="30" pattern="^[a-zA-Z]+$" placeholder="Ivanov" autocomplete="off"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="firstName">
                    <spring:message text="First name"/>
                </form:label>
            </td>
            <td>
                <form:input path="firstName" class = "colortext" required="true" maxlength="30" pattern="^[a-zA-Z]+$" placeholder="Ivan" autocomplete="off"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="middleName">
                    <spring:message text="Middle name"/>
                </form:label>
            </td>
            <td>
                <form:input path="middleName" class = "colortext" required="true" maxlength="30" pattern="^[a-zA-Z]+$" placeholder="Ivanovich" autocomplete="off"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="phone">
                    <spring:message text="Phone"/>
                </form:label>
            </td>
            <td>
                <form:input path="phone" class = "colortext" type="tel" required="true" maxlength="18" pattern="\+7\s?[\(]{0,1}9[0-9]{2}[\)]{0,1}\s?\d{3}[-]{0,1}\d{2}[-]{0,1}\d{2}" placeholder="+7 (910) 910-91-00" autocomplete="off"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="email">
                    <spring:message text="Email"/>
                </form:label>
            </td>
            <td>
                <form:input path="email" class = "colortext" type="email" required="true" maxlength="30" placeholder="IvanovII@list.ru" autocomplete="off"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${empty insurant.lastName}">
                <input type="submit"
                       value="<spring:message text="Add"/>"/>
                </c:if>
                <c:if test="${!empty insurant.lastName}">
                    <input type="submit"
                           value="<spring:message text="Edit"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>




<c:if test="${!empty listInsurants}">
    <table class="tg">
        <tr>
            <th width="50">Insurant ID</th>
            <th width="150">Last name</th>
            <th width="150">First name</th>
            <th width="150">Middle name</th>
            <th width="120">Phone</th>
            <th width="150">Email</th>
            <th width="80">Edit</th>
            <th width="80">Delete</th>
        </tr>
        <c:forEach items="${listInsurants}" var="insurant">
            <tr>
                <td align="center">${insurant.insurantId}</td>
                <td>${insurant.lastName}</td>
                <td>${insurant.firstName}</td>
                <td>${insurant.middleName}</td>
                <td>${insurant.phone}</td>
                <td>${insurant.email}</td>
                <td align="center"><a href="<c:url value="/insurants/edit/${insurant.insurantId}" />">Edit</a></td>
                <td align="center"><a href="<c:url value="/insurants/remove/${insurant.insurantId}" />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<footer>©Alekseev Dmitry 17-SBK</footer>
</body>
</html>