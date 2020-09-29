package br.com.codar.processador.fornecedor;

import java.util.List;

import br.com.codar.processador.util.ConversorArquivo;

public class LeitorArquivoFornecedor implements ConversorArquivo<Fornecedor> {

	private static final String NOME_ARQUIVO_FORNECEDORES_CSV = "fornecedores.csv";
	
	@Override
	public Fornecedor converterArquivo(List<String> atributos) {
		int codigo = Integer.valueOf(atributos.get(0));

		String descricao = atributos.get(1);

		return new Fornecedor(codigo, descricao);
	}

	@Override
	public String getNomeArquivo() {
		return NOME_ARQUIVO_FORNECEDORES_CSV;
	}
}
