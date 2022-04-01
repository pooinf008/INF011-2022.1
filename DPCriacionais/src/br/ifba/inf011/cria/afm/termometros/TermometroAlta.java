package br.ifba.inf011.cria.afm.termometros;

import br.ifba.inf011.cria.afm.Ambiente;

public class TermometroAlta implements TermometroIF{
	
	private double maxima;

	public TermometroAlta(double maxima) {
		this.maxima = maxima;
	}

	@Override
	public void lerTemperatura(Ambiente ambiente) {
		double temperatura =ambiente.getTemperatura();
		if(temperatura > maxima)
			System.err.println("Termometro ALTA: [ATENÇÃO]" + ambiente.getTemperatura());
		else
			System.out.println("Termometro Alta: " + ambiente.getTemperatura());
	}
	
	

}
