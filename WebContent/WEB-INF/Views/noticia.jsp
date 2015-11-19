<%@ include file = "header.jsp" %>
		<article class = "container">
			<p><fmt:formatDate value = "${post.data.time}" pattern = "dd/MM/yyyy HH:mm"/></p>
			<h2>${post.titulo}</h2>
			<p>${post.conteudo}</p>
		</article>
	</body>
</html>