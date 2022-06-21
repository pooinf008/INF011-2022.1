package br.ifba.inf011.estrut.decorator.controlador;

import java.io.PrintStream;
import java.util.List;

import br.ifba.inf011.estrut.decorator.Sala;

public class DummyControle implements EstrategiaControle{

	@Override
	public double controlar(Sala ambiente, double ganho, double setPoint, List<Double> historico, 
						 List<Double> diferenca, PrintStream log)
			throws Exception {
		log.println("Dummy Controle - Atuação 0°");
		return 0.0001;
	}

}
