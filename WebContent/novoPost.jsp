<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset = ISO-8859-1">
		<link rel="stylesheet" href="novoPost.css" />
		<title>Novo Post</title>
	</head>
	<body>
		<h1>Novo Post</h1>

		<form action="">
			<label for="data">Data e hora: </label>
			<input type="text" name="data" placeholder="dd/mm/yyyy hh:mm"/> <br /> <br />

			<label for="titulo">Título: </label>
			<input type="text" name="titulo" placeholder="Título do post"/> <br /> <br />

			<label for="conteudo">Conteúdo:	</label>
			<textarea name="conteudo" placeholder="Conteúdo do post"></textarea> <br /> <br />

			<button type="button">Postar</button>
		</form>
	</body>
</html>