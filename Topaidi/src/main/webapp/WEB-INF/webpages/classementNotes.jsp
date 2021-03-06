<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Classement Buzz</title>
<%@include file="commons/header.jsp"%>
</head>
<body>
	<%@include file="commons/menu.jsp"%>
	<div class="container">
		<div style="margin-top: 10px;">
			<table>
				<tr>
					<th>Id?e</th>
					<th>Auteur</th>
					<th>Pitch</th>
					<th>Date Publication</th>
					<th>Tops</th>
					<th>Nombre Votes</th>
				</tr>
				
				<c:forEach items="${idees}" var="idee">
					<tr>
						<td><c:out value="${idee.titre}" /></td>
						<td><c:out value="${idee.initiateur.username}" /></td>
						<td><c:out value="${idee.pitch}" /></td>
						<td><c:out value="${idee.datePublication}" /></td>
						<td><c:out value="${idee.getNbTops()}" /></td>
						<td><c:out value="${idee.notes.size()}" /></td>
					</tr>
				</c:forEach>
				
			</table>
		</div>
	</div>
</body>
</html>