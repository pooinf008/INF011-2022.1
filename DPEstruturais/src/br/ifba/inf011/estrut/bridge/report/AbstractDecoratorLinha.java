package br.ifba.inf011.estrut.bridge.report;

public abstract class AbstractDecoratorLinha implements Linha{

	private Linha decorator;
	
	public AbstractDecoratorLinha(Linha decorator) {
		this.decorator = decorator;
	}
	
	public Linha decorator() {
		return this.decorator;
	}
	
	public double getEnergia() {
		return this.decorator.getEnergia();
	}

	public double getSetpoint() {
		return this.decorator.getSetpoint();
	}

	public double getTemperatura() {
		return this.decorator.getTemperatura();
	}	

	public abstract String content();
	
}
