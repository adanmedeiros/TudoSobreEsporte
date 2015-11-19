<%@ include file = "header.jsp" %>
		<ol class = "container">
			<c:forEach var = "post" items = "${listaFiltrada}" >
				<li>
					<article>
						<p><fmt:formatDate value = "${post.data.time}" pattern = "dd/MM/yyyy HH:mm"/></p>
						<h2><a href = "noticia?id=${post.id}">${post.titulo}</a></h2>
						<p>${post.conteudo}</p>
						<a href = "noticia?id=${post.id}">Ler mais...</a>
					</article>
				</li>
			</c:forEach>
		</ol>
	</body>
</html>