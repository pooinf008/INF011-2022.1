package br.ifba.inf011.cria.builder.controle;

import java.io.PrintStream;

import br.ifba.inf011.cria.builder.Ambiente;

public interface TermometroIF {
	public void lerTemperatura(Ambiente ambiente);
	public void setSaidaErro(PrintStream out);
	public void setSaidaPadrao(PrintStream out);
	
}
