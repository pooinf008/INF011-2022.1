package br.ifba.inf011.comp.state;

import java.io.PrintStream;


public interface ControleIF{
	public void controlar(Ambiente ambiente) throws Exception;
	public void printResumo(PrintStream log) throws Exception;
	public double getEnergy() throws Exception;
	public void salvarEnergia() throws Exception;
	public void desligar() throws Exception;
	public void recarregar() throws Exception;
	public void ligar() throws Exception;
	
	
}
