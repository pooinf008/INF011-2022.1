package br.ifba.inf011.comp.strategy.controlador;

import java.io.PrintStream;
import java.util.List;

import br.ifba.inf011.comp.strategy.Ambiente;

public class DummyControle implements EstrategiaControle{

	@Override
	public void controlar(Ambiente ambiente, double ganho, double setPoint, List<Double> historico, 
						 List<Double> diferenca, PrintStream log)
			throws Exception {
		log.println("Dummy Controle - Atuação 0°");
		return;
	}

}
