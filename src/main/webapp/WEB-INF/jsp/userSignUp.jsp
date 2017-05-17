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
	<h1>SignUp</h1>
   <form:form method="post"  name="loginform" class="login-form" commandName="user">
       <label for="name">First Name:</label>
                    <FONT color="red"><form:errors path="firstName" /></FONT>
               			 <form:input class="text medium-long-field" type="text"
                       id="name" name="firstName" maxlength="50"  path="firstName"/>
        <label for="lastName">Last Name:</label>
                    <FONT color="red"><form:errors path="lastName" /></FONT>
               			 <form:input class="text medium-long-field" type="text"
                       id="name" name="lasttName" maxlength="50" path="lastName"/>
        <label for="email">Email: </label>
        				<FONT color="red"><form:errors path="email" /></FONT>
               			 <form:input class="text medium-long-field" type="email"
                       id="name" name="email"  path="email" maxlength="50"/>
        <label for="password">Password:</label>
       					 <FONT color="red"><form:errors path="password" /></FONT>
               			 <form:input class="text medium-long-field" type="password"
                       id="name" name="password" path="password" maxlength="50"/>
                     
        <button class="btn btn-primary btn-block btn-large"  value="Register">SignUp</button>
        
    </form:form>
     <br>
    <button class="btn btn-primary btn-block btn-large"  onclick="window.location.href='/login'">Back</button>
</div>

<script src="<c:url value='https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js' />" ></script>
<script src="<c:url value='/static/js/index.js' />" ></script>
</body>

</html>