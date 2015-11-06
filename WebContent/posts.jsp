<%@ include file = "header.jsp" %>
		<table>
			<%
			PostDao pdao = new PostDao();
			List<Post> posts = pdao.getLista();

			for (Post post : posts) {
			%>

			<tr>
				<td><%= post.getTitulo() %></td>
				<td><a href = "removePost?id=<%= post.getId() %>">Excluir</a></td>
			</tr>

			<%
			}
			%>
		</table>

		<form action = "adicionaPost" method = "POST">
			<h1>Novo Post</h1> <br />

			<label for = "titulo">Título: </label>
			<input type = "text" name = "titulo" placeholder = "Título do post"/> <br /> <br />

			<label for = "conteudo">Conteúdo:	</label>
			<textarea name = "conteudo" placeholder = "Conteúdo do post"></textarea> <br /> <br />

			<label for = "tags">Tags: </label>
			<input type = "text" name = "tags" placeholder = "Insira as tags" /> <br /> <br />

			<button type = "submit">Postar</button>
		</form>
	</body>
</html>