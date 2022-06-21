package br.ifba.inf011.estrut.bridge;

import java.util.ArrayList;
import java.util.List;

public class SalaComposite implements AmbienteIF{

	private List<AmbienteIF> ambientes; 
	
	
	public SalaComposite() {
		this.ambientes = new ArrayList<AmbienteIF>();
	}
	
	public void addAmbientes(AmbienteIF ambiente) {
		this.ambientes.add(ambiente);
	}
	
	@Override
	public double getTemperatura() {
		double tempMedia = 0;
		for(AmbienteIF ambiente : this.ambientes)
			tempMedia += ambiente.getTemperatura();
		return tempMedia / this.ambientes.size();
	}

	@Override
	public void randomizar() {
		for(AmbienteIF ambiente : this.ambientes)
			ambiente.randomizar();
		
	}

	@Override
	public void aquecer(double tempAtuacao) {
		for(AmbienteIF ambiente : this.ambientes)
			ambiente.aquecer(tempAtuacao);
	}

	@Override
	public void esfriar(double tempAtuacao) {
		for(AmbienteIF ambiente : this.ambientes)
			ambiente.esfriar(tempAtuacao);
	}

}
