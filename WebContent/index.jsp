<%@ include file = "header.jsp" %>	
		<ol class = "container">
			<li>
				<%
				PostDao pdao = new PostDao();
				List<Post> posts = pdao.getLista();

				for (Post post : posts) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
					String dataFormatada = sdf.format(post.getData().getTime());
				%>

				<article>
					<p><%= dataFormatada %></p>
					<h2><a href = "<%= post.getTitulo() %>"><%= post.getTitulo() %></a></h2>
					<p><%= post.getConteudo() %></p>
					<a href = "<%= post.getTitulo() %>">Ler mais...</a>
				</article>

				<%
				}
				%>
			</li>
		</ol>
	</body>
</html>