<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
</head>
<body>
<%@ include file="cabecera.jsp" %>
<form action="listadoRoles.jsp" method="post" class="tam">
			<input type="submit" value="Listado de Roless">
</form>
<br>
<form action="altaRol.jsp" method="post" class="tam">
			<input type="submit" value="Dar de alta rol">
</form>
</body>
</html>