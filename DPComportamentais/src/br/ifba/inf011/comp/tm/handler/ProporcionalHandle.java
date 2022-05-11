package br.ifba.inf011.comp.tm.handler;

import java.io.PrintStream;
import java.util.List;

import br.ifba.inf011.comp.tm.Ambiente;

public class ProporcionalHandle extends AbstractHandle implements HandleControle{

	
	public ProporcionalHandle(HandleControle proximo) {
		super(proximo);
	}
	
	protected double getGastoEnergia() {
		return 0.02;
	}

	protected String getMensagem(double tempAtuacao) {
		return "Proporcional Controle - Atuação " + tempAtuacao + "°";
	}

	protected double getDeltaTemperatura(Ambiente ambiente, double ganho, double setPoint, List<Double> historico,
			List<Double> diferenca) {
		double delta = historico.get(historico.size() - 1) - setPoint;
		return delta;
	}

	protected double getTemperaturaAtuacao(Ambiente ambiente, double ganho, double setPoint, List<Double> historico,
			List<Double> diferenca) {
		double delta = historico.get(historico.size() - 1) - setPoint;
		double tempAtuacao = Math.abs(delta * ganho);
		return tempAtuacao;
	}

	protected boolean devoAtuar(Ambiente ambiente, double ganho, double setPoint, List<Double> historico,
			List<Double> diferenca) {
		double delta = historico.get(historico.size() - 1) - setPoint;
		
		return Math.abs(delta) > 0.1 * setPoint;
	}
}
