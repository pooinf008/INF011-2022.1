package br.ifba.inf011.estrut.bridge.report;

import java.util.HashMap;

import br.ifba.inf011.estrut.decorator.report.CategoriaServico;
import br.ifba.inf011.estrut.decorator.report.Linha;

public class RelatorioDigest extends RelatorioSimples{

	public RelatorioDigest(LoggerRelatorio logger) {
		super(logger);
	}
	
	public void makeReport() {
		HashMap<Character, Integer> categorias = new HashMap<Character, Integer>();
		CategoriaServico categoria = new CategoriaServico();
		Character cat; 
		this.logger.open();
		this.logger.doHeader("Relatorio Digest");
		for(Linha linha : this.linhas) { 
			cat = categoria.getCategoria(linha.getEnergia(),
										 linha.getSetpoint(), 
										 linha.getTemperatura());
			Integer qtde = categorias.get(cat);
			if(qtde == null)
				qtde = Integer.valueOf(0);
			qtde = qtde + 1;
			categorias.put(cat, qtde);
		}
		for(Character chCategoria : categorias.keySet())
			this.logger.doLog(chCategoria + ": " + categorias.get(chCategoria));
		this.logger.doTail();
		this.logger.close();
	}
	

}
