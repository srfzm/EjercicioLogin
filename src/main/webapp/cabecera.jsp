<%@page
	import="EjercicioLogin.Modelos.Usuarios, java.time.format.DateTimeFormatter, java.time.LocalDateTime
	
"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%! Usuarios us = null;
DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss 'del' dd-MM-yyyy");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	us = (Usuarios) session.getAttribute("usuario");
	%>
	<h1>
		Usuario:
		<%=us.getNombre() + " "%>
		<%=us.getApellido1() + " "%>
		<%=us.getApellido2()%>
	</h1>
	<h2>
		Fecha:
		<%= formato.format((LocalDateTime)session.getAttribute("fecha"))%>
	</h2>
	<br>
	<form action="/EjercicioLogin/Logout" method="post">
			<input type="submit" value="Cerrar Sesion">
	</form>
	<br>
	<input type=<%= (request.getRequestURI().endsWith("menu.jsp")) ? "hidden" : "submit" %> value="Volver" onclick="window.history.go(-1)">
	<br>
</body>
</html>