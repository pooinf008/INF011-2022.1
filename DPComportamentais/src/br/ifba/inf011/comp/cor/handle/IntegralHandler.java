package br.ifba.inf011.comp.cor.handle;

import java.io.PrintStream;
import java.util.List;

import br.ifba.inf011.comp.cor.Ambiente;
import br.ifba.inf011.comp.cor.ControladorGenerico;

public class IntegralHandler extends AbstractControleHandler{

	public IntegralHandler(ControleHandler handler) {
		super(handler);
	}
	
	@Override
	public double controlar(Ambiente ambiente, double ganho, double setPoint, List<Double> historico,
			List<Double> diferenca, PrintStream log) throws Exception {
		double temp = historico.get(historico.size() - 1);
		int qtdeAtuacao = (historico.size() > ControladorGenerico.HISTORICO_INTEGRAL) ?
			  	  ControladorGenerico.HISTORICO_INTEGRAL : historico.size();
		double deltaHistorico = 0;
		for(int i = historico.size() - 1, j = 0; j < qtdeAtuacao; i--, j++)
			deltaHistorico =  (historico.get(historico.size() - 1) - setPoint) + deltaHistorico;
		
		deltaHistorico = deltaHistorico / qtdeAtuacao;
		
		if(Math.abs(deltaHistorico) > 0.05 * setPoint) {

			double tempAtuacao = Math.abs(deltaHistorico * ganho);
			
		    if(temp > setPoint) {
		    	ambiente.esfriar(tempAtuacao);
		    }	
		    else{
		    	ambiente.aquecer(tempAtuacao);
		    }
		    
		    log.println("INTEGRAL");
		    return 0.15;

		}
		return this.proximo.controlar(ambiente, ganho, setPoint, historico, diferenca, log);
	}
	
	
	
	

}
