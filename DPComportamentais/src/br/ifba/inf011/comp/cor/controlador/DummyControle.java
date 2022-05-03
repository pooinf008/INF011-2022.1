package br.ifba.inf011.comp.cor.controlador;

import java.io.PrintStream;
import java.util.List;

import br.ifba.inf011.comp.cor.Ambiente;

public class DummyControle implements EstrategiaControle{

	@Override
	public double controlar(Ambiente ambiente, double ganho, double setPoint, List<Double> historico, 
						 List<Double> diferenca, PrintStream log)
			throws Exception {
		log.println("Dummy Controle - Atuação 0°");
		return 0.0001;
	}

}
