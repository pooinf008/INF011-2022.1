package br.ifba.inf011.cria.prototype.controle;

import java.io.PrintStream;

public class DescritorXMLBuilder implements Builder {

	private String termometro;
	private String atuador;
	private double min, max;
	private PrintStream saidaPadrao;
	private PrintStream saidaErro;
	
	@Override
	public void reset() {
		this.termometro = "nenhum";
		this.atuador = "nenhum";
		this.min = Double.NaN;
		this.max = Double.NaN;
		this.saidaPadrao = null;
		this.saidaErro = null;
	}

	@Override
	public void adicionarTermometroFaixa(double min, double max) {
		this.termometro = "termometro-faixa";
		this.min = min;
		this.max = max;
	}

	@Override
	public void adicionarTermometroAlta(double max) {
		this.termometro = "termometro-alta";
		this.min = Double.NaN;
		this.max = max;
	}

	@Override
	public void adicionarSaidaErro(PrintStream saidaErro) {
		this.saidaErro = saidaErro;
	}

	@Override
	public void adicionarSaidaPadrao(PrintStream saidaPadrao) {
		this.saidaPadrao = saidaPadrao;
	}

	@Override
	public void adicionarEstabilizador(double min, double max) {
		this.atuador = "estabilizador";
		this.min = min;
		this.max = max;
	}

	@Override
	public void adicionarResfriador(double max) {
		this.atuador = "resfriador";
		this.min = Double.NaN;
		this.max = max;
	}
	
	private String descSaida(PrintStream saida) {
		if(saida == null)
			return "\'nil\'";
		else if(saida.equals(System.out))
			return "\'system.out\'";
		else if(saida.equals(System.err))
			return "\'system.err\'";
		else
			return "\'" + saida.toString() + "\'";  
	}
	
	public String getDescritor() {
		String descritor = "<controle>\n";
		descritor = descritor + "\t<termometro type = " + this.termometro + 
									" tempMin = " + this.min + " tempMax = " + this.max + "/>\n";
		descritor = descritor + "\t<atuador type = " + this.atuador + 
				" tempMin = " + this.min + " tempMax = " + this.max + "/>\n";
		descritor = descritor + "\t<saida type = \'padrao\' value = "  + this.descSaida(this.saidaPadrao) + 
								"/>\n";
		descritor = descritor + "\t<saida type = \'erro\' value = " +  this.descSaida(this.saidaErro) +
								"/>\n";
		
		descritor = descritor + "</controle>";
		return descritor;
		
	}

}
