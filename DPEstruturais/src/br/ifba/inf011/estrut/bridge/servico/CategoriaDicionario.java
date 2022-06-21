package br.ifba.inf011.estrut.bridge.servico;

public class CategoriaDicionario {
	
	public static String getDescricao(char chCategoria) {
		String descricao = null;
		switch(chCategoria) {
			case 'A' : descricao = new String("Situação Ótima"); break;
			case 'B' : descricao = new String("Alerta Azul"); break;
			case 'C' : descricao = new String("Alerta Amarelo"); break;
			case 'D' : descricao = new String("Alerta Laranja"); break;
			case 'E' : descricao = new String("Alerta Vermelho"); break;
			default : new String("INDEFINIDO");
		}
		return descricao;
	}


}
