<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>
<html>
<head>
    <title>Insurance company</title>
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
        h3{
            font-size: 22px;
            font-weight: normal;
        }
        footer {
            background-color: #EDC7B7;
            text-align: center;
            font-size: 20px;
            padding: 15px 0px 15px 0px;
            width: 100%;
            flex: 0 0 auto;
        }
        .members{
            max-width: 1360px;
            margin: 0 auto;
            /*border-color: black;
            border: solid;*/
        }
         .members ul,
         .members li{
             margin: 0px;
             padding: 0px;
             list-style-type: none;
         }

         .members li{
             display: inline-block;
             text-align: center;
             height: 300px;
             width: 450px;
             position: relative;
             overflow: hidden;
         }
         .members img{
             max-width: 100%;
             display: block;
         }
         .descr{
             font-size: 26px;
             font-weight: bold;
             position: absolute;
             top: 100%;
             left: 0px;
             width: 100%;
             height: 100%;
             background-color: rgba(0,0,0,.6);
             color: #ffffff;
             padding-top: 50px;
             text-align: center;
             opacity: 0;
             -webkit-transition: all .55s;
             -o-transition: all .55s;
             transition: all .55s;
         }
         .descr a{
             display: block;
             color: white;
             margin-top: 10%;
             margin-left: 33%;
             border: 2px solid white;
             border-bottom: 4px solid white;
             width: 150px;
             height: 50px;
             line-height: 45px;
             text-decoration: none;
         }
         .descr a:hover{
             background-color:#EEE2DC;
             color: #123C69;
             border-color: #123C69;
             box-shadow: 0px 0px 10px white;
         }
        .members li:hover .descr{
            top: 0;
            opacity: 1;
        }

    </style>
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
      <li><span class="descr">Insurance agents<br><h3>Carry out the sale of insurance policies</h3><a href="http://localhost:8080/agents">Look</a></span><img srñ="${pageContext.request.contextPath}/images/insurants.jpg"/></li>
      <li><span class="descr">Insurants<br><h3>Use of insurance services</h3><a href="http://localhost:8080/insurants">Look</a></span><img srñ="insurants.jpg" alt ="Alt"/></li>
	  <li><span class="descr">Beneficiaries<br><h3>Receive insurance payments</h3><a href="http://localhost:8080/beneficiaries">Look</a></span><img srñ="images\insurants.jpg" alt ="Alt"/></li>
  </ul>
</div>
<div class="members">
  <ul align = "center">
	  <li><span class="descr">Insurance policies<br><h3>Document confirming the fact of insurance</h3><a href="http://localhost:8080/policies">Look</a></span><img srñ="../images/insurants.jpg" alt ="Alt"/></li>
	  <li><span class="descr">Insurance payment<br><h3>Payments made upon the occurrence of an insured event</h3><a href="http://localhost:8080/payments">Look</a></span><img srñ='<c:url value="images/insurants.jpg"/>' alt ="Alt"/></li>
  </ul> 
</div>
<footer>©Alekseev Dmitry 17-SBK</footer>
</body>
</html>