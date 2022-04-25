package br.ifba.inf011.cria.singleton.atuador;

import java.io.PrintStream;

import br.ifba.inf011.cria.singleton.Ambiente;
import br.ifba.inf011.cria.singleton.Prototype;

public class Estabilizador implements AtuadorIF{
	
	private double minima;
	private double maxima;
	private PrintStream saidaErro;		

	public Estabilizador(double minima, double maxima) {
		this.minima = minima;
		this.maxima = maxima;
		this.saidaErro = System.err;			
	}
	
	public Estabilizador(double minima, double maxima, PrintStream saidaErro) {
		this.minima = minima;
		this.maxima = maxima;
		this.saidaErro = saidaErro;		
	}		

	public Estabilizador(Estabilizador estabilizador) {
		this.minima = estabilizador.minima;
		this.maxima = estabilizador.maxima;
		this.saidaErro = estabilizador.saidaErro;		
	}

	@Override
	public void modificar(Ambiente ambiente)  {
		double temperatura = ambiente.getTemperatura();
		if(temperatura > this.maxima) {
			double delta = this.maxima - temperatura;
			this.saidaErro.println(">>>> Resfriando: " + delta + "°C");
			ambiente.esfriar(-delta);
		}else if(temperatura < this.minima) {
			double delta = temperatura - this.minima;
			this.saidaErro.println(">>>> Aquecer: " + delta + "°C");
			ambiente.aquecer(-delta);
		}	
	}

	@Override
	public void setSaidaErro(PrintStream out) {
		this.saidaErro = out;
	}

	@Override
	public Prototype clonar() {
		return new Estabilizador(this);
	}

}	
	