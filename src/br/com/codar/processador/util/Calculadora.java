package br.com.codar.processador.util;

import java.math.BigDecimal;

public class Calculadora {

	private Calculadora() {
	}

	public static boolean maiorQue(Integer n1, Integer n2) {
		return n1.compareTo(n2) > 0;
	}

	public static boolean menorQue(Integer n1, Integer n2) {
		return n1.compareTo(n2) < 0;
	}

	public static boolean maiorQue(BigDecimal n1, BigDecimal n2) {
		return n1.compareTo(n2) > 0;
	}

	public static boolean menorQue(BigDecimal n1, BigDecimal n2) {
		return n1.compareTo(n2) < 0;
	}

	public static boolean estaEntre(Integer valor, Integer inicioIntevalo, Integer fimIntervalo) {
		return maiorOuIgualA(valor, inicioIntevalo) && menorOuIgualA(valor, fimIntervalo);
	}

	public static boolean naoEstaEntre(Integer valor, Integer inicioIntevalo, Integer fimIntervalo) {
		return menorQue(valor, inicioIntevalo) || maiorQue(valor, fimIntervalo);
	}

	public static boolean naoEstaEntre(BigDecimal valor, Double inicioIntevalo, Double fimIntervalo) {
		return menorQue(valor, BigDecimal.valueOf(inicioIntevalo))
				|| maiorQue(valor, BigDecimal.valueOf(fimIntervalo));
	}

	private static boolean menorOuIgualA(Integer n1, Integer n2) {
		return n1.compareTo(n2) <= 0;
	}

	private static boolean maiorOuIgualA(Integer n1, Integer n2) {
		return n1.compareTo(n2) >= 0;
	}
}
