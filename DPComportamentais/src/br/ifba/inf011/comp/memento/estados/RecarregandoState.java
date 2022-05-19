package br.ifba.inf011.comp.memento.estados;

import java.io.PrintStream;
import java.util.List;

import br.ifba.inf011.comp.memento.Ambiente;

public class RecarregandoState extends AbstractState implements ControladorState {

	@Override
	public ControladorState ligar() throws Exception {
		return new OperacionalState();
	}

	@Override
	public double controlar(Ambiente ambiente, double ganho, double setPoint, List<Double> historico,
			List<Double> diferenca, PrintStream log) throws Exception {
	    log.println("ESTADO RECARREGANDO");
	    return -0.05;	
	}

	@Override
	public TipoEstado quemSouEu() {
		return TipoEstado.Recarregando;
	}

}
