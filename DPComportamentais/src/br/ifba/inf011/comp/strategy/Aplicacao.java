package br.ifba.inf011.comp.strategy;

import br.ifba.inf011.comp.strategy.controlador.ControladorGenerico;
import br.ifba.inf011.comp.strategy.controlador.TipoControlador;

public class Aplicacao {
	
	public void rodar() throws Exception{
		
		ControleIF controle = new ControladorGenerico(2, 30, System.out, TipoControlador.Integral);
		Ambiente ambiente = new Ambiente(27.0);
		int rodadas = 0;
		
		while(rodadas < 50000) {
			ambiente.randomizar();
			System.out.println(ambiente.getTemperatura());
			controle.controlar(ambiente);
//			Thread.sleep(100);
			rodadas++;
		}
		
		controle.printResumo(System.out);
	}

	
	
	public static void main(String[] args) throws Exception {
		(new Aplicacao()).rodar();
	}

}
