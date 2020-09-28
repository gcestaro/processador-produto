package br.com.codar.processador.util;

import java.util.Collection;

public interface Impressora<T> {

	void imprimir(T item);

	default void imprimir(Collection<T> itens) {
		itens.forEach(this::imprimir);
	}
}
