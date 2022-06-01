package br.ifba.inf011.estrut.composite.estados;

import java.io.PrintStream;
import java.util.List;

import br.ifba.inf011.estrut.composite.Sala;
import br.ifba.inf011.estrut.composite.AmbienteIF;

public class ModoEconomicoState extends AbstractState implements ControladorState {

	@Override
	public ControladorState desligar() throws Exception {
		return new DesligadoState();
	}

	@Override
	public double controlar(AmbienteIF ambiente, double ganho, double setPoint, List<Double> historico,
			List<Double> diferenca, PrintStream log) throws Exception {
		
		
		int rodada = historico.size();
		
		if(rodada % 2 == 0) {
		    log.println("ESTADO ECONOMICO INATIVO");
		    return 0.001;		
		}			
					
		
		double delta = historico.get(historico.size() - 1) - setPoint;
		double tempAtuacao = Math.abs(delta * ganho);
		
	    if(delta > 0) {
	    	ambiente.esfriar(tempAtuacao);
	    }	
	    else{
	    	ambiente.aquecer(tempAtuacao);
	    }
	    
	    log.println("ESTADO ECONOMICA ATIVO- Atuação " + tempAtuacao + "°");
	    return 0.02;		
		
	}

	@Override
	public TipoEstado quemSouEu() {
		return TipoEstado.ModoEconomico;
	}

}
