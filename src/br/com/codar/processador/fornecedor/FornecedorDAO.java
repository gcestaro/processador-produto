package br.com.codar.processador.fornecedor;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class FornecedorDAO {

	private static final Set<Fornecedor> FORNECEDORES = new HashSet<>();

	public void salvar(Fornecedor fornecedor) {
		FORNECEDORES.add(fornecedor);
	}

	public void salvar(Collection<Fornecedor> fornecedores) {
		FORNECEDORES.addAll(fornecedores);
	}

	public Optional<Fornecedor> buscar(int codigo) {
		return FORNECEDORES.stream()
				.filter(fornecedor -> fornecedor.getCodigo() == codigo)
				.findFirst();
	}

	public Set<Fornecedor> buscar() {
		return FORNECEDORES;
	}
}
