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
    <form action="/EjercicioLogin/AltaRol" method="post">
        <fieldset>
            <legend>Nuevo Rol:</legend>
            <label for="rol">Nombre Rol</label>
            <input type="text" name="rol" id="rol" placeholder="Introduce nuevo Rol">
			<input type="submit" value="Submit">
        </fieldset>
    </form>
    <form action="menu.jsp" method="post">
			<input type="submit" value="Volver">
	</form>
</body>
</html>