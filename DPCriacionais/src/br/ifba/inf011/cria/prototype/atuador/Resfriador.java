package br.ifba.inf011.cria.prototype.atuador;

import java.io.PrintStream;

import br.ifba.inf011.cria.prototype.Ambiente;

public class Resfriador implements AtuadorIF {

	private double maxima;
	private PrintStream saidaErro;

	public Resfriador(Resfriador resfriador) {
		this.maxima = resfriador.maxima;
		this.saidaErro = resfriador.saidaErro;
	}	
	
	public Resfriador(double maxima, PrintStream saidaErro) {
		this.maxima = maxima;
		this.saidaErro = saidaErro;
	}	
	
	public Resfriador(double maxima) {
		this(maxima, System.err);
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

	@Override
	public Object clonar() {
		return new Resfriador(this);
	}

}
