package br.ifba.inf011.estrut.proxy.controlador;

import java.io.PrintStream;
import java.util.List;

import br.ifba.inf011.estrut.proxy.Sala;

public interface EstrategiaControle {
	
	public double controlar(Sala ambiente, double ganho, double setPoint, 
			List<Double> historico, List<Double> diferenca, PrintStream log) throws Exception; 

}
