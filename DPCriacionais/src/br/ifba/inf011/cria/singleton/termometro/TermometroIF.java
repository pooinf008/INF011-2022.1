package br.ifba.inf011.cria.singleton.termometro;

import java.io.PrintStream;

import br.ifba.inf011.cria.singleton.Ambiente;
import br.ifba.inf011.cria.singleton.Prototype;

public interface TermometroIF extends Prototype{
	public void lerTemperatura(Ambiente ambiente);
	public void setSaidaErro(PrintStream out);
	public void setSaidaPadrao(PrintStream out);
	public void setTemperaturaMaxima(double maxima);
}
