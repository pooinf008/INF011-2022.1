package br.ifba.inf011.estrut.bridge.servico;

public class ClienteServico implements ServicoIF{

	public String ask(char categoria) {
		return CategoriaDicionario.getDescricao(categoria);
	}

	
}
