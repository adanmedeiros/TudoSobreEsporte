<%@ include file = "header.jsp" %>
		<table>
			<c:forEach var = "post" items = "${posts}" >
				<tr>
					<td>${post.titulo}</td>
					<td><a href = "removePost?id=${post.id}">Excluir</a></td>
				</tr>
			</c:forEach>
		</table>

		<form action = "adicionaPost" method = "POST" id = "post">
			<h1>Novo Post</h1> <br />

			<label for = "titulo">Título: </label>
			<input type = "text" name = "titulo" placeholder = "Título do post" required /> <br /> <br />

			<label for = "conteudo">Conteúdo:	</label>
			<textarea name = "conteudo" placeholder = "Conteúdo do post" required ></textarea> <br /> <br />

			<label for = "categoriaId">Tags: </label>
			<select name = "categoriaId" required>
				<c:forEach var = "categoria" items = "${categorias}">
					<option value = "${categoria.id}">${categoria.nome}</option>
				</c:forEach>
			</select>

			<button type = "submit">Postar</button>
		</form>
	</body>
</html>