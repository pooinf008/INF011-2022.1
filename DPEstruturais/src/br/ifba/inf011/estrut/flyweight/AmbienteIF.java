package br.ifba.inf011.estrut.flyweight;

public interface AmbienteIF {
	public double getTemperatura();
	public void randomizar();
	public void aquecer(double tempAtuacao);
	public void esfriar(double tempAtuacao);
}
