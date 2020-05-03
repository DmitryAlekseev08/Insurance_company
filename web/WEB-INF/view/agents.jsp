<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>


<html>
<head>
    <title>Insurance agents</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style_members.css"/>">
</head>
<body>
<h1>
    <a href="http://localhost:8080/agents" class="update">Insurance agents</a>
</h1>
<h2>
    An insurance agent is an individual who sells insurance policies on behalf of and on behalf of an insurance company.
</h2>
<a href="http://localhost:8080/" class="main_page">Home</a>
<c:url var="addAction" value="/agents/add"></c:url>
<form:form action="${addAction}" commandName="agent" form="">
    <legend>Add/Edit</legend>
    <table>
        <c:if test="${!empty agent.lastName}">
            <tr>
                <td>
                    <form:label path="agentId">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="agentId" readonly="true" size="11" disabled="true"/>
                    <form:hidden path="agentId"/>
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
            <td>
                <form:label path="percent">
                    <spring:message text="Insurance percent"/>
                </form:label>
            </td>
            <td>
                <form:input path="percent" class = "colortext" required="true" maxlength="4" placeholder="0.25" pattern="[0-9]+\.[0-9]+" autocomplete="off"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${empty agent.lastName}">
                <input type="submit"
                       value="<spring:message text="Add"/>"/>
                </c:if>
                <c:if test="${!empty agent.lastName}">
                    <input type="submit"
                           value="<spring:message text="Edit"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>




<c:if test="${!empty listAgents}">
    <table class="tg">
        <tr>
            <th width="50">Agent ID</th>
            <th width="150">Last name</th>
            <th width="150">First name</th>
            <th width="150">Middle name</th>
            <th width="120">Phone</th>
            <th width="150">Email</th>
            <th width="100">Insurance percent</th>
            <th width="80">Edit</th>
            <th width="80">Delete</th>
        </tr>
        <c:forEach items="${listAgents}" var="agent">
            <tr>
                <td align="center">${agent.agentId}</td>
                <td>${agent.lastName}</td>
                <td>${agent.firstName}</td>
                <td>${agent.middleName}</td>
                <td>${agent.phone}</td>
                <td>${agent.email}</td>
                <td>${agent.percent}</td>
                <td align="center"><a href="<c:url value="/agents/edit/${agent.agentId}" />">Edit</a></td>
                <td align="center"><a href="<c:url value="/agents/remove/${agent.agentId}" />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
<footer>©Alekseev Dmitry 17-SBK</footer>
</html>