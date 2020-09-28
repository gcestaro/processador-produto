package br.com.codar.processador.produto;

import static br.com.codar.processador.util.Calculadora.naoEstaEntre;

import java.math.BigDecimal;

public class ProdutoPerecivel extends Produto {

	private int diasValidade;

	public ProdutoPerecivel(int diasValidade) {
		setDiasValidade(diasValidade);
	}

	public int getDiasValidade() {
		return diasValidade;
	}

	public void setDiasValidade(Integer diasValidade) {
		if (diasValidade != null && naoEstaEntre(diasValidade, 1, 999)) {
			throw new IllegalArgumentException(
					"Dias de validade do produto inválida! Informe um número entre 1 e 999.");
		}

		this.diasValidade = diasValidade;
	}

	@Override
	public BigDecimal calcularImpostos() {
		if (getQuantidade() > 50) {
			BigDecimal imposto = getValorTotal().multiply(BigDecimal.valueOf(0.1));

			return imposto.add(getImpostoAdicionalImportacao());
		}

		return BigDecimal.ZERO;
	}

	@Override
	public String toString() {
		return new StringBuilder(super.toString())
				.append(" - ")
				.append(getDiasValidade())
				.append(" dias de validade")
				.toString();
	}
}
