package br.ifba.inf011.comp.observer.estados;

import java.io.PrintStream;
import java.util.List;

import br.ifba.inf011.comp.observer.Ambiente;

public class DesligadoState extends AbstractState implements ControladorState {

	@Override
	public ControladorState recarregar() throws Exception {
		return new RecarregandoState();
	}

	@Override
	public ControladorState ligar() throws Exception {
		return new OperacionalState();
	}

	@Override
	public double controlar(Ambiente ambiente, double ganho, double setPoint, List<Double> historico,
			List<Double> diferenca, PrintStream log) throws Exception {
	    log.println("ESTADO DESLIGADO");
	    return 0;		
	}

	@Override
	public TipoEstado quemSouEu() {
		return TipoEstado.Desligado;
	}

}
