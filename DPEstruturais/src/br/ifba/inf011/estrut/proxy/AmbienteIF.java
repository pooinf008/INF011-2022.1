package br.ifba.inf011.estrut.proxy;

public interface AmbienteIF {
	public double getTemperatura();
	public void randomizar();
	public void aquecer(double tempAtuacao);
	public void esfriar(double tempAtuacao);
}
