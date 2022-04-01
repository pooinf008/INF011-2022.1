package br.ifba.inf011.cria.afm.termometros;

import br.ifba.inf011.cria.afm.Ambiente;

public class TermometroBasico implements TermometroIF{

	@Override
	public void lerTemperatura(Ambiente ambiente) {
		System.out.println("Termometro Básico: " + ambiente.getTemperatura());
	}

}
