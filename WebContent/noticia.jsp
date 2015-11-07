<%@ include file = "header.jsp" %>
		<jsp:useBean id = "pdao" class = "br.com.tudosobreesporte.jdbc.dao.PostDao" />
		<c:forEach var = "post" items = ${post.getPost(Integer.parseInt()))} >
			<%
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

			Post post = (Post) pageContext.getAttribute("post");

			String dataFormatada = sdf.format(post.getData().getTime());
			%>
			<article class = "container">
				<p>${dataFormatada}</p>
				<h2>${post.titulo}</h2>
				<p>${post.conteudo}</p>
			</article>
		</c:forEach>
	</body>
</html>