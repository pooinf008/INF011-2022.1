package br.ifba.inf011.estrut.flyweight.report;

public class CategoriaDicionario {
	
	private static CategoriaDicionario categoriaDicionario;
	public static int TOTAL_OBJETOS = 0;

	
	private CategoriaDicionario() {
		
	}
	
	public static CategoriaDicionario getCategoriaDicionario() {
		if(categoriaDicionario == null)
			categoriaDicionario = new CategoriaDicionario();
		return categoriaDicionario;
	}
	
	
	public String getDescricao(char chCategoria) {
		String descricao = null;
		CategoriaDicionario.TOTAL_OBJETOS++;
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
