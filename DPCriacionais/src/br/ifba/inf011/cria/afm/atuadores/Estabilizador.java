package br.ifba.inf011.cria.afm.atuadores;

import br.ifba.inf011.cria.afm.Ambiente;

public class Estabilizador implements AtuadorIF{
	
	private double minima;
	private double maxima;

	public Estabilizador(double minima, double maxima) {
		this.minima = minima;
		this.maxima = maxima;
	}

	@Override
	public void modificar(Ambiente ambiente)  {
		double temperatura = ambiente.getTemperatura();
		if(temperatura > this.maxima) {
			double delta = this.maxima - temperatura;
			System.err.println(">>>> Resfriando: " + delta + "°C");
			ambiente.esfriar(-delta);
		}else if(temperatura < this.minima) {
			double delta = temperatura - this.minima;
			System.err.println(">>>> Aquecer: " + delta + "°C");
			ambiente.aquecer(-delta);
		}	
	}
}	
	