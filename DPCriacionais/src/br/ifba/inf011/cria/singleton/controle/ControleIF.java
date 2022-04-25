package br.ifba.inf011.cria.singleton.controle;

import br.ifba.inf011.cria.singleton.Ambiente;
import br.ifba.inf011.cria.singleton.Prototype;

public interface ControleIF extends Prototype {
	
	public void lerTemperatura(Ambiente ambiente) throws Exception;
	public void modificar(Ambiente ambiente);

}
