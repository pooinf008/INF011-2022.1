package br.ifba.inf011.comp.state;

import br.ifba.inf011.comp.state.controlador.TipoControlador;

public class Aplicacao {
	
	public void rodar() throws Exception{
	
		
		ControleIF controle = new ControladorGenerico(3, 35.0, System.out);
		Ambiente ambiente = new Ambiente(27.0);
		
		while(controle.getEnergy() > 0) {
			if(controle.getEnergy() > 50) {
				ambiente.randomizar();
				System.out.println(ambiente.getTemperatura());
				controle.controlar(ambiente);
			}else {
				controle.desligar();
				controle.recarregar();
				for(int i = 0; i < 50; i++)
					controle.controlar(ambiente);
				controle.ligar();
			}
		}
		System.out.println("\n\n\tResumo");
		controle.printResumo(System.out);
	}

	
	
	public static void main(String[] args) throws Exception {
		(new Aplicacao()).rodar();
	}

}
