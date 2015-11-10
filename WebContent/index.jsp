<%@ include file = "header.jsp" %>	
		<ol class = "container">
			<jsp:useBean id = "pdao" class = "br.com.tudosobreesporte.jdbc.dao.PostDao" />
			<c:forEach var = "post" items = "${pdao.lista}" >
				<li>
					<article>
						<p>${SimpleDateFormat("dd/MM/yyyy HH:mm").format(post.data.time)}</p>
						<h2><a href = "noticia?id=${post.id}">${post.titulo}</a></h2>
						<p>${post.conteudo}</p>
						<a href = "noticia?id=${post.id}">Ler mais...</a>
					</article>
				</li>
			</c:forEach>
		</ol>
	</body>
</html>