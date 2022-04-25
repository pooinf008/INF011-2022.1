package br.ifba.inf011.cria.builder.controle;

import java.io.PrintStream;

public class XMLDescritorBuilder implements Builder{

	private String termometroTipo;
	private String atuadorTipo;
	private String saidaPadrao;
	private String saidaErro;
	private double maxTerm, minTerm;
	private double maxAtua, minAtua;
	
	
	
	@Override
	public void reset() {
		this.termometroTipo = "termometroAlta";
		this.maxTerm = 30;
		this.minTerm = 30;
		this.atuadorTipo = "resfriador";
		this.saidaErro = "system.err";
		this.saidaPadrao = "system.out";
	}

	@Override
	public void adicionarTermometroFaixa(double min, double max) {
		this.termometroTipo = "termometroFaixa";
		this.maxTerm = max;
		this.minTerm = min;
	}

	@Override
	public void adicionarTermometroAlta(double max) {
		this.termometroTipo = "termometroAlta";
		this.maxTerm = max;
		this.minTerm = max;
	}

	@Override
	public void adicionarSaidaErro(PrintStream saidaErro) {
		if(saidaErro.equals(System.err))
			this.saidaErro = "system.err";
		else if(saidaErro.equals(System.out))
			this.saidaErro = "system.out";
		else
			saidaErro.toString().toLowerCase();
	}

	@Override
	public void adicionarSaidaPadrao(PrintStream saidaPadrao) {
		if(saidaPadrao.equals(System.err))
			this.saidaPadrao = "system.err";
		else if(saidaPadrao.equals(System.out))
			this.saidaPadrao = "system.out";
		else
			this.saidaPadrao = saidaPadrao.toString().toLowerCase();
	}

	@Override
	public void adicionarEstabilizador(double min, double max) {
		this.atuadorTipo = "estabilizador";
		this.maxAtua = max;
		this.minAtua = min;		
	}

	@Override
	public void adicionarResfriador(double max) {
		this.atuadorTipo = "resfriador";
		this.maxAtua = max;
		this.minAtua = max;
	}

	public String getDescritor() {
		String rep = "<controle>\n";
		rep += "\t<termometro  tipo = '" +  this.termometroTipo + "'" + " temperaturaMinima = '" +  this.minTerm +
										 "'" + " temperaturaMaxima = '" +  this.maxTerm +
										 "'>\n";
		rep += "\t<atuador  tipo = '" +  this.atuadorTipo + "'" + " temperaturaMinima = '" +  this.minAtua +
				 "'" + " temperaturaMaxima = '" +  this.maxAtua +
				 "'>\n";
		rep += "\t<saidaPadrao  stream = '" +  this.saidaPadrao + "'>\n";
		rep += "\t<saidaErro  stream = '" +  this.saidaErro + "'>\n";
		rep += "</controle>";
		return rep;
	}

}
