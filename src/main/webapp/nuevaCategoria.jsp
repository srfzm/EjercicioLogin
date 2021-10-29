<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="cabecera.jsp" %>
    <form action="/EjercicioLogin/NuevaCategoria" method="post">
        <fieldset>
            <legend>Nueva Categoria:</legend>
            <label for="rol">Nombre Categoria</label>
            <input type="text" name="nombreCategoria" id="nombreCategoria" placeholder="Introduce el nombre">
            <label for="rol">Descripcion</label>
            <input type="text" name="descripcionCategoria" id="descripcionCategoria" placeholder="Introduce la descripcion">
			<input type="submit" value="Submit">
        </fieldset>
    </form>
</body>
</html>