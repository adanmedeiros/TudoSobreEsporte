<%@ include file = "header.jsp" %>
		<table>
			<jsp:useBean id = "pdao" class = "br.com.tudosobreesporte.jdbc.dao.PostDao" />

			<c:forEach var = "post" items = "${pdao.lista}" >
				<tr>
					<td>${post.titulo}</td>
					<td><a href = "removePost?id=${post.id}">Excluir</a></td>
				</tr>
			</c:forEach>
		</table>

		<form action = "adicionaPost" method = "POST">
			<h1>Novo Post</h1> <br />

			<label for = "data">Data/Hora: </label>
			<input type = "text" name = "data" placeholder = "Hora atual atualizada" disabled /> <br /> <br />

			<label for = "titulo">T�tulo: </label>
			<input type = "text" name = "titulo" placeholder = "T�tulo do post" required /> <br /> <br />

			<label for = "conteudo">Conte�do:	</label>
			<textarea name = "conteudo" placeholder = "Conte�do do post" required ></textarea> <br /> <br />

			<label for = "tags">Tags: </label>
			<input type = "text" name = "tags" placeholder = "Insira as tags" required /> <br /> <br />

			<button type = "submit">Postar</button>
		</form>
	</body>
</html>