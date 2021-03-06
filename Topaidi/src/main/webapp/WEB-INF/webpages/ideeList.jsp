<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Fil des Id?es</title>
<%@include file="commons/header.jsp"%>
</head>
<body>
	<%@include file="commons/menu.jsp"%>
	<div class="container">
		<a class="btn btn-primary" style="float: right;"
			href="idees?action=create">Ajouter une Id?e</a>

		<div style="clear: both; margin-top: 10px;">
			<c:forEach items="${idees}" var="idee">
				<div class="w3-container w3-border">
					<div style="float: left;">
						<p style="text-decoration: underline;">
							<c:out value="${idee.titre}" />
						</p>
						<p>
							<c:out value="${idee.initiateur.username}" />
						</p>
						<p>
							<c:out value="${idee.datePublication}" />
						</p>
					</div>

					<div style="float: right;"></div>

					<div style="clear: both;">
						<p>
							<c:out value="${idee.pitch}" />
						</p>
					</div>

					<div style="float: left;">
						<p>
							Tops :
							<c:out value="${idee.getNbTops()}" />

							<c:if test="${idee.canVote(userID)}">
								<a class="btn" href="notes?action=top&idee=${idee.id}">+</a>
							</c:if>

						</p>
					</div>

					<div style="float: right;">
						<p>
							Flops :
							<c:out value="${idee.getNbFlops()}" />
							<c:if test="${idee.canVote(userID)}">
								<a class="btn" href="notes?action=flop&idee=${idee.id}">-</a>
							</c:if>
						</p>
					</div>
				</div>

				<br />
				<hr />

				<br />

			</c:forEach>
		</div>
	</div>

</body>
</html>