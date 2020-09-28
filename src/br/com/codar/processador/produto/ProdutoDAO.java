package br.com.codar.processador.produto;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ProdutoDAO {

	private static final Set<Produto> PRODUTOS = new HashSet<>();

	public void salvar(Produto fornecedor) {
		PRODUTOS.add(fornecedor);
	}

	public void salvar(List<Produto> produtos) {
		PRODUTOS.addAll(produtos);
	}

	public Optional<Produto> buscar(int codigo) {
		return PRODUTOS.stream()
				.filter(fornecedor -> fornecedor.getCodigo() == codigo)
				.findFirst();
	}

	public Set<Produto> buscar() {
		return PRODUTOS;
	}
}
