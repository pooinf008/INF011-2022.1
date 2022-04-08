package br.ifba.inf011.cria.builder.controle;

import java.io.PrintStream;

import br.ifba.inf011.cria.builder.Ambiente;

public interface AtuadorIF {
	public void modificar(Ambiente ambiente);
	public void setSaidaErro(PrintStream out);

}
