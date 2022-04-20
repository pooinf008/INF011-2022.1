package br.ifba.inf011.cria.prototype.termometro;

import java.io.PrintStream;

import br.ifba.inf011.cria.prototype.Ambiente;
import br.ifba.inf011.cria.prototype.termometro.TermometroIF;

public class TermometroFaixa implements TermometroIF{
	
	private double minima;
	private double maxima;
	private PrintStream saidaPadrao;
	private PrintStream saidaErro;	

	public TermometroFaixa(TermometroFaixa tf) {
		this.minima = tf.minima;
		this.maxima = tf.maxima;
		this.saidaPadrao = tf.saidaPadrao;
		this.saidaErro = tf.saidaErro;
	}
	
	public TermometroFaixa(double minima, double maxima) {
		this.minima = minima;
		this.maxima = maxima;
		this.saidaPadrao = System.out;
		this.saidaErro = System.err;		
	}
	
	public TermometroFaixa(double minima, double maxima, PrintStream saidaPadrao, PrintStream saidaErro) {
		this.minima = minima;
		this.maxima = maxima;
		this.saidaPadrao = saidaPadrao;
		this.saidaErro = saidaErro;		
	}	

	@Override
	public void lerTemperatura(Ambiente ambiente) {
		double temperatura =ambiente.getTemperatura();
		if(temperatura > this.maxima || temperatura < this.minima)
			this.saidaErro.println("Termometro FAIXA: [ATENÇÃO]" + ambiente.getTemperatura());
		else
			this.saidaPadrao.println("Termometro Faixa: " + ambiente.getTemperatura());
	}

	@Override
	public void setSaidaErro(PrintStream out) {
		this.saidaErro = out;
	}

	@Override
	public void setSaidaPadrao(PrintStream out) {
		this.saidaPadrao = out;
	}

	@Override
	public TermometroIF clonar() {
		return new TermometroFaixa(this);
	}
	
	public String toString() {
		return "[TIPO: Termometro de Faixa] " +
			   "Temperatura Mínima " + this.minima + "° " +
			   "Temperatura Máxima " + this.maxima + "° " +
			   "Id " + super.toString();
	}

	@Override
	public void setTemperaturaMaxima(double maxima) {
		this.maxima = maxima;
		
	}
		
	
}	
	