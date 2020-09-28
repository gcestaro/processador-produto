package br.com.codar.processador.util;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public interface ConversorArquivo<T> {

	default public List<T> ler() {
		File arquivo = new File(getNomeArquivo());
		
		LeitorArquivoCSV leitorArquivoCSV = new LeitorArquivoCSV(arquivo);

		return leitorArquivoCSV.ler()
				.stream()
				.map(this::converterArquivo)
				.collect(Collectors.toList());
	}

	String getNomeArquivo();

	T converterArquivo(List<String> atributos);
}
