package br.com.codar.processador.produto;

import static br.com.codar.processador.util.Calculadora.maiorQue;
import static br.com.codar.processador.util.Calculadora.naoEstaEntre;

import java.math.BigDecimal;
import java.util.Objects;

import br.com.codar.processador.fornecedor.Fornecedor;

public abstract class Produto {

	private int codigo;

	private String descricao;

	private int quantidade;

	private BigDecimal valor;

	private Fornecedor fornecedor;

	public abstract BigDecimal calcularImpostos();

	public boolean isPerecivel() {
		return this instanceof ProdutoPerecivel;
	}

	public boolean isImportado() {
		return fornecedor != null && fornecedor.isEstrangeiro();
	}

	public BigDecimal getImpostoAdicionalImportacao() {
		return isImportado() ? getValorTotal().multiply(BigDecimal.valueOf(0.3)) : BigDecimal.ZERO;
	}

	public BigDecimal getValorTotal() {
		return getValor().multiply(BigDecimal.valueOf(getQuantidade()));
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		if (naoEstaEntre(codigo, 1, 9999)) {
			throw new IllegalArgumentException("Código de produto inválido! Informe um número entre 1 e 9999.");
		}

		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		if (descricao == null || descricao.isBlank()) {
			throw new IllegalArgumentException("Descrição de produto inválida! Informe uma descrição não vazia.");
		}

		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		if (naoEstaEntre(quantidade, 1, 9999)) {
			throw new IllegalArgumentException("Quantidade de produtos inválida! Informe um número entre 1 e 9999.");
		}

		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		if (valor == null || naoEstaEntre(valor, 0.01, 9999.99)) {
			throw new IllegalArgumentException("Valor do produto inválido! Informe um valor entre 0,01 e 9999,99.");
		}

		this.valor = valor;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getDescricaoFornecedor() {
		return fornecedor == null ? "" : fornecedor.getDescricao();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Produto))
			return false;

		return ((Produto) obj).getCodigo() == this.getCodigo();
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.codigo);
	}

	@Override
	public String toString() {
		StringBuilder produtoStringBuilder = new StringBuilder();

		if (isImportado()) {
			produtoStringBuilder.append("*IMPORTADO* ");
		}

		produtoStringBuilder
				.append("Código: ")
				.append(getCodigo())
				.append(" - ")
				.append("Descrição: ")
				.append(getDescricao())
				.append(" - ")
				.append("Fornecedor: ")
				.append(getDescricaoFornecedor())
				.append(" - ")
				.append("Valor Total: ")
				.append(getValorTotal())
				.append(" - ");

		BigDecimal impostos = calcularImpostos();

		if (maiorQue(impostos, BigDecimal.ZERO)) {
			produtoStringBuilder
					.append("Impostos: ")
					.append(impostos);
		} else {
			produtoStringBuilder
					.append("Sem impostos");
		}

		return produtoStringBuilder.toString();
	}
}
