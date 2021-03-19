<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav>
    <div class="nav-wrapper" style="background-color: grey;">
    	<div class="container">
    		<a href="home" class="brand-logo">${username}</a>

			<ul id="nav-mobile" class="right hide-on-med-and-down">
			  <li><a href="idees?action=tops">Tops</a></li>
			  <li><a href="idees?action=brains">Brains</a></li>
			  <li><a href="idees?action=buzz">Buzz</a></li>
			  <li><a style="font-weight:bold;" href="idees?action=list">Idees</a></li>
			</ul>
    	</div>
      
    </div>
</nav>
</body>
</html>