package br.ifba.inf011.estrut.adapter;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import br.ifba.inf011.estrut.adapter.estados.ControladorState;
import br.ifba.inf011.estrut.adapter.estados.OperacionalState;
import br.ifba.inf011.estrut.adapter.estados.TipoEstado;
import br.ifba.inf011.estrut.adapter.util.Estatistica;

public class ControladorGenerico implements ControleIF{
	
	
	public static final int HISTORICO_INTEGRAL = 5;
	
	private double setPoint;
	private double ganho;
	private List<Double> historico;
	private List<Double> diferenca;
	private PrintStream log;
	private ControladorState estado;
	private double energy;	
	
	
	private List<StateChangedListener> stateChangedListeners;
	
	
	
	public ControladorGenerico(double ganho, double setPoint, PrintStream log) {
		this.setPoint = setPoint;
		this.ganho = ganho;
		this.historico = new ArrayList<Double>();
		this.diferenca = new ArrayList<Double>();
		this.log = log;
		this.estado = new OperacionalState();
		this.energy = 100;
		this.stateChangedListeners = new ArrayList<StateChangedListener>();
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
	public void controlar(Ambiente ambiente) throws Exception {
		double temperatura = ambiente.getTemperatura();
		double delta = temperatura - this.setPoint;  
		
	    this.historico.add(temperatura);
	    this.diferenca.add(Math.abs(delta));
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
	


	@Override
	public void ligar() throws Exception {
		ControladorState atual = this.estado;
		this.estado = this.estado.ligar();
		this.fireStateChangedNotify(atual.quemSouEu(), this.estado.quemSouEu());
	}	

}
