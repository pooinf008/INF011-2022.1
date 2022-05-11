package br.ifba.inf011.comp.tm.handler;

import java.io.PrintStream;
import java.util.List;

import br.ifba.inf011.comp.tm.Ambiente;

public interface HandleControle {
	
	public void setProximo(HandleControle proximo);
	public double controlar(Ambiente ambiente, double ganho, double setPoint, List<Double> historico,
			List<Double> diferenca, PrintStream log) throws Exception;

}
