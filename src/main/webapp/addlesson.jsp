<%@page import="java.nio.charset.Charset"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter un cours</title>
</head>
<body>
	<h1>Ajouter un cours</h1>
	<center>
		<form method="post" action="Hello.jsp">
			<label>Nom du cours*</label> : <input type="text" name="name" /><br><label>Catégorie*</label>
			: <input type="text" name="categ" /><br><label>Contenu</label> :
			<textarea name="textarea" rows="10" cols="20">Saisir le contenu ici.</textarea><br>

			<input type="submit" value="Envoyer le cours" />
		</form>
	</center>
</body>
</html>