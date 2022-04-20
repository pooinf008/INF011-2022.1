package br.ifba.inf011.cria.prototype.controle;

import java.io.PrintStream;

public class Diretor {
	
	private Builder builder;
	
	public Diretor() {
		this.setBuilder(null);
	}	
	
	public Diretor(Builder builder) {
		this.setBuilder(builder);
	}
	
	public void setBuilder(Builder builder) {
		this.builder = builder;
		if(this.builder != null)
			this.builder.reset();
	}
	
	public void makeControleFaixa(double min, double max, PrintStream saidaPadrao, PrintStream saidaErro) {
		this.builder.reset();
		this.builder.adicionarSaidaErro(saidaErro);
		this.builder.adicionarSaidaPadrao(saidaPadrao);
		this.builder.adicionarTermometroFaixa(min, max);
		this.builder.adicionarEstabilizador(min, max);
	}
	
	public void makeControleAlta(double max, PrintStream saidaPadrao, PrintStream saidaErro) {
		this.builder.reset();
		this.builder.adicionarSaidaErro(saidaErro);
		this.builder.adicionarSaidaPadrao(saidaPadrao);
		this.builder.adicionarTermometroAlta(max);
		this.builder.adicionarResfriador(max);
	}	
	

}
