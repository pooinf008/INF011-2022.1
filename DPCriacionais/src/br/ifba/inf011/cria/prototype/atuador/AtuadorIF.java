package br.ifba.inf011.cria.prototype.atuador;

import java.io.PrintStream;

import br.ifba.inf011.cria.prototype.Ambiente;
import br.ifba.inf011.cria.prototype.Prototype;

public interface AtuadorIF extends Prototype {
	public void modificar(Ambiente ambiente);
	public void setSaidaErro(PrintStream out);

}
