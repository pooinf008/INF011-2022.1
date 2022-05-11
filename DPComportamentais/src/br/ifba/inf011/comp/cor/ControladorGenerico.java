package br.ifba.inf011.comp.cor;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import br.ifba.inf011.comp.cor.handle.ControleHandler;
import br.ifba.inf011.comp.cor.handle.IntegralHandler;
import br.ifba.inf011.comp.cor.handle.ProporcionalHandler;
import br.ifba.inf011.comp.cor.handle.ZeroHandler;
import br.ifba.inf011.comp.cor.util.Estatistica;

public class ControladorGenerico implements ControleIF{
	
	
	public static final int HISTORICO_INTEGRAL = 5;
	
	private double setPoint;
	private double ganho;
	private List<Double> historico;
	private List<Double> diferenca;
	private PrintStream log;
	private ControleHandler handler;
	private double energy;	
	
	
	public ControladorGenerico(double ganho, double setPoint, PrintStream log) {
		this.setPoint = setPoint;
		this.ganho = ganho;
		this.historico = new ArrayList<Double>();
		this.diferenca = new ArrayList<Double>();
		this.log = log;
		this.handler = new ProporcionalHandler(
						new IntegralHandler(
							new ZeroHandler()));
		this.energy = 100;
	}
	

	@Override
	public void controlar(Ambiente ambiente) throws Exception {
		double temperatura = ambiente.getTemperatura();
		double delta = temperatura - this.setPoint;  
		
	    this.historico.add(temperatura);
	    this.diferenca.add(Math.abs(delta));
	    this.energy -= this.handler.controlar(ambiente, this.ganho, this.setPoint, 
	    						  this.historico, this.diferenca, this.log);
	}
	
	
	public void printResumo(PrintStream log) {
		Estatistica estatisticas = new Estatistica(this.historico);
		log.println("Estatisticas de Temperatura");
		log.println("\t Média: " + estatisticas.getMediaAritmetica());
		log.println("\t Desvio Padrão: " + estatisticas.getDesvioPadrao());
		log.println("\t Qtde de Medidas: " + estatisticas.getTotalElementos());
		
		estatisticas = new Estatistica(this.diferenca);
		log.println("\nEstatisticas dos Erros");
		log.println("\t Média: " + estatisticas.getMediaAritmetica());
		log.println("\t Desvio Padrão: " + estatisticas.getDesvioPadrao());
		log.println("\t Qtde de Medidas: " + estatisticas.getTotalElementos());	
	}
	
	public double getEnergy() {
		return this.energy;
	}	

}
