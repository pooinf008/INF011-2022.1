package br.ifba.inf011.estrut.bridge.report;

public interface Linha {
	public String content();
	public double getEnergia();
	public double getSetpoint();
	public double getTemperatura();
}
