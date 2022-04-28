package br.ifba.inf011.comp.strategy;

import java.io.PrintStream;

public interface ControleIF{
	public void controlar(Ambiente ambiente) throws Exception;
	public void printResumo(PrintStream log) throws Exception;
	
}
