<%@ include file = "header.jsp" %>
		<ol class = "container">
			<li>
				<%
				PostsDao pdao = new PostsDao();
				List<Posts> posts = pdao.getListaFiltrada(request.getParameter("tags"));

				for (Posts post : posts) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
					String dataFormatada = sdf.format(post.getData().getTime());
				%>

				<article>
					<p><%= dataFormatada %></p>
					<h2><a href = ""><%= post.getTitulo() %></a></h2>
					<p><%= post.getConteudo() %></p>
					<a href = "">Ler mais...</a>
				</article>

				<%
				}
				%>
			</li>
		</ol>
	</body>
</html>