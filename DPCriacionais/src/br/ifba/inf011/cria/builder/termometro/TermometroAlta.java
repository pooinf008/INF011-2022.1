package br.ifba.inf011.cria.builder.termometro;

import java.io.PrintStream;

import br.ifba.inf011.cria.builder.Ambiente;
import br.ifba.inf011.cria.builder.controle.TermometroIF;

public class TermometroAlta implements TermometroIF{
	
	private double maxima;
	private PrintStream saidaPadrao;
	private PrintStream saidaErro;

	public TermometroAlta(double maxima) {
		this.maxima = maxima;
		this.saidaPadrao = System.out;
		this.saidaErro = System.err;
	}	
	
	public TermometroAlta(double maxima, PrintStream saidaPadrao, PrintStream saidaErro) {
		this.maxima = maxima;
		this.saidaPadrao = saidaPadrao;
		this.saidaErro = saidaErro;
	}
	
	@Override
	public void lerTemperatura(Ambiente ambiente) {
		double temperatura =ambiente.getTemperatura();
		if(temperatura > maxima)
			this.saidaPadrao.println("Termometro ALTA: [ATENÇÃO]" + ambiente.getTemperatura());
		else
			this.saidaErro.println("Termometro Alta: " + ambiente.getTemperatura());
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
