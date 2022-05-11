package br.ifba.inf011.comp.cor;

public class Aplicacao {
	
	public void rodar() throws Exception{
	
		
		ControleIF controle = new ControladorGenerico(3, 35.0, System.out);
		Ambiente ambiente = new Ambiente(27.0);
		
		
		while(controle.getEnergy() > 0) {
			
			ambiente.randomizar();
			System.out.println(ambiente.getTemperatura());
			controle.controlar(ambiente);
		}
		System.out.println("\n\n\tResumo");
		controle.printResumo(System.out);
	}

	
	
	public static void main(String[] args) throws Exception {
		(new Aplicacao()).rodar();
	}

}
