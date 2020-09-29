package br.com.codar.processador.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeitorArquivoCSV {

	private final File arquivo;

	public LeitorArquivoCSV(File arquivo) {
		this.arquivo = arquivo;
	}

	public List<List<String>> ler() {
		List<List<String>> registros = new ArrayList<>();

		try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
			String linha;

			while ((linha = leitor.readLine()) != null) {
				String[] colunas = linha.split(";");

				registros.add(Arrays.asList(colunas));
			}

			return registros;
		} catch (IOException e) {
			throw new IllegalStateException("arquivo inválido");
		}
	}
}
