package br.ifba.inf011.estrut.composite.controlador;

import java.io.PrintStream;
import java.util.List;

import br.ifba.inf011.estrut.composite.Sala;
import br.ifba.inf011.estrut.composite.ControladorGenerico;

public class IntegralControle implements EstrategiaControle{

	@Override
	public double controlar(Sala ambiente, double ganho, double setPoint, List<Double> historico,
			List<Double> diferenca, PrintStream log) throws Exception {
		double temp = historico.get(historico.size() - 1);
		int qtdeAtuacao = (historico.size() > ControladorGenerico.HISTORICO_INTEGRAL) ?
					  	  ControladorGenerico.HISTORICO_INTEGRAL : historico.size();
		double deltaHistorico = 0;
		for(int i = historico.size() - 1, j = 0; j < qtdeAtuacao; i--, j++)
			deltaHistorico =  (historico.get(historico.size() - 1) - setPoint) + deltaHistorico;
		
		deltaHistorico = deltaHistorico / qtdeAtuacao;
		double tempAtuacao = Math.abs(deltaHistorico * ganho);
		
	    if(temp > setPoint) {
	    	ambiente.esfriar(tempAtuacao);
	    }	
	    else{
	    	ambiente.aquecer(tempAtuacao);
	    }
	    
	    log.println("Integral Controle - Atuação " + tempAtuacao + "°");
	    return 0.05;
	}

}
