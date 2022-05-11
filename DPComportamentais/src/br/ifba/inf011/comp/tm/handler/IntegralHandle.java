package br.ifba.inf011.comp.tm.handler;

import java.io.PrintStream;
import java.util.List;

import br.ifba.inf011.comp.tm.Ambiente;
import br.ifba.inf011.comp.tm.ControladorGenerico;

public class IntegralHandle extends AbstractHandle implements HandleControle{


	public IntegralHandle(HandleControle proximo) {
		super(proximo);
	}	

	@Override
	protected double getGastoEnergia() throws Exception {
		return 0.05;
	}

	@Override
	protected String getMensagem(double tempAtuacao) throws Exception {
		return "Integral Controle - Atuação " + tempAtuacao + "°";
	}

	@Override
	protected double getDeltaTemperatura(Ambiente ambiente, double ganho, double setPoint, List<Double> historico,
			List<Double> diferenca) throws Exception {
		int qtdeAtuacao = (historico.size() > ControladorGenerico.HISTORICO_INTEGRAL) ?
					  	  ControladorGenerico.HISTORICO_INTEGRAL : historico.size();
		double deltaHistorico = 0;
		for(int i = historico.size() - 1, j = 0; j < qtdeAtuacao; i--, j++)
			deltaHistorico =  (historico.get(historico.size() - 1) - setPoint) + deltaHistorico;
		
		deltaHistorico = deltaHistorico / qtdeAtuacao;

		return deltaHistorico;
	}

	@Override
	protected double getTemperaturaAtuacao(Ambiente ambiente, double ganho, double setPoint, List<Double> historico,
			List<Double> diferenca) throws Exception {
		int qtdeAtuacao = (historico.size() > ControladorGenerico.HISTORICO_INTEGRAL) ?
			  	  ControladorGenerico.HISTORICO_INTEGRAL : historico.size();
		double deltaHistorico = 0;
		for(int i = historico.size() - 1, j = 0; j < qtdeAtuacao; i--, j++)
			deltaHistorico =  (historico.get(historico.size() - 1) - setPoint) + deltaHistorico;

		deltaHistorico = deltaHistorico / qtdeAtuacao;
		double tempAtuacao = Math.abs(deltaHistorico * ganho);
		return tempAtuacao;
	}

	@Override
	protected boolean devoAtuar(Ambiente ambiente, double ganho, double setPoint, List<Double> historico,
			List<Double> diferenca) throws Exception {
		double deltaHistorico = this.getDeltaTemperatura(ambiente, ganho, setPoint, historico, diferenca);
		return Math.abs(deltaHistorico) > 0.05 * setPoint;
	}
	

}
