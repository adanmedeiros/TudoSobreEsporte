<%@ include file = "header.jsp" %>
		<jsp:useBean id = "pdao" class = "br.com.caelum.tudosobreesporte.dao.PostDao" />
		<c:forEach var = "post" items = "${pdao.getPost(Integer.parseInt(param.id))}" >
			<article class = "container">
				<p><fmt:formatDate value = "${post.data.time}" pattern = "dd/MM/yyyy HH:mm"/></p>
				<h2>${post.titulo}</h2>
				<p>${post.conteudo}</p>
			</article>
		</c:forEach>
	</body>
</html>