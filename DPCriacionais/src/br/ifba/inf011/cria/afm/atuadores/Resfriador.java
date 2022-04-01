package br.ifba.inf011.cria.afm.atuadores;

import br.ifba.inf011.cria.afm.Ambiente;

public class Resfriador implements AtuadorIF {

	private double maxima;

	public Resfriador(double maxima) {
		this.maxima = maxima;
	}	
	
	@Override
	public void modificar(Ambiente ambiente) {
		double temperatura = ambiente.getTemperatura();
		if(temperatura > this.maxima) {
			double delta = temperatura - this.maxima;
			System.err.println(">>>> Resfriando: " + delta + "°C");
			ambiente.esfriar(delta);
		}	
	}

}
