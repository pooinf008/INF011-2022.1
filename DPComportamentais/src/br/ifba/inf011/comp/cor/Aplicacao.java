package br.ifba.inf011.comp.cor;

import br.ifba.inf011.comp.cor.controlador.TipoControlador;

public class Aplicacao {
	
	public void rodar() throws Exception{
	
		
		ControleIF controle = new ControladorGenerico(3, 35.0, System.out);
		Ambiente ambiente = new Ambiente(27.0);
		int rodadas = 0;
		
		controle.setEstrategia(TipoControlador.Proporcional);
		
		while(controle.getEnergy() > 0) {
			
			if(rodadas % 2 == 0) {
				controle.setEstrategia(TipoControlador.Proporcional);
			}else {
				controle.setEstrategia(TipoControlador.Dummy);	
			}

			
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
