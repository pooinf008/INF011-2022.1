package br.ifba.inf011.cria.prototype.controle;

import br.ifba.inf011.cria.prototype.Ambiente;
import br.ifba.inf011.cria.prototype.Prototype;

public interface ControleIF extends Prototype {
	
	public void lerTemperatura(Ambiente ambiente) throws Exception;
	public void modificar(Ambiente ambiente);

}
