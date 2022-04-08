package br.ifba.inf011.cria.builder.atuador;

import java.io.PrintStream;

import br.ifba.inf011.cria.builder.Ambiente;
import br.ifba.inf011.cria.builder.controle.AtuadorIF;

public class Resfriador implements AtuadorIF {

	private double maxima;
	private PrintStream saidaErro;

	public Resfriador(double maxima) {
		this.maxima = maxima;
		this.saidaErro = System.err;
	}	
	
	public Resfriador(double maxima, PrintStream saidaErro) {
		this.maxima = maxima;
		this.saidaErro = saidaErro;
	}	
	
	@Override
	public void modificar(Ambiente ambiente) {
		double temperatura = ambiente.getTemperatura();
		if(temperatura > this.maxima) {
			double delta = temperatura - this.maxima;
			this.saidaErro.println(">>>> Resfriando: " + delta + "°C");
			ambiente.esfriar(delta);
		}	
	}

	@Override
	public void setSaidaErro(PrintStream out) {
		this.saidaErro = out;
	}

}
