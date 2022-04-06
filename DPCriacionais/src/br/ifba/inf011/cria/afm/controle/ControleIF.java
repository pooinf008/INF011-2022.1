package br.ifba.inf011.cria.afm.controle;

import br.ifba.inf011.cria.afm.atuadores.AtuadorIF;
import br.ifba.inf011.cria.afm.termometros.TermometroIF;

public interface ControleIF {
	
	public TermometroIF getTermometro() throws Exception;
	public AtuadorIF getAtuador() throws Exception;

}
