package br.ifba.inf011.estrut.decorator.report;

public interface Relatorio {
	public String content();
	public void addLinha(double energy, double setPoint, double temperatura);
}
