<%@ include file = "header.jsp" %>
		<jsp:useBean id = "pdao" class = "br.com.caelum.tudosobreesporte.dao.PostDao" />
		<c:forEach var = "post" items = "${pdao.getPost(Integer.parseInt(param.id))}" >
			<article class = "container">
				<p>${SimpleDateFormat("dd/MM/yyyy HH:mm").format(post.data.time)}</p>
				<h2>${post.titulo}</h2>
				<p>${post.conteudo}</p>
			</article>
		</c:forEach>
	</body>
</html>