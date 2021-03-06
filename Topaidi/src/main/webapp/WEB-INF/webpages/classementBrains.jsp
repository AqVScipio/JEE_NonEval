<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Classement Brains</title>
<%@include file="commons/header.jsp"%>
</head>
<body>
	<%@include file="commons/menu.jsp"%>
	<div class="container">
		<a class="btn btn-primary" style="float: right;"
			href="idees?action=create">Ajouter une Id?e</a>

		<div style="margin-top: 10px;">
			<table>
				<tr>
					<th>Auteur</th>
					<th>Nombre d'id?es</th>
				</tr>
				
				<c:forEach items="${utilisateur}" var="brains">
					<tr>
						<td><c:out value="${utilisateur.username}" /></td>
						<td><c:out value="${utilisateur.idees.size()}" /></td>
					</tr>
				</c:forEach>
				
			</table>
		</div>
	</div>
</body>
</html>