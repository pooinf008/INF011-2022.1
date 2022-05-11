package br.ifba.inf011.comp.tm.handler;

import java.io.PrintStream;
import java.util.List;

import br.ifba.inf011.comp.tm.Ambiente;

public class DummyHandler implements HandleControle{

	@Override
	public double controlar(Ambiente ambiente, double ganho, double setPoint, List<Double> historico, 
						 List<Double> diferenca, PrintStream log)
			throws Exception {
		log.println("Dummy Controle - Atuação 0°");
		return 0.0001;
	}

	@Override
	public void setProximo(HandleControle proximo) {
	}

}
