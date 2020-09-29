package br.com.codar.processador.produto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProdutoDAO {

	private static final Set<Produto> PRODUTOS = new HashSet<>();

	public void salvar(List<Produto> produtos) {
		PRODUTOS.addAll(produtos);
	}

	public Set<Produto> buscar() {
		return PRODUTOS;
	}
}
