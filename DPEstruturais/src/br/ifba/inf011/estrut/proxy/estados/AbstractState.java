package br.ifba.inf011.estrut.proxy.estados;

import java.io.PrintStream;
import java.util.List;

import br.ifba.inf011.estrut.proxy.Sala;
import br.ifba.inf011.estrut.proxy.AmbienteIF;

public abstract class AbstractState implements ControladorState {

	@Override
	public ControladorState salvarEnergia() throws Exception {
		return this;
	}

	@Override
	public ControladorState desligar() throws Exception {
		return this;
	}

	@Override
	public ControladorState recarregar() throws Exception {
		return this;
	}

	@Override
	public ControladorState ligar() throws Exception {
		return this;		
	}

	@Override
	public abstract double controlar(AmbienteIF ambiente, double ganho, double setPoint, List<Double> historico,
			List<Double> diferenca, PrintStream log) throws Exception;

}
