document.querySelector("#post").addEventListener("click", function(e) {
	var input = document.querySelectorAll("input");

	for (i = 0; i < input.size(); i++) {
		var conteudo = input.valueOf();

		if (conteudo == null) {
			alert ("Preencha todos os campos!");
			e.preventDefault();
			return;
		}
	}
});