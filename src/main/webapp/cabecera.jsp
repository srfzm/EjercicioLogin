<%@page import="EjercicioLogin.Modelos.Usuarios"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%! Usuarios us = null;%>
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
</body>
</html>