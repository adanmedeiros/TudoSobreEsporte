<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1" pageEncoding = "ISO-8859-1"%>

<%@ taglib  prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv = "Content-Type" content = "text/html; charset = ISO-8859-1">

		<link rel = "stylesheet" href = "CSS/header.css" />
		<link rel = "stylesheet" href = "CSS/index.css" />
		<link rel = "stylesheet" href = "CSS/categorias.css" />
		<link rel = "stylesheet" href = "CSS/posts.css" />

		<title>Tudo sobre esporte</title>
	</head>
	<body>
		<header>
			<h1><a href = "<c:url value='/' />">Tudo sobre Esporte</a></h1>

			<form action = "filtro" method = "GET">
				<input type = "search" name = "categoria" />
				<button type = "submit" >Buscar</button> <br />

				<label for = "salvar">Salvar busca?</label>
				<input type = "checkbox" name = "salvar" />
			</form>
		</header>

		<nav>	
			<ul class = "container">
				<c:forEach var = "categoria" items = "${categorias}" >
					<li><a href = "filtro?categoria=${categoria.nome}">${categoria.nome}</a></li>
				</c:forEach>
			</ul>
		</nav>