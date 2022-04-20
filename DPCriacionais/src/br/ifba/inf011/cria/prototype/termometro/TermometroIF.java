package br.ifba.inf011.cria.prototype.termometro;

import java.io.PrintStream;

import br.ifba.inf011.cria.prototype.Ambiente;
import br.ifba.inf011.cria.prototype.Prototype;

public interface TermometroIF extends Prototype{
	public void lerTemperatura(Ambiente ambiente);
	public void setSaidaErro(PrintStream out);
	public void setSaidaPadrao(PrintStream out);
	public void setTemperaturaMaxima(double maxima);
}
