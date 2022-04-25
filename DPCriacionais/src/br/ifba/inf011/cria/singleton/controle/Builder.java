package br.ifba.inf011.cria.singleton.controle;

import java.io.PrintStream;

public interface Builder {
	public void reset();
	public void adicionarTermometroFaixa(double min, double max);
	public void adicionarTermometroAlta(double max);
	public void adicionarSaidaErro(PrintStream saidaErro);
	public void adicionarSaidaPadrao(PrintStream saidaPadrao);
	public void adicionarEstabilizador(double min, double max);
	public void adicionarResfriador(double max);
}
