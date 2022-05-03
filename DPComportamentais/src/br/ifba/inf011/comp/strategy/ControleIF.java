package br.ifba.inf011.comp.strategy;

import java.io.PrintStream;

import br.ifba.inf011.comp.strategy.controlador.EstrategiaControle;

public interface ControleIF{
	public void controlar(Ambiente ambiente) throws Exception;
	public void printResumo(PrintStream log) throws Exception;
	public void setEstrategia(EstrategiaControle estrategia) throws Exception;
	public double getEnergy() throws Exception;
	
}
