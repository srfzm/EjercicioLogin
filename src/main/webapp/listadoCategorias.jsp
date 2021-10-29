<%@page
	import="EjercicioLogin.Modelos.Categorias, EjercicioLogin.DAO.CategoriasDAO, java.util.*, EjercicioLogin.Utilidades.HibernateUtil"
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%! ArrayList<Categorias> lista = null; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	lista = CategoriasDAO.getLista(HibernateUtil.getSessionFactory().openSession());
	pageContext.setAttribute("lista", lista);
%>
	<%@ include file="cabecera.jsp"%>
	<table border="2">
		<tr>
			<th>Id</th>
			<th>Categoria</th>
			<th>Descripcion</th>
		</tr>
		<c:forEach items="${pageScope.lista}" var="categoria">
			<tr>
				<td><c:out value="${categoria.getId()}"></c:out></td>
				<td><c:out value="${categoria.getNombre()}"></c:out></td>
				<td><c:out value="${categoria.getDescripcion()}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>