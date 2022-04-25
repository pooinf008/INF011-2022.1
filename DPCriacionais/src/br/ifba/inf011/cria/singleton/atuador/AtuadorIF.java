package br.ifba.inf011.cria.singleton.atuador;

import java.io.PrintStream;

import br.ifba.inf011.cria.singleton.Ambiente;
import br.ifba.inf011.cria.singleton.Prototype;

public interface AtuadorIF extends Prototype {
	public void modificar(Ambiente ambiente);
	public void setSaidaErro(PrintStream out);

}
