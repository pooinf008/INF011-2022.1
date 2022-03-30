package br.ifba.inf011.cria.fm.termometros;

import br.ifba.inf011.cria.fm.Ambiente;

public class TermometroBasico implements TermometroIF{

	@Override
	public void lerTemperatura(Ambiente ambiente) {
		System.out.println("Termometro Básico: " + ambiente.getTemperatura());
	}

}
