<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>


<html>
<head>
    <title>Error</title>
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
    </style>
</head>
<body>
 <h1>Error</h1>
 <h2>The id you entered does not exist.</h2>
 <a class="main_page" onclick="history.back()">Back</a>
 <footer>©Alekseev Dmitry 17-SBK</footer>
</body>
</html>
