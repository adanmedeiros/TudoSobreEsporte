<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="novoPost.css" />
		<title>Novo Post</title>
	</head>
	<body>
		<header>
			<h1>Tudo sobre Esporte</h1>
			<form action="adicionaPost">
				<input type="search" />
				<button>Buscar</button> <br />

				<label for="salvar">Salvar busca?</label>
				<input type="checkbox" name="salvar" />
			</form>
		</header>
		<nav>
			<ul class="container">
				<li><a href="">Futebol</a></li>
				<li><a href="">Basquete</a></li>
				<li><a href="">Motor</a></li>
				<li><a href="">Tenis</a></li>
				<li><a href="">Volei</a></li>
				<li><a href="">Surfe</a></li>
				<li><a href="">Radical</a></li>
				<li><a href="">MMA</a></li>
			</ul>
		</nav>

		<form action="adicionaPost" method="POST">
			<h1>Novo Post</h1> <br />

			<label for="data">Data e hora: </label>
			<input type="text" name="data" placeholder="dd/mm/yyyy hh:mm"/> <br /> <br />

			<label for="titulo">Título: </label>
			<input type="text" name="titulo" placeholder="Título do post"/> <br /> <br />

			<label for="conteudo">Conteúdo:	</label>
			<textarea name="conteudo" placeholder="Conteúdo do post"></textarea> <br /> <br />

			<label for="tags">Tags: </label>
			<input type="text" name="tags" placeholder="Insira as tags" /> <br /> <br />

			<p>*Tags separadas por ponto-e-vírgulas, sem espaço!</p> <br />

			<button type="submit">Postar</button>
		</form>
	</body>
</html>