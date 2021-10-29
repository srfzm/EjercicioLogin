<%@page
	import="EjercicioLogin.Modelos.Roles, EjercicioLogin.DAO.RolesDAO, java.util.*, EjercicioLogin.Utilidades.HibernateUtil"
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%! ArrayList<Roles> lista = null; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	lista = RolesDAO.getLista(HibernateUtil.getSessionFactory().openSession());
	pageContext.setAttribute("lista", lista);
%>
	<%@ include file="cabecera.jsp"%>
	<table border="2">
		<tr>
			<th>Id</th>
			<th>Rol</th>
		</tr>
		<c:forEach items="${pageScope.lista}" var="rol">
			<tr>
				<td><c:out value="${rol.getId()}"></c:out></td>
				<td><c:out value="${rol.getRol()}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>