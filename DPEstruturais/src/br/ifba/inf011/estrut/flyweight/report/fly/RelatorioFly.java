package br.ifba.inf011.estrut.flyweight.report.fly;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.ifba.inf011.estrut.flyweight.report.CategoriaDicionario;
import br.ifba.inf011.estrut.flyweight.report.CategoriaServico;
import br.ifba.inf011.estrut.flyweight.report.RelatorioIF;

public class RelatorioFly implements RelatorioIF{
	
	private List<LinhaUnsharedFlyweight> linhas;
	private CategoriaServico categoria;
	private LinhaFlyweightFactory linhaFactory;
	
	public RelatorioFly() {
		this.linhas = new ArrayList<LinhaUnsharedFlyweight>();
		this.categoria = new CategoriaServico();
		this.linhaFactory = new LinhaFlyweightFactory();
	}
	
	public void addLinha(double energia, double setpoint, double temperatura) {
		
		char chCategoria = this.categoria.getCategoria(energia, setpoint, temperatura);
		Date date = new Date();
		LinhaUnsharedFlyweight linha = new LinhaUnsharedFlyweight(this.linhas.size() + 1, 
										this.linhaFactory.getLinhaSharedFlyweight(chCategoria),
										date, temperatura);
		this.linhas.add(linha);
	}
	
	public String gerar() {
		String rep = "RELATÓRIO DE EXECUÇÃO\n";
		for(LinhaUnsharedFlyweight linha : this.linhas)
			rep += (linha.gerar() + "\n");
		rep += ("Total de Objetos: " + CategoriaDicionario.TOTAL_OBJETOS + "\n");
		return rep;
	}

}
