<%@ include file = "header.jsp" %>
		<table>
			<c:forEach var = "categoria" items = ${cdao.lista} >
				<tr>
					<td>${categoria.nome}</td>
					<td><a href = "removeCategoria?categoria=${categoria.nome}">Excluir</a></td>
				</tr>
			</c:forEach>
		</table>

		<form action = "adicionaCategoria" method = "POST">
			<h1>Nova categoria</h1> <br />

			<label for = "categoria">Categoria: </label>
			<input type = "text" name = "categoria" placeholder = "Categoria" autofocus required /> <br /> <br />

			<button type = "submit">Adicionar</button>
		</form>
	</body>
</html>