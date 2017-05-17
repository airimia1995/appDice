<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Flat HTML5/CSS3 Login Form</title>
  
  
    <link href="<c:url value='https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css' />"  rel="stylesheet"></link> 
    <link rel="stylesheet" href="../static/css/style.css">
</head>


<body>
  <div class="login">
	<h1>Login</h1>
	<c:if test="${not empty error}">
      					<div class="alert alert-danger">
      					<FONT color="red"><strong>Warning!</strong>  ${error}</FONT>
   						
   						</div>
       		 		</c:if>
   <form method="post" action="#" name="loginform" class="login-form"  >
  		<FONT color="red"><form:errors path="email" /></FONT>
        <input type="email" name="emailLOG" placeholder="email" id="email"   />
        <FONT color="red"><form:errors path="password" /></FONT>
         <input type="password" name="passwordLOG" placeholder="password" id="password"   />
        <button type="submit" class="btn btn-primary btn-block btn-large" value="login" id="login" name="login">Let me in.</button>

    </form>
    
    <br>
    <button class="btn btn-primary btn-block btn-large"  onclick="window.location.href='/signup'">Not registered? Create an account </button>
</div>

<script src="<c:url value='https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js' />" ></script>
<script src="<c:url value='/static/js/index.js' />" ></script>
</body>

</html>