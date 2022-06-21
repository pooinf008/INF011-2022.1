package br.ifba.inf011.estrut.decorator.report;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import br.ifba.inf011.estrut.decorator.servico.ClienteServico;
import br.ifba.inf011.estrut.decorator.servico.ServicoIF;

public class LinhaFull implements Linha{
	
	private int id;
	private char simbolo;
	private String descricao;
	private Date data;
	private double energia;
	private double temperatura;
	private double setpoint;
	
	
	public LinhaFull(int id, double energia, double setpoint, double temperatura) {
		super();
		this.id = id;
		this.energia = energia;
		this.setpoint = setpoint;
		this.temperatura = temperatura;
		this.init();
	}
	
	private void init() {
		CategoriaServico categoria = new CategoriaServico();
		ServicoIF servico = new ClienteServico();
		this.simbolo = categoria.getCategoria(this.energia, this.setpoint, this.temperatura);
		try {
			this.descricao = servico.ask(this.simbolo);
		} catch (Exception e) {
			this.descricao = "ERRO-CONSULTA";
		}
		this.data = new Date();
	}
	
	public String content() {
		Locale loc = new Locale("pt", "BR");
		DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT, loc);		
		
		return this.id + " " + this.simbolo + " " +
			   this.descricao + " " + dateFormat.format(this.data) + " " +
			   this.temperatura + "°C";
	}

	public double getEnergia() {
		return this.energia;
	}

	public double getSetpoint() {
		return this.setpoint;
	}

	public double getTemperatura() {
		return this.temperatura;
	}
	
	

}
