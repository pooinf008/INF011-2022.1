package br.ifba.inf011.comp.base;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import br.ifba.inf011.comp.strategy.util.Estatistica;

public class ControladorGenerico implements ControleIF{
	
	public static final int HISTORICO_INTEGRAL = 10;
	
	private double setPoint;
	private double ganho;
	private List<Double> historico;
	private List<Double> diferenca;
	private PrintStream log;
	private TipoControlador tipo;
	
	
	public ControladorGenerico(double ganho, double setPoint, PrintStream log, TipoControlador tipo) {
		this.setPoint = setPoint;
		this.ganho = ganho;
		this.historico = new ArrayList<Double>();
		this.diferenca = new ArrayList<Double>();
		this.log = log;
		this.tipo = tipo;
	}
	
	@Override
	public void controlar(Ambiente ambiente) throws Exception {
		double temperatura = ambiente.getTemperatura();
		double delta = temperatura - this.setPoint;  
		
	    this.historico.add(temperatura);
	    this.diferenca.add(Math.abs(delta));
	    if(this.tipo == TipoControlador.Proporcional)
	    	this.controlarProporcional(ambiente, this.setPoint, this.historico, this.diferenca);
	    else if(this.tipo == TipoControlador.Dummy)
	    	this.controlarDummy(ambiente, this.setPoint, this.historico, this.diferenca);
	    else if(this.tipo == TipoControlador.Integral)
	    	this.controlarIntegral(ambiente, this.setPoint, this.historico, this.diferenca);
	}
	
	
	public void controlarProporcional(Ambiente ambiente, double setPoint, List<Double> historico, List<Double> diferenca) {
		
		double delta = historico.get(historico.size() - 1) - setPoint;
		double tempAtuacao = Math.abs(delta * ganho);
		
	    if(delta > 0) {
	    	ambiente.esfriar(tempAtuacao);
	    	this.log.println("Atuando para ESFRIAR o ambiente... Temperatura de atuação: " + tempAtuacao + "°C");
	    }	
	    else{
	    	ambiente.aquecer(tempAtuacao);
	    	this.log.println("Atuando para AQUECER o ambiente... Temperatura de atuação: " + tempAtuacao + "°C");
	    }
	}
	
	
	public void controlarIntegral(Ambiente ambiente, double setPoint, List<Double> historico, List<Double> diferenca) {
		double temp = historico.get(historico.size() - 1);
		int qtdeAtuacao = (historico.size() > ControladorGenerico.HISTORICO_INTEGRAL) ?
					  	  ControladorGenerico.HISTORICO_INTEGRAL : historico.size();
		double deltaHistorico = 0;
		for(int i = historico.size() - 1, j = 0; j < qtdeAtuacao; i--, j++)
			deltaHistorico =  (historico.get(historico.size() - 1) - setPoint) + deltaHistorico;
		
		deltaHistorico = deltaHistorico / qtdeAtuacao;
		double tempAtuacao = Math.abs(deltaHistorico * ganho);
		
	    if(temp > this.setPoint) {
	    	ambiente.esfriar(tempAtuacao);
	    	this.log.println("Atuando para ESFRIAR o ambiente... Temperatura de atuação: " + tempAtuacao + "°C");
	    }	
	    else{
	    	ambiente.aquecer(tempAtuacao);
	    	this.log.println("Atuando para AQUECER o ambiente... Temperatura de atuação: " + tempAtuacao + "°C");
	    }
	}
	
	
	public void controlarDummy(Ambiente ambiente, double setPoint, List<Double> historico, List<Double> diferenca) {
    	this.log.println("Temperatura de atuação: 0°C");
	}
	
	
	
	public void printResumo(PrintStream log) {
		Estatistica estatisticas = new Estatistica(this.historico);
		log.println("Estatisticas de Temperatura");
		log.println("\t Média: " + estatisticas.getMediaAritmetica());
		log.println("\t Desvio Padrão: " + estatisticas.getDesvioPadrao());
		
		estatisticas = new Estatistica(this.diferenca);
		log.println("\nEstatisticas dos Erros");
		log.println("\t Média: " + estatisticas.getMediaAritmetica());
		log.println("\t Desvio Padrão: " + estatisticas.getDesvioPadrao());
		
	}

}
