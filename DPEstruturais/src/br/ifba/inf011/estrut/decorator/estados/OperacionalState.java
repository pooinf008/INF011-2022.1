package br.ifba.inf011.estrut.decorator.estados;

import java.io.PrintStream;
import java.util.List;

import br.ifba.inf011.estrut.decorator.Sala;
import br.ifba.inf011.estrut.decorator.AmbienteIF;

public class OperacionalState extends AbstractState implements ControladorState {

	@Override
	public double controlar(AmbienteIF ambiente, double ganho, double setPoint, List<Double> historico,
			List<Double> diferenca, PrintStream log) throws Exception {
		double delta = historico.get(historico.size() - 1) - setPoint;
		double tempAtuacao = Math.abs(delta * ganho);
		
	    if(delta > 0) {
	    	ambiente.esfriar(tempAtuacao);
	    }	
	    else{
	    	ambiente.aquecer(tempAtuacao);
	    }
	    
	    log.println("MODO OPERACIONAL - Atuação " + tempAtuacao + "°");
	    return 0.02;
	}
	
	@Override
	public ControladorState salvarEnergia() throws Exception {
		return new ModoEconomicoState();
	}
	
	@Override
	public ControladorState desligar() throws Exception {
		return new DesligadoState();
	}

	@Override
	public TipoEstado quemSouEu() {
		return TipoEstado.Operacional;
	}
	
	

}
