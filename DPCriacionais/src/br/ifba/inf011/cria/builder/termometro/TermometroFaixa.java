package br.ifba.inf011.cria.builder.termometro;

import java.io.PrintStream;

import br.ifba.inf011.cria.builder.Ambiente;
import br.ifba.inf011.cria.builder.controle.TermometroIF;

public class TermometroFaixa implements TermometroIF{
	
	private double minima;
	private double maxima;
	private PrintStream saidaPadrao;
	private PrintStream saidaErro;	

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
}	
	