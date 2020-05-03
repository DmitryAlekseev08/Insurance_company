<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>


<html>
<head>
    <title>Insurance policies</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style_members.css"/>">
    <style type="text/css">
        h2{
            max-width: 75%;
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
                <form:select name="select_agent_id" path="agent" class = "colortext" required="true" autocomplete="off">
                    <c:forEach items="${listAgentId}" var="agentId">
                        <form:option value="${agentId}">${agentId}</form:option>
                    </c:forEach>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="insurant">
                    <spring:message text="Id insurant"/>
                </form:label>
            </td>
            <td>
                <form:select name="select_insurant_id" path="insurant" class = "colortext" required="true" autocomplete="off">
                    <c:forEach items="${listInsurantId}" var="insurantId">
                        <form:option value="${insurantId}">${insurantId}</form:option>
                    </c:forEach>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="beneficiary">
                    <spring:message text="Id beneficiary"/>
                </form:label>
            </td>
            <td>
                <form:select name="select_beneficiary_id" path="beneficiary" class = "colortext" required="true" autocomplete="off">
                    <c:forEach items="${listBeneficiaryId}" var="beneficiaryId">
                        <form:option value="${beneficiaryId}">${beneficiaryId}</form:option>
                    </c:forEach>
                </form:select>
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
            <th width="80">Series and number</th>
            <th width="120">Object insurance</th>
            <th width="80">Insurance amount</th>
            <th width="80">Insurance premium</th>
            <th width="80">Date in</th>
            <th width="80">Date out</th>
            <th width="70">Info agent<br>[id, name]</th>
            <th width="70">Info insurant<br>[id, name]</th>
            <th width="70">Info beneficiary<br>[id, name]</th>
            <th width="50">Edit</th>
            <th width="50">Delete</th>
        </tr>
        <c:forEach items="${listPolicies}" var="policy" varStatus="ñounter">
            <tr>
                <td align="center">${policy.policyId}</td>
                <td>${policy.seriesNumber}</td>
                <td>${policy.objectInsurance}</td>
                <td>${policy.insuranceAmount}</td>
                <td>${policy.insurancePremium}</td>
                <td>${policy.dateIn}</td>
                <td>${policy.dateOut}</td>
                <td>${agentInfo.get(ñounter.count - 1)}</td>
                <td>${insurantInfo.get(ñounter.count - 1)}</td>
                <td>${beneficiaryInfo.get(ñounter.count - 1)}</td>
                <td align="center"><a href="<c:url value="/policies/edit/${policy.policyId}" />">Edit</a></td>
                <td align="center"><a href="<c:url value="/policies/remove/${policy.policyId}" />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
<footer>©Alekseev Dmitry 17-SBK</footer>
</html>