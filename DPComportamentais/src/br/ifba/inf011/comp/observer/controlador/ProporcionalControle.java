package br.ifba.inf011.comp.observer.controlador;

import java.io.PrintStream;
import java.util.List;

import br.ifba.inf011.comp.observer.Ambiente;

public class ProporcionalControle implements EstrategiaControle{

	@Override
	public double controlar(Ambiente ambiente, double ganho, double setPoint, List<Double> historico, 
			List<Double> diferenca, PrintStream log)
			throws Exception {
		
		double delta = historico.get(historico.size() - 1) - setPoint;
		double tempAtuacao = Math.abs(delta * ganho);
		
	    if(delta > 0) {
	    	ambiente.esfriar(tempAtuacao);
	    }	
	    else{
	    	ambiente.aquecer(tempAtuacao);
	    }
	    
	    log.println("Proporcional Controle - Atuação " + tempAtuacao + "°");
	    return 0.02;
	}

}
