package br.ifba.inf011.estrut.flyweight;

import java.util.Random;

public class Sala implements AmbienteIF{

	private double ultimaMedicao;

	public Sala(double temperaturaInicial) {
		this.ultimaMedicao = temperaturaInicial;
	}
	
	public double getTemperatura() {
		return this.ultimaMedicao; 
	}
	
	public void aquecer(double intensidade) {
		this.ultimaMedicao += this.getVariacao(intensidade);
	}
	
	public void esfriar(double intensidade) {
		this.ultimaMedicao -= this.getVariacao(intensidade);
	}
	

	private double getVariacao(double intensidade) {
		Random random = new Random();
		double variacao = random.nextDouble() * intensidade;
		return variacao;
	}	

	
	public void randomizar() {
		Random random = new Random();
		int valor = random.nextInt(3);
		if (random.nextBoolean()) 
			this.esfriar(valor); 
		else
			this.aquecer(valor); 
	}
	
	
}	