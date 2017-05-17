<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
  <title>dice</title>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
  <link rel="stylesheet" href="../static/css/style2.css">
<style>
.logoutLblPos{

   position:fixed;
   right:10px;
   top:5px;
}
</style>
</head>
  <label class="logoutLblPos">
  <a href="/logout">Logout</a>
  </label>
<p style="font-size:36px;">Welcome ${user.lastName} ${user.firstName}</p>
<body>
  <div class="dice-wrapper">
    <div class="cubic">
        <div class="front"></div>
        <div class="right"></div>
        <div class="bottom"></div>
        <div class="top"></div>
        <div class="left"></div>
        <div class="back"></div>
    </div>
    <div class="cubic">
        <div class="front"></div>
        <div class="right"></div>
        <div class="bottom"></div>
        <div class="top"></div>
        <div class="left"></div>
        <div class="back"></div>
    </div>
   
</div>
<div id="ctrl">
  <button id="roll" onclick="playGame()">Roll</button>
</div>

<div id="score1">
<div id="status"></div>
</div>
<br>
  <div class="dice-wrapper2">
    <div class="cubic1">
        <div class="front"></div>
        <div class="right"></div>
        <div class="bottom"></div>
        <div class="top"></div>
        <div class="left"></div>
        <div class="back"></div>
    </div>
    <div class="cubic1">
        <div class="front"></div>
        <div class="right"></div>
        <div class="bottom"></div>
        <div class="top"></div>
        <div class="left"></div>
        <div class="back"></div>
    </div>
</div>
<div id="score2">
<div id="status2"></div>
</div>
<div id="myModal" class="modal">
  <div id="myModalContent" class="modal-content">
    <span class="close">&times;</span>
    <p>Some text.</p>
  </div>
</div>

<div id="myModal2" class="modal">
<div id="history" class="modal-content">
<c:choose>
    <c:when test="${not empty error}">
       <div class="alert alert-danger">
   			<p id="error" class="display">  ${error}</p></div>
    </c:when>
    <c:otherwise>
        <p id="status3" class="display">Your last score: ${lastGame.userScore}</p>
		<p id="status4" class="display">Computer last score: ${lastGame.computerScore}</p>
		<p id="status5" class="display"> ${lastGameWinner} </p>
    </c:otherwise>
</c:choose>
</div>
</div>
 <div id="win" class="pyro" hidden>
  <div class="before"></div>
  <div class="after"></div>
</div>
  <script src="<c:url value='../static/js/index.js' />" ></script>
</body>
</html>
