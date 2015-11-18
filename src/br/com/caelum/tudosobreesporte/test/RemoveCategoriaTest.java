package br.com.caelum.tudosobreesporte.test;

import java.util.List;

import br.com.caelum.tudosobreesporte.dao.CategoriaDao;
import br.com.caelum.tudosobreesporte.model.Categoria;

public class RemoveCategoriaTest {
	public static void main (String[] args) {
		CategoriaDao categoriaDao = new CategoriaDao();

		List<Categoria> categorias = categoriaDao.getLista();

		for (Categoria categoria : categorias) {
			if (categoriaDao.remove (categoria.getId()) == true) {
				System.out.println ("Categoria removida com sucesso!");
			} else {
				System.out.println ("Categoria não existe ou possui post atrelado!");
			}
		}
	}
}