package br.ifba.inf011.comp.tm;

import java.io.PrintStream;

import br.ifba.inf011.comp.tm.controlador.EstrategiaControle;

public interface ControleIF{
	public void controlar(Ambiente ambiente) throws Exception;
	public void printResumo(PrintStream log) throws Exception;
	public double getEnergy() throws Exception;
	
}
