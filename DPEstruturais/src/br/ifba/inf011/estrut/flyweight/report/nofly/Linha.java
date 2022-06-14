package br.ifba.inf011.estrut.flyweight.report.nofly;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Linha {
	
	private int id;
	private char simbolo;
	private String descricao;
	private Date data;
	private double temperatura;
	
	public Linha(int id, char simbolo, String descricao, Date data, double temperatura) {
		super();
		this.id = id;
		this.simbolo = simbolo;
		this.descricao = descricao;
		this.data = data;
		this.temperatura = temperatura;
	}
	
	public String gerar() {
		Locale loc = new Locale("pt", "BR");
		DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT, loc);		
		
		return this.id + " " + this.simbolo + " " +
			   this.descricao + " " + dateFormat.format(this.data) + " " +
			   this.temperatura + "°C";
	}
	
	

}
