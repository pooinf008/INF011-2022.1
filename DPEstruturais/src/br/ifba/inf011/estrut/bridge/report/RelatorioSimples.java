package br.ifba.inf011.estrut.bridge.report;

import java.util.ArrayList;
import java.util.List;

import br.ifba.inf011.estrut.decorator.report.Linha;
import br.ifba.inf011.estrut.decorator.report.LinhaFull;

public class RelatorioSimples{
	
	protected LoggerRelatorio logger;
	protected List<Linha> linhas;

	
	public RelatorioSimples(LoggerRelatorio logger) {
		this.logger = logger;
		this.linhas = new ArrayList<Linha>();
	}
	
	public void makeReport() {
		this.logger.open();
		this.logger.doHeader("Relatorio Simples");
		for(Linha linha : this.linhas)
			this.logger.doLog(linha.content());
		this.logger.doTail();
		this.logger.close();
	}
	

	public void addLinha(double energia, double setpoint, double temperatura) {
		LinhaFull linha = new LinhaFull(this.linhas.size() + 1, 
										 energia, 
										 setpoint, 
										 temperatura);
		this.linhas.add(linha);
	}

}
