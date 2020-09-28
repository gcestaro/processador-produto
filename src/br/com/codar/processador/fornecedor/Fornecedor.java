package br.com.codar.processador.fornecedor;

import static br.com.codar.processador.util.Calculadora.estaEntre;
import static br.com.codar.processador.util.Calculadora.naoEstaEntre;

import java.util.Objects;

public class Fornecedor {

	private int codigo;

	private String descricao;

	public Fornecedor(int codigo, String descricao) {
		setCodigo(codigo);
		setDescricao(descricao);
	}

	public boolean isEstrangeiro() {
		return estaEntre(codigo, 900, 920);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		if (naoEstaEntre(codigo, 1, 9999)) {
			throw new IllegalArgumentException("Código de fornecedor inválido! Informe um número entre 1 e 9999.");
		}

		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		if (descricao == null) {
			throw new IllegalArgumentException("Descrição de fornecedor inválida! Informe uma descrição.");
		}

		this.descricao = descricao;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Fornecedor))
			return false;

		return ((Fornecedor) obj).getCodigo() == this.getCodigo();
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.codigo);
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("Código: ")
				.append(getCodigo())
				.append(" - ")
				.append("Descrição: ")
				.append(getDescricao()).toString();
	}
}
