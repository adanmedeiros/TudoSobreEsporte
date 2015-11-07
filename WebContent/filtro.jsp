<%@ include file = "header.jsp" %>
		<ol class = "container">
			<li>
				<jsp:useBean id = "pdao" class = "br.com.tudosobreesporte.jdbc.dao.PostDao" />
				<c:forEach var = "post" items = ${pdao.getListaFiltrada(request.getParameter('tags'))} >
					<%
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

					Post post = (Post) pageContext.getAttribute("post");

					String dataFormatada = sdf.format(post.getData().getTime());
					%>
					<article>
						<p>${dataFormatada}</p>
						<h2><a href = "noticia?id=${post.id}">${post.titulo}</a></h2>
						<p>${post.conteudo}</p>
						<a href = "noticia?id=${post.id}">Ler mais...</a>
					</article>
				</c:forEach>
			</li>
		</ol>
	</body>
</html>