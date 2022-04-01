package br.ifba.inf011.cria.fm.termometros;

import br.ifba.inf011.cria.fm.Ambiente;

public class TermometroFaixa implements TermometroIF{
	
	private double minima;
	private double maxima;

	public TermometroFaixa(double minima, double maxima) {
		this.minima = minima;
		this.maxima = maxima;
	}

	@Override
	public void lerTemperatura(Ambiente ambiente) {
		double temperatura =ambiente.getTemperatura();
		if(temperatura > this.maxima || temperatura < this.minima)
			System.err.println("Termometro FAIXA: [ATENÇÃO]" + ambiente.getTemperatura());
		else
			System.out.println("Termometro Faixa: " + ambiente.getTemperatura());
	}
}	
	