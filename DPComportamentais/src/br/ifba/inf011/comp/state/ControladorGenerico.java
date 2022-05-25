package br.ifba.inf011.comp.state;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import br.ifba.inf011.comp.state.estados.ControladorState;
import br.ifba.inf011.comp.state.estados.OperacionalState;
import br.ifba.inf011.comp.state.util.Estatistica;

public class ControladorGenerico implements ControleIF{
	
	
	public class Snapshot{
		private ControladorState estado;
		private List<Double> historico;
		private List<Double> diferenca;
		
		private Snapshot(ControladorState estado, List<Double> historico, List<Double> diferenca) {
			this.estado = estado;
			this.historico = new ArrayList<Double>(historico);
			this.diferenca = new ArrayList<Double>(diferenca);
		}
		
		private List<Double> getHistorico(){
			return this.historico;
		}
		
		private List<Double> getDiferenca(){
			return this.diferenca;
		}
		
		private ControladorState getEstado() {
			return this.estado;
		}
		
		public int getId() {
			return this.historico.size();
		}
		
		
	}
	
	public static final int HISTORICO_INTEGRAL = 5;
	
	private double setPoint;
	private double ganho;
	private List<Double> historico;
	private List<Double> diferenca;
	private PrintStream log;
	private ControladorState estado;
	private double energy;	
	
	
	public ControladorGenerico(double ganho, double setPoint, PrintStream log) {
		this.setPoint = setPoint;
		this.ganho = ganho;
		this.historico = new ArrayList<Double>();
		this.diferenca = new ArrayList<Double>();
		this.log = log;
		this.estado = new OperacionalState();
		this.energy = 100;
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
		this.estado = this.estado.salvarEnergia();
	}


	@Override
	public void desligar() throws Exception {
		this.estado = this.estado.desligar();
	}


	@Override
	public void recarregar() throws Exception {
		this.estado = this.estado.recarregar();
	}


	@Override
	public void ligar() throws Exception {
		this.estado = this.estado.ligar();
	}


	@Override
	public Snapshot checkpoint() throws Exception {
		return new Snapshot(this.estado, this.historico, this.diferenca);
	}


	@Override
	public void restore(Snapshot snapshot) throws Exception {
		this.diferenca = snapshot.getDiferenca();
		this.historico = snapshot.getHistorico();
		this.estado = snapshot.getEstado(); 
	}


	@Override
	public SnapshotIF checkpoint2IF() throws Exception {
		return new ConcreteSnapshot(this.estado, this.historico, this.diferenca);
	}


	@Override
	public void restoreFromIF(SnapshotIF snapshotif) throws Exception {
		ConcreteSnapshot snapshot = (ConcreteSnapshot) snapshotif;
		this.diferenca = snapshot.getDiferenca();
		this.historico = snapshot.getHistorico();
		this.estado = snapshot.getEstado(); 
	}	

}
