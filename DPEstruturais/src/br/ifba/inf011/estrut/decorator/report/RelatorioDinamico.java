package br.ifba.inf011.estrut.decorator.report;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.ifba.inf011.estrut.decorator.servico.ClienteServico;
import br.ifba.inf011.estrut.decorator.servico.ServicoIF;

public class RelatorioDinamico implements Relatorio{
	
	private List<Linha> linhas;
	
	public RelatorioDinamico() {
		this.linhas = new ArrayList<Linha>();
	}
	
	public void addLinha(double energia, double setpoint, double temperatura) {

		Linha linha = new LinhaDescricao(
						new LinhaCategoria(
							new LinhaId(this.linhas.size() + 1, 
													 energia,
													 setpoint,
													 temperatura)));
		this.linhas.add(linha);
	}
	
	public String content() {
		String rep = "RELATÓRIO DE EXECUÇÃO\n";
		for(Linha linha : this.linhas)
			rep += (linha.content() + "\n");
		return rep;
	}

}
