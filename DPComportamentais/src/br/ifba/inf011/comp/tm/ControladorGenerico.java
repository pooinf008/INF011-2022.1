package br.ifba.inf011.comp.tm;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import br.ifba.inf011.comp.tm.controlador.EstrategiaControle;
import br.ifba.inf011.comp.tm.controlador.TipoControlador;
import br.ifba.inf011.comp.tm.handler.ConstanteHandler;
import br.ifba.inf011.comp.tm.handler.DummyHandler;
import br.ifba.inf011.comp.tm.handler.HandleControle;
import br.ifba.inf011.comp.tm.handler.IntegralHandle;
import br.ifba.inf011.comp.tm.handler.ProporcionalHandle;
import br.ifba.inf011.comp.tm.util.Estatistica;

public class ControladorGenerico implements ControleIF{
	
	
	public static final int HISTORICO_INTEGRAL = 5;
	
	private double setPoint;
	private double ganho;
	private List<Double> historico;
	private List<Double> diferenca;
	private PrintStream log;
	private HandleControle handle;
	private double energy;	
	
	
	public ControladorGenerico(double ganho, double setPoint, PrintStream log) {
		this.setPoint = setPoint;
		this.ganho = ganho;
		this.historico = new ArrayList<Double>();
		this.diferenca = new ArrayList<Double>();
		this.log = log;
		this.handle = new ConstanteHandler(new ProporcionalHandle(new IntegralHandle(new DummyHandler())));
		this.energy = 100;
	}
	
	
	@Override
	public void controlar(Ambiente ambiente) throws Exception {
		double temperatura = ambiente.getTemperatura();
		double delta = temperatura - this.setPoint;  
		
	    this.historico.add(temperatura);
	    this.diferenca.add(Math.abs(delta));
	    this.energy -= this.handle.controlar(ambiente, this.ganho, this.setPoint, 
	    						  this.historico, this.diferenca, this.log);
	}
	
	
	public void printResumo(PrintStream log) {
		Estatistica estatisticas = new Estatistica(this.historico);
		log.println("Estatisticas de Temperatura");
		log.println("\t M�dia: " + estatisticas.getMediaAritmetica());
		log.println("\t Desvio Padr�o: " + estatisticas.getDesvioPadrao());
		log.println("\t Qtde de Medidas: " + estatisticas.getTotalElementos());
		
		estatisticas = new Estatistica(this.diferenca);
		log.println("\nEstatisticas dos Erros");
		log.println("\t M�dia: " + estatisticas.getMediaAritmetica());
		log.println("\t Desvio Padr�o: " + estatisticas.getDesvioPadrao());
		log.println("\t Qtde de Medidas: " + estatisticas.getTotalElementos());	
	}
	
	public double getEnergy() {
		return this.energy;
	}	

}
