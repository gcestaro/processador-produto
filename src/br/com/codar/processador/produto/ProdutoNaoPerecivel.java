package br.com.codar.processador.produto;

import java.math.BigDecimal;

public class ProdutoNaoPerecivel extends Produto {

	@Override
	public BigDecimal calcularImpostos() {
		BigDecimal valorTotal = getValorTotal();

		BigDecimal imposto = valorTotal.multiply(BigDecimal.valueOf(0.2));

		return imposto.add(getImpostoAdicionalImportacao());
	}
}
