package br.ifba.inf011.estrut.bridge.report;

public abstract class AbstractLinha implements Linha {

	private double energia;
	private double setpoint;
	private double temperatura;
	
	public AbstractLinha(LinhaId Linha) {
		this.energia = energia;
		this.setpoint = setpoint;
		this.temperatura = temperatura;
	}
	
	public abstract String content();



}
