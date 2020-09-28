package br.com.codar.processador.produto;

import java.math.BigDecimal;
import java.util.List;

import br.com.codar.processador.fornecedor.FornecedorDAO;
import br.com.codar.processador.util.ConversorArquivo;

public class LeitorArquivoProduto implements ConversorArquivo<Produto> {

	private static final String NOME_ARQUIVO_PRODUTOS_CSV = "produtos.csv";
	private final FornecedorDAO fornecedorDAO;

	public LeitorArquivoProduto(FornecedorDAO fornecedorDAO) {
		this.fornecedorDAO = fornecedorDAO;
	}

	@Override
	public Produto converterArquivo(List<String> atributos) {

		int codigo = Integer.valueOf(atributos.get(0));
		String descricao = atributos.get(1);
		int quantidade = Integer.valueOf(atributos.get(2));
		BigDecimal valor = new BigDecimal(atributos.get(3));
		int codigoFornecedor = Integer.valueOf(atributos.get(4));

		final Produto produto;
		if (atributos.size() == 6) {
			String diasValidade = atributos.get(5);
			produto = new ProdutoPerecivel(Integer.valueOf(diasValidade));
		} else {
			produto = new ProdutoNaoPerecivel();
		}

		produto.setCodigo(codigo);
		produto.setDescricao(descricao);
		produto.setQuantidade(quantidade);
		produto.setValor(valor);

		fornecedorDAO.buscar(codigoFornecedor)
				.ifPresentOrElse(produto::setFornecedor, () -> new IllegalStateException(
						"Arquivo de produtos com código de fornecedor [ " + codigoFornecedor + "] inválido."));

		return produto;
	}

	@Override
	public String getNomeArquivo() {
		return NOME_ARQUIVO_PRODUTOS_CSV;
	}
}
