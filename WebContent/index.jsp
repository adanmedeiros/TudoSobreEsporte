<%@ include file = "header.jsp" %>
		<ol class = "container">
			<jsp:useBean id = "pdao" class = "br.com.caelum.tudosobreesporte.dao.PostDao" />
			<c:forEach var = "post" items = "${pdao.lista}" >
				<li>
					<article>
						<p><fmt:formatDate value="${post.data.time}" pattern="dd/MM/yyyy HH:mm"/></p>
						<h2><a href = "noticia?id=${post.id}">${post.titulo}</a></h2>
						<p>${post.conteudo}</p>
						<a href = "noticia?id=${post.id}">Ler mais...</a>
					</article>
				</li>
			</c:forEach>
		</ol>
	</body>
</html>