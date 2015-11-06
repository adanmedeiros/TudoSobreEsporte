<%@ include file = "header.jsp" %>
		<table>
			<%
			cdao = new CategoriaDao();
			categorias = cdao.getLista();

			for (Categoria categoria : categorias) {
			%>

			<tr>
				<td><%= categoria.getNome() %></td>
				<td><a href = "removeCategoria?categoria=<%= categoria.getNome() %>">Excluir</a></td>
			</tr>

			<%
			}
			%>
		</table>

		<form action = "adicionaCategoria" method = "POST">
			<h1>Nova categoria</h1> <br />

			<label for = "categoria">Categoria: </label>
			<input type = "text" name = "categoria" placeholder = "Categoria" autofocus /> <br /> <br />

			<button type = "submit">Adicionar</button>
		</form>
	</body>
</html>