package br.ifba.inf011.cria.prototype.controle;

import java.io.PrintStream;

import br.ifba.inf011.cria.prototype.atuador.AtuadorIF;
import br.ifba.inf011.cria.prototype.atuador.Estabilizador;
import br.ifba.inf011.cria.prototype.atuador.Resfriador;
import br.ifba.inf011.cria.prototype.termometro.TermometroAlta;
import br.ifba.inf011.cria.prototype.termometro.TermometroFaixa;
import br.ifba.inf011.cria.prototype.termometro.TermometroIF;

public class ControleBuilder implements Builder {

	private TermometroIF termometro;
	private AtuadorIF atuador;
	private PrintStream streamErr;
	private PrintStream streamStd;
	
	
	@Override
	public void reset() {
		this.termometro = new TermometroAlta(30);
		this.atuador = new Resfriador(30);
		this.streamErr = System.err;
		this.streamStd = System.out;
	}

	@Override
	public void adicionarTermometroFaixa(double min, double max) {
		this.termometro = new TermometroFaixa(min, max);
	}

	@Override
	public void adicionarTermometroAlta(double max) {
		this.termometro = new TermometroAlta(max);
	}

	@Override
	public void adicionarEstabilizador(double min, double max) {
		this.atuador = new Estabilizador(min, max);

	}

	@Override
	public void adicionarResfriador(double max) {
		this.atuador = new Resfriador(max);
	}

	public ControleIF getControle() {
		this.termometro.setSaidaErro(this.streamErr);
		this.termometro.setSaidaErro(this.streamStd);
		this.atuador.setSaidaErro(this.streamErr);
		ControleIF controle = new Controle(this.termometro, this.atuador);
		return controle;
	}

	@Override
	public void adicionarSaidaErro(PrintStream saidaErro) {
		this.streamErr = saidaErro; 
		
	}

	@Override
	public void adicionarSaidaPadrao(PrintStream saidaPadrao) {
		this.streamStd = saidaPadrao;
		
	}

}
