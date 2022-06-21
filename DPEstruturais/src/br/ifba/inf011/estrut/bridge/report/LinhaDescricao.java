package br.ifba.inf011.estrut.bridge.report;

import br.ifba.inf011.estrut.bridge.servico.ClienteServico;
import br.ifba.inf011.estrut.bridge.servico.ServicoIF;

public class LinhaDescricao extends AbstractDecoratorLinha implements Linha{

	public LinhaDescricao(Linha decorator) {
		super(decorator);
	}

	@Override
	public String content() {
		CategoriaServico categoria = new CategoriaServico();
		ServicoIF servico = new ClienteServico();
		char cat = categoria.getCategoria(this.getEnergia(), this.getSetpoint(), this.getTemperatura());
		String descricao;
		try {
			descricao = servico.ask(cat);
		} catch (Exception e) {
			descricao = "DESCONHECIDO";
		} 
		return this.decorator().content() + " " + descricao;
	}
}	