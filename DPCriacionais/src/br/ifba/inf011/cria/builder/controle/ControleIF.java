package br.ifba.inf011.cria.builder.controle;

import br.ifba.inf011.cria.builder.Ambiente;

public interface ControleIF {
	
	public void lerTemperatura(Ambiente ambiente) throws Exception;
	public void modificar(Ambiente ambiente);

}
