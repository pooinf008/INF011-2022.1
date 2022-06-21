package br.ifba.inf011.estrut.decorator.report;

import java.io.IOException;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.ifba.inf011.estrut.decorator.servico.ClienteServico;
import br.ifba.inf011.estrut.decorator.servico.ServicoIF;
import br.ifba.inf011.estrut.decorator.report.Linha;
import br.ifba.inf011.estrut.decorator.report.LinhaFull;
import br.ifba.inf011.estrut.decorator.report.Relatorio;


public class RelatorioEstatico implements Relatorio{
	
	private List<Linha> linhas;
	
	public RelatorioEstatico() {
		this.linhas = new ArrayList<Linha>();
	}
	
	public void addLinha(double energia, double setpoint, double temperatura) {
		LinhaFull linha = new LinhaFull(this.linhas.size() + 1, 
										energia, setpoint, temperatura);
		this.linhas.add(linha);
	}
	
	@Override
	public String content() {
		String rep = "RELATÓRIO DE EXECUÇÃO\n";
		for(Linha linha : this.linhas)
			rep += (linha.content() + "\n");
		return rep;
	}

}
