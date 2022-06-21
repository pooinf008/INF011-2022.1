package br.ifba.inf011.estrut.bridge;

import java.io.PrintStream;

public interface ControleIF{
	public void controlar(AmbienteIF ambiente) throws Exception;
	public void printResumo(PrintStream log) throws Exception;
	public double getEnergy() throws Exception;
	public void salvarEnergia() throws Exception;
	public void desligar() throws Exception;
	public void recarregar() throws Exception;
	public void ligar() throws Exception;
	public void addStateChangedListener(StateChangedListener listener);
	public void doRelatorio();
	
}
