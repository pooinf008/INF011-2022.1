package br.ifba.inf011.comp.tm.handler;

import java.io.PrintStream;
import java.util.List;

import br.ifba.inf011.comp.tm.Ambiente;

public abstract class AbstractHandle implements HandleControle{

	private HandleControle proximo;
	
	public AbstractHandle(HandleControle proximo) {
		this.proximo = proximo;
	}
	
	@Override
	public double controlar(Ambiente ambiente, double ganho, double setPoint, List<Double> historico, 
			List<Double> diferenca, PrintStream log)
			throws Exception {
		
		if(!devoAtuar(ambiente, ganho, setPoint, historico, 
				diferenca))
			return this.proximo.controlar(ambiente, ganho, setPoint, historico, diferenca, log);
		
		double tempAtuacao = this.getTemperaturaAtuacao(ambiente, ganho, setPoint, historico, diferenca);
		double delta = this.getDeltaTemperatura(ambiente, ganho, setPoint, historico, diferenca);
		
	    if(delta > 0) {
	    	ambiente.esfriar(tempAtuacao);
	    }	
	    else{
	    	ambiente.aquecer(tempAtuacao);
	    }
	    
	    log.println(this.getMensagem(tempAtuacao));
	    return this.getGastoEnergia();
	}

	protected abstract double getGastoEnergia() throws Exception;

	protected abstract String getMensagem(double tempAtuacao) throws Exception;

	protected abstract double getDeltaTemperatura(Ambiente ambiente, double ganho, double setPoint, List<Double> historico,
			List<Double> diferenca) throws Exception;

	protected abstract double getTemperaturaAtuacao(Ambiente ambiente, double ganho, double setPoint, List<Double> historico,
			List<Double> diferenca) throws Exception;

	protected abstract boolean devoAtuar(Ambiente ambiente, double ganho, double setPoint, List<Double> historico,
			List<Double> diferenca) throws Exception;

	@Override
	public void setProximo(HandleControle proximo) {
		this.proximo = proximo;
	}

}
