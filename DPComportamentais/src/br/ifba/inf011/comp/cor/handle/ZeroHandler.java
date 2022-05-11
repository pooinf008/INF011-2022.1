package br.ifba.inf011.comp.cor.handle;

import java.io.PrintStream;
import java.util.List;

import br.ifba.inf011.comp.cor.Ambiente;

public class ZeroHandler extends AbstractControleHandler{

	public ZeroHandler() {
	}
	
	@Override
	public double controlar(Ambiente ambiente, double ganho, double setPoint, List<Double> historico,
			List<Double> diferenca, PrintStream log) throws Exception {
		log.println("ZERO");
		return 0.001;
	}
	
	
	
	

}
