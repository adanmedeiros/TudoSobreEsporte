<%@ page import = "java.util.List"%>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ page import = "br.com.tudosobreesporte.jdbc.*" %>
<%@ page import = "br.com.tudosobreesporte.jdbc.dao.*" %>
<%@ page import = "br.com.tudosobreesporte.jdbc.posts.*" %>
<%@ page import = "br.com.tudosobreesporte.jdbc.modelo.*"%>

<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1" pageEncoding = "ISO-8859-1"%>

<%@ taglib  prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv = "Content-Type" content = "text/html; charset = ISO-8859-1">

		<link rel = "stylesheet" href = "header.css" />
		<link rel = "stylesheet" href = "index.css" />
		<link rel = "stylesheet" href = "categorias.css" />
		<link rel = "stylesheet" href = "posts.css" />

		<title>Tudo sobre esporte</title>
	</head>
	<body>
		<header>
			<h1><a href = "index.jsp">Tudo sobre Esporte</a></h1>

			<form action = "filtro" method = "GET">
				<input type = "search" name = "tags" />
				<button type = "submit" >Buscar</button> <br />

				<label for = "salvar">Salvar busca?</label>
				<input type = "checkbox" name = "salvar" />
			</form>
		</header>

		<nav>
			<ul class = "container">
				<jsp:useBean id = "cdao" class = "br.com.tudosobreesporte.jdbc.dao.CategoriaDao" />
				<c:forEach var = "categoria" items = "${cdao.lista}" >
					<li><a href = "filtro?tags=${categoria.nome}">${categoria.nome}</a></li>
				</c:forEach>
			</ul>
		</nav>