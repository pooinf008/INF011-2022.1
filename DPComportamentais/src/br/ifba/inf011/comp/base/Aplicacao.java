package br.ifba.inf011.comp.base;

public class Aplicacao {
	
	public void rodar() throws Exception{
		ControleIF controle = new ControladorGenerico(3, 30, System.out, TipoControlador.Dummy);
		Ambiente ambiente = new Ambiente(27.0);
		int rodadas = 0;
		
		while(rodadas < 500000) {
			ambiente.randomizar();
			System.out.println(ambiente.getTemperatura());
			controle.controlar(ambiente);
			rodadas++;
		}
		System.out.println("\n\n\tResumo");
		controle.printResumo(System.out);
	}
	
	public static void main(String[] args) throws Exception {
		(new Aplicacao()).rodar();
	}
}
