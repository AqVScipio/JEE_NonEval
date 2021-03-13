<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fil des Id�es</title>
	<%@include file="commons/header.jsp" %>
</head>
<body>
	<%@include file="commons/menu.jsp" %>
	
	<a class="btn btn-primary" style="float:right;" href="idees?action=create">Ajouter une Id�e</a>
	
	<c:forEach items="${idees}" var="idee">
		<div>
			<div style="float:left;">
		  		<p><c:out value="${idee.titre}" /></p>
		  		<p><c:out value="${idee.initiateur.username}" /></p>
		  		<p><c:out value="${idee.datePublication}" /></p>
		  	</div>
		  	
		  	<div style="float:right;">
		  				
		  	</div>
		  	
		  	<div style="clear:both;">
		  		<p><c:out value="${idee.pitch}" /></p>
		  	</div>
		  	
		  	<div style="float:left;">
		  		<p>
		  			Tops : <c:out value="${idee.getNbTops()}" />
		  			<a class="btn" href="notes?action=top&idee=${idee.id}">+</a>
		  		</p>
		  	</div>
		  	
		  	<div style="float:right;">
		  		<p>
			  		Flops : <c:out value="${idee.getNbFlops()}" />
			  		<a class="btn" href="notes?action=flop&idee=${idee.id}">-</a>
		  		</p>		
		  	</div>
		  </div>
		  
		  <br/>
		  <br/>
	</c:forEach>
</body>
</html>