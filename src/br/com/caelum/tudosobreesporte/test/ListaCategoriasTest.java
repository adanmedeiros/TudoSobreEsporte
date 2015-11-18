package br.com.caelum.tudosobreesporte.test;

import java.util.List;

import br.com.caelum.tudosobreesporte.dao.CategoriaDao;
import br.com.caelum.tudosobreesporte.model.Categoria;

public class ListaCategoriasTest {
	public static void main (String[] args) {
		CategoriaDao categoriaDao = new CategoriaDao();

		List<Categoria> categorias = categoriaDao.getLista();

		for (Categoria categoria : categorias) {
			System.out.println (categoria.getNome());
		}
	}
}