package br.ifba.inf011.estrut.proxy.servico;

public class CategoriaDicionario {
	
	public static String getDescricao(char chCategoria) {
		String descricao = "INDEFINIDO";
		switch(chCategoria) {
			case 'A' : descricao = "Situa��o �tima"; break;
			case 'B' : descricao = "Alerta Azul"; break;
			case 'C' : descricao = "Alerta Amarelo"; break;
			case 'D' : descricao = "Alerta Laranja"; break;
			case 'E' : descricao = "Alerta Vermelho"; break;
		}
		return descricao;
	}

}
