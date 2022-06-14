package br.ifba.inf011.estrut.flyweight.report.fly;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class LinhaSharedFlyweight {
	
	private char simbolo;	
	private String descricao;
	
	public LinhaSharedFlyweight(char simbolo, String descricao) {
		this.simbolo = simbolo;
		this.descricao = descricao;
	}

	public String gerar(int id, Date data, double temperatura) {
		Locale loc = new Locale("pt", "BR");
		DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT, loc);		
		return id + " " + this.simbolo + " " +
			  this.descricao + " " + dateFormat.format(data) + " " +
			  temperatura + "°C";
	}

	public char getSimbolo() {
		return this.simbolo;
	}

}
