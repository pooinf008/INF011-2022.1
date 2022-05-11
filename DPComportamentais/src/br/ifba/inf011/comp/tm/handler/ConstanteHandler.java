package br.ifba.inf011.comp.tm.handler;

import java.util.List;

import br.ifba.inf011.comp.tm.Ambiente;

public class ConstanteHandler extends AbstractHandle implements HandleControle{

	public ConstanteHandler(HandleControle proximo) {
		super(proximo);
	}
	
	@Override
	protected double getGastoEnergia() throws Exception {
		return 0.01;
	}

	@Override
	protected String getMensagem(double tempAtuacao) throws Exception {
		return "Atuação contante de 1°";
	}

	@Override
	protected double getDeltaTemperatura(Ambiente ambiente, double ganho, double setPoint, List<Double> historico,
			List<Double> diferenca) throws Exception {
		return historico.get(historico.size() - 1) - setPoint;
	}

	@Override
	protected double getTemperaturaAtuacao(Ambiente ambiente, double ganho, double setPoint, List<Double> historico,
			List<Double> diferenca) throws Exception {
		return 1;
	}

	@Override
	protected boolean devoAtuar(Ambiente ambiente, double ganho, double setPoint, List<Double> historico,
			List<Double> diferenca) throws Exception {
		return true;
	}

}
