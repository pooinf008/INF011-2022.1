package br.ifba.inf011.cria.builder.controle;

import java.io.PrintStream;

import br.ifba.inf011.cria.builder.atuador.Estabilizador;
import br.ifba.inf011.cria.builder.atuador.Resfriador;
import br.ifba.inf011.cria.builder.termometro.TermometroAlta;
import br.ifba.inf011.cria.builder.termometro.TermometroFaixa;

public class ControleBuilderTipo2{

	private TermometroIF termometro;
	private AtuadorIF atuador;
	private PrintStream streamErr;
	private PrintStream streamStd;
	
	
	public ControleBuilderTipo2 reset() {
		this.termometro = new TermometroAlta(30);
		this.atuador = new Resfriador(30);
		this.streamErr = System.err;
		this.streamStd = System.out;
		return this;
	}

	public ControleBuilderTipo2 adicionarTermometroFaixa(double min, double max) {
		this.termometro = new TermometroFaixa(min, max);
		return this;
	}

	public ControleBuilderTipo2 adicionarTermometroAlta(double max) {
		this.termometro = new TermometroAlta(max);
		return this;
	}

	public ControleBuilderTipo2 adicionarEstabilizador(double min, double max) {
		this.atuador = new Estabilizador(min, max);
		return this;
	}

	
	public ControleBuilderTipo2 adicionarResfriador(double max) {
		this.atuador = new Resfriador(max);
		return this;
	}

	public ControleIF build() {
		this.termometro.setSaidaErro(this.streamErr);
		this.termometro.setSaidaErro(this.streamStd);
		this.atuador.setSaidaErro(this.streamErr);
		ControleIF controle = new Controle(this.termometro, this.atuador);
		return controle;
	}

	public ControleBuilderTipo2 adicionarSaidaErro(PrintStream saidaErro) {
		this.streamErr = saidaErro;
		return this;
		
	}

	public ControleBuilderTipo2 adicionarSaidaPadrao(PrintStream saidaPadrao) {
		this.streamStd = saidaPadrao;
		return this;
	}

}
