<%@ include file = "header.jsp" %>
		<table>
			<jsp:useBean id = "pdao" class = "br.com.caelum.tudosobreesporte.dao.PostDao" />

			<c:forEach var = "post" items = "${pdao.lista}" >
				<tr>
					<td>${post.titulo}</td>
					<td><a href = "removePost?id=${post.id}">Excluir</a></td>
				</tr>
			</c:forEach>
		</table>

		<form action = "adicionaPost" method = "POST" id = "post">
			<h1>Novo Post</h1> <br />

			<label for = "titulo">T�tulo: </label>
			<input type = "text" name = "titulo" placeholder = "T�tulo do post" required /> <br /> <br />

			<label for = "conteudo">Conte�do:	</label>
			<textarea name = "conteudo" placeholder = "Conte�do do post" required ></textarea> <br /> <br />

			<label for = "tags">Tags: </label>
			<select name = "tags" required>
				<c:forEach var = "categoria" items = "${cdao.lista}">
					<option value = "${categoria.nome}">${categoria.nome}</option>
				</c:forEach>
			</select>

			<button type = "submit">Postar</button>
		</form>

		<script src = "jQuery.js"></script>
		<script src = "custom.js"></script>
	</body>
</html>