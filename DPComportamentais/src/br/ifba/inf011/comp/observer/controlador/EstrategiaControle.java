package br.ifba.inf011.comp.observer.controlador;

import java.io.PrintStream;
import java.util.List;

import br.ifba.inf011.comp.observer.Ambiente;

public interface EstrategiaControle {
	
	public double controlar(Ambiente ambiente, double ganho, double setPoint, 
			List<Double> historico, List<Double> diferenca, PrintStream log) throws Exception; 

}
