<%@ include file = "header.jsp" %>
		<table>
			<c:forEach var = "categoria" items = "${categorias}" >
				<tr>
					<td>${categoria.nome}</td>
					<td><a href = "removeCategoria?id=${categoria.id}">Excluir</a></td>
				</tr>
			</c:forEach>
		</table>

		<form action = "adicionaCategoria" method = "POST">
			<h1>Nova categoria</h1> <br />

			<label for = "categoria">Categoria: </label>
			<input type = "text" name = "categoria" placeholder = "Categoria" autofocus required /> <br /> <br />

			<button type = "submit">Adicionar</button>
		</form>

		<script src = "jQuery.js"></script>
		<script src = "custom.js"></script>
	</body>
</html>