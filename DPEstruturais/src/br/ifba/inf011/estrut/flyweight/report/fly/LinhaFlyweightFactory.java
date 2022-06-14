package br.ifba.inf011.estrut.flyweight.report.fly;

import java.util.HashMap;
import java.util.Map;

import br.ifba.inf011.estrut.flyweight.report.CategoriaDicionario;

public class LinhaFlyweightFactory {
	
	private Map<Character, LinhaSharedFlyweight> linhasSharedFlyweights;
	
	public LinhaFlyweightFactory() {
		this.linhasSharedFlyweights = new HashMap<Character, LinhaSharedFlyweight>();
	}
	
	public LinhaSharedFlyweight getLinhaSharedFlyweight(char c) {
		LinhaSharedFlyweight linhaShared = this.linhasSharedFlyweights.get(c);
		if(linhaShared == null)
			linhaShared = new LinhaSharedFlyweight(c, CategoriaDicionario.getCategoriaDicionario().getDescricao(c));
		this.linhasSharedFlyweights.put(linhaShared.getSimbolo(), linhaShared);
		return linhaShared;
	}

}
