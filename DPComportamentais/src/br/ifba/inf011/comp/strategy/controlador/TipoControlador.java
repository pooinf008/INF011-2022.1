package br.ifba.inf011.comp.strategy.controlador;

import java.io.PrintStream;
import java.util.List;

import br.ifba.inf011.comp.strategy.Ambiente;

public enum TipoControlador implements EstrategiaControle{
	Dummy{
		@Override
		public void controlar(Ambiente ambiente, double ganho, double setPoint, List<Double> historico,
				List<Double> diferenca, PrintStream log) throws Exception {
			log.println("DUMMY");
		}	
	}, 
	Proporcional{
		@Override
		public void controlar(Ambiente ambiente, double ganho, double setPoint, List<Double> historico,
				List<Double> diferenca, PrintStream log) throws Exception {
			double delta = historico.get(historico.size() - 1) - setPoint;
			double tempAtuacao = Math.abs(delta * ganho);
			
		    if(delta > 0) {
		    	ambiente.esfriar(tempAtuacao);
		    }	
		    else{
		    	ambiente.aquecer(tempAtuacao);
		    }
			log.println("PROPORCIONAL");
		}
	}, 
	Integral{
		@Override
		public void controlar(Ambiente ambiente, double ganho, double setPoint, List<Double> historico,
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
		    log.println("INTEGRAL");
		}
	
	};

}
