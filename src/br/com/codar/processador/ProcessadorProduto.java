package br.com.codar.processador;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import br.com.codar.processador.fornecedor.Fornecedor;
import br.com.codar.processador.fornecedor.FornecedorDAO;
import br.com.codar.processador.fornecedor.LeitorArquivoFornecedor;
import br.com.codar.processador.produto.LeitorArquivoProduto;
import br.com.codar.processador.produto.Produto;
import br.com.codar.processador.produto.ProdutoDAO;

public class ProcessadorProduto {

	public static void main(String[] args) {
		List<Fornecedor> fornecedores = new LeitorArquivoFornecedor().ler();

		validarDuplicidade(fornecedores, "Fornecedores com o mesmo código no arquivo de fornecedores");

		FornecedorDAO fornecedorDAO = new FornecedorDAO();

		fornecedorDAO.salvar(fornecedores);

		List<Produto> produtos = new LeitorArquivoProduto(fornecedorDAO).ler();

		validarDuplicidade(produtos, "Produtos com o mesmo código no arquivo de produtos");

		ProdutoDAO produtoDAO = new ProdutoDAO();

		produtoDAO.salvar(produtos);

		Set<Produto> produtosSalvos = produtoDAO.buscar();

		System.out.println("PRODUTOS PERECÍVEIS");
		produtosSalvos.stream()
				.filter(Produto::isPerecivel)
				.sorted(Comparator.comparing(Produto::getDescricao))
				.forEach(System.out::println);

		System.out.println();
		System.out.println("PRODUTOS NÃO PERECÍVEIS");
		produtosSalvos.stream()
				.filter(Predicate.not(Produto::isPerecivel))
				.sorted(Comparator.comparing(Produto::getDescricao))
				.forEach(System.out::println);

		System.out.println();
		System.out.println("FORNECEDORES");
		fornecedorDAO.buscar()
				.forEach(System.out::println);
	}

	private static void validarDuplicidade(List<?> list, String mensagemDeErro) {
		if (list.size() != new HashSet<>(list).size()) {
			throw new IllegalStateException(mensagemDeErro);
		}
	}
}
