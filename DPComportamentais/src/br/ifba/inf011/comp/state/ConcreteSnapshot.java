package br.ifba.inf011.comp.state;

import java.util.ArrayList;
import java.util.List;

import br.ifba.inf011.comp.state.estados.ControladorState;

public class ConcreteSnapshot implements SnapshotIF{

	private ControladorState estado;
	private List<Double> historico;
	private List<Double> diferenca;
	
	public ConcreteSnapshot(ControladorState estado, List<Double> historico, List<Double> diferenca) {
		this.estado = estado;
		this.historico = new ArrayList<Double>(historico);
		this.diferenca = new ArrayList<Double>(diferenca);
	}
	
	public List<Double> getHistorico(){
		return this.historico;
	}
	
	public List<Double> getDiferenca(){
		return this.diferenca;
	}
	
	public ControladorState getEstado() {
		return this.estado;
	}
	
	public int getId() {
		return this.historico.size();
	}


}
