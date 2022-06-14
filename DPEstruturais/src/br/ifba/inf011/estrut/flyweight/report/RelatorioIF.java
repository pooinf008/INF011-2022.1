package br.ifba.inf011.estrut.flyweight.report;

public interface RelatorioIF {
	
	public void addLinha(double energia, double setpoint, double temperatura);
	public String gerar();
	
	

}
