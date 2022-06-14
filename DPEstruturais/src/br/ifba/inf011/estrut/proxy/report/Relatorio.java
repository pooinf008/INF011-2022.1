package br.ifba.inf011.estrut.proxy.report;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.ifba.inf011.estrut.proxy.servico.ClienteProxy;
import br.ifba.inf011.estrut.proxy.servico.ClienteServico;
import br.ifba.inf011.estrut.proxy.servico.ServicoIF;

public class Relatorio {
	
	private List<Linha> linhas;
	private CategoriaServico categoria;
	private ServicoIF servico;
	
	public Relatorio() {
		this.linhas = new ArrayList<Linha>();
		this.categoria = new CategoriaServico();
//		this.servico = new ClienteServico();
		this.servico =  new ClienteProxy(new ClienteServico());		
		
	}
	
	public void addLinha(double energia, double setpoint, double temperatura) {
		
		char chCategoria = this.categoria.getCategoria(energia, setpoint, temperatura);
		String descricao;
		try {
			descricao = this.servico.ask(chCategoria);
		} catch (Exception e) {
			descricao = "ERRO-CONSULTA";
		}
		Date date = new Date();
		Linha linha = new Linha(this.linhas.size() + 1, 
								chCategoria, 
								descricao, date, temperatura);
		this.linhas.add(linha);
	}
	
	public String toString() {
		String rep = "RELATÓRIO DE EXECUÇÃO\n";
		for(Linha linha : this.linhas)
			rep += (linha + "\n");
		return rep;
	}

}
