package br.ifba.inf011.comp.cor.handle;

import java.io.PrintStream;
import java.util.List;

import br.ifba.inf011.comp.cor.Ambiente;

public interface ControleHandler {
	
	public double controlar(Ambiente ambiente, double ganho, double setPoint, 
			List<Double> historico, List<Double> diferenca, PrintStream log) throws Exception;
	
	public void setProximo(ControleHandler handler);

}
