package br.ifba.inf011.estrut.flyweight;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import br.ifba.inf011.estrut.flyweight.estados.ControladorState;
import br.ifba.inf011.estrut.flyweight.estados.OperacionalState;
import br.ifba.inf011.estrut.flyweight.estados.TipoEstado;
import br.ifba.inf011.estrut.flyweight.report.RelatorioIF;
import br.ifba.inf011.estrut.flyweight.report.fly.RelatorioFly;
import br.ifba.inf011.estrut.flyweight.report.nofly.RelatorioNoFly;
import br.ifba.inf011.estrut.flyweight.util.Estatistica;

public class ControladorGenerico implements ControleIF{
	
	
	public static final int HISTORICO_INTEGRAL = 5;
	
	private double setPoint;
	private double ganho;
	private List<Double> historico;
	private List<Double> diferenca;
	private PrintStream log;
	private ControladorState estado;
	private double energy;	
	private RelatorioIF relatorio;
	
	
	private List<StateChangedListener> stateChangedListeners;
	
	
	
	public ControladorGenerico(double ganho, double setPoint, PrintStream log, boolean fly) {
		this.setPoint = setPoint;
		this.ganho = ganho;
		this.historico = new ArrayList<Double>();
		this.diferenca = new ArrayList<Double>();
		this.log = log;
		this.estado = new OperacionalState();
		this.energy = 100;
		this.stateChangedListeners = new ArrayList<StateChangedListener>();
		if(fly)
			this.relatorio = new RelatorioFly();
		else
			this.relatorio = new RelatorioNoFly();
		
	}
	
	
	public void addStateChangedListener(StateChangedListener listener) {
		this.stateChangedListeners.add(listener);
	}
	
	private void fireStateChangedNotify(TipoEstado from, TipoEstado to) {
		if(from.equals(to)) return;
		for(StateChangedListener listener : this.stateChangedListeners)
			listener.stateChange(new StateChangedEvent(from, to));
	}
	
	@Override
	public void controlar(AmbienteIF ambiente) throws Exception {
		double temperatura = ambiente.getTemperatura();
		double delta = temperatura - this.setPoint;  
		
	    this.historico.add(temperatura);
	    this.diferenca.add(Math.abs(delta));
	    this.relatorio.addLinha(this.energy, this.setPoint, temperatura);
	    this.energy -= this.estado.controlar(ambiente, this.ganho, this.setPoint, 
	    						  this.historico, this.diferenca, this.log);
	    this.energy = (this.energy > 100)? 100 : this.energy; 
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


	@Override
	public void salvarEnergia() throws Exception {
		ControladorState atual = this.estado;
		this.estado = this.estado.salvarEnergia();
		this.fireStateChangedNotify(atual.quemSouEu(), this.estado.quemSouEu());	
	}


	@Override
	public void desligar() throws Exception {
		ControladorState atual = this.estado;
		this.estado = this.estado.desligar();
		this.fireStateChangedNotify(atual.quemSouEu(), this.estado.quemSouEu());	}


	@Override
	public void recarregar() throws Exception {
		ControladorState atual = this.estado;
		this.estado = this.estado.recarregar();
		this.fireStateChangedNotify(atual.quemSouEu(), this.estado.quemSouEu());		
	}
	
	public RelatorioIF getRelatorio() {
		return this.relatorio;
	}


	@Override
	public void ligar() throws Exception {
		ControladorState atual = this.estado;
		this.estado = this.estado.ligar();
		this.fireStateChangedNotify(atual.quemSouEu(), this.estado.quemSouEu());
	}


}
