package br.ifba.inf011.estrut.proxy.servico;

import java.util.HashMap;
import java.util.Map;

public class ClienteProxy implements ServicoIF{
	
	private ServicoIF servico;
	private Map<Character, String> descricoes;
	
	
	public ClienteProxy(ServicoIF servico) {
		this.servico = servico;
		this.descricoes = new HashMap<Character, String>();
	}

	@Override
	public String ask(char categoria) throws Exception {
		
		String descricao = this.descricoes.get(categoria);
		if(descricao == null)
			descricao = this.servico.ask(categoria);
		this.descricoes.put(categoria, descricao);
		return descricao;
	}
	
	

}
