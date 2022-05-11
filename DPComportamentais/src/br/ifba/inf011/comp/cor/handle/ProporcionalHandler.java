package br.ifba.inf011.comp.cor.handle;

import java.io.PrintStream;
import java.util.List;

import br.ifba.inf011.comp.cor.Ambiente;

public class ProporcionalHandler extends AbstractControleHandler{

	public ProporcionalHandler(ControleHandler proximo) {
		super(proximo);
	}
	
	@Override
	public double controlar(Ambiente ambiente, double ganho, double setPoint, List<Double> historico,
			List<Double> diferenca, PrintStream log) throws Exception {
		double delta = historico.get(historico.size() - 1) - setPoint;
		if(Math.abs(delta) > 0.1 * setPoint) {
			double tempAtuacao = Math.abs(delta * ganho);
			
		    if(delta > 0) {
		    	ambiente.esfriar(tempAtuacao);
		    }	
		    else{
		    	ambiente.aquecer(tempAtuacao);
		    }
			log.println("PROPORCIONAL");
			return 0.1;		    
		}
		return this.proximo.controlar(ambiente, ganho, setPoint, historico, diferenca, log);
	}
	
	
	
	

}
