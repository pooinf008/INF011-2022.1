package br.ifba.inf011.estrut.flyweight.report.nofly;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.ifba.inf011.estrut.flyweight.report.CategoriaDicionario;
import br.ifba.inf011.estrut.flyweight.report.CategoriaServico;
import br.ifba.inf011.estrut.flyweight.report.RelatorioIF;
import br.ifba.inf011.estrut.flyweight.servico.ClienteProxy;
import br.ifba.inf011.estrut.flyweight.servico.ClienteServico;
import br.ifba.inf011.estrut.flyweight.servico.ServicoIF;

public class RelatorioNoFly implements RelatorioIF{
	
	private List<Linha> linhas;
	private CategoriaServico categoria;
	
	public RelatorioNoFly() {
		this.linhas = new ArrayList<Linha>();
		this.categoria = new CategoriaServico();
	}
	
	public void addLinha(double energia, double setpoint, double temperatura) {
		
		char chCategoria = this.categoria.getCategoria(energia, setpoint, temperatura);
		Date date = new Date();
		String descricao = CategoriaDicionario.getCategoriaDicionario().getDescricao(chCategoria);
		
		Linha linha = new Linha(this.linhas.size() + 1, 
								chCategoria, descricao,
								date, temperatura);
		this.linhas.add(linha);
	}
	
	public String gerar() {
		String rep = "RELATÓRIO DE EXECUÇÃO\n";
		for(Linha linha : this.linhas)
			rep += (linha.gerar() + "\n");
		rep += ("Total de Objetos: " + CategoriaDicionario.TOTAL_OBJETOS + "\n");
		return rep;
	}

}
