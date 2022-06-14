package br.ifba.inf011.estrut.flyweight.report.fly;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class LinhaUnsharedFlyweight {
	
	private int id;
	private LinhaSharedFlyweight descricao;
	private Date data;
	private double temperatura;
	
	public LinhaUnsharedFlyweight(int id, LinhaSharedFlyweight descricao, Date data, double temperatura) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.data = data;
		this.temperatura = temperatura;
	}
	
	public String gerar() {
		return descricao.gerar(this.id, this.data, this.temperatura);
	}
	
	

}
