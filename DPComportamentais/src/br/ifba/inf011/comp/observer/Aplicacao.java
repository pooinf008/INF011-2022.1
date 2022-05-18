package br.ifba.inf011.comp.observer;

import br.ifba.inf011.comp.observer.controlador.TipoControlador;
import br.ifba.inf011.comp.observer.subscriber.FileLogStateChanged;
import br.ifba.inf011.comp.observer.subscriber.SMSStateChanged;

public class Aplicacao {
	
	
	public void rodar2() throws Exception{
	
		
		FileLogStateChanged arq = new FileLogStateChanged("C:\\Users\\fredericojorge\\workspace\\log.txt");
		
		ControleIF controle = new ControladorGenerico(3, 35.0, System.err);
		Ambiente ambiente = new Ambiente(27.0);

		controle.addStateChangedListener(arq);
		
		for(int i = 0; i < 4; i++) {
			SMSStateChanged sms = new SMSStateChanged(i);
			controle.addStateChangedListener(sms);
			(new Thread()).start(); 
		}
		
		int i = 0;
		while(i < 1) {
			ambiente.randomizar();
			controle.controlar(ambiente);
			controle.desligar();
			controle.recarregar();
			controle.controlar(ambiente);
			controle.ligar();
			controle.ligar();
			controle.ligar();
			i++;
		}
		System.out.println("\n\n\tResumo");
		controle.printResumo(System.out);
	}
	
	

	public void rodar() throws Exception{
	
		
		ControleIF controle = new ControladorGenerico(3, 35.0, System.err);
		Ambiente ambiente = new Ambiente(27.0);
		
		for(int i = 0; i < 5; i++) {
			SMSStateChanged sms = new SMSStateChanged(i);
			controle.addStateChangedListener(sms);
			(new Thread()).start(); 
		}
		
		
		while(controle.getEnergy() > 0) {
			if(controle.getEnergy() > 50) {
				ambiente.randomizar();
				controle.controlar(ambiente);
			}else {
				controle.desligar();
				controle.recarregar();
				for(int i = 0; i < 50; i++)
					controle.controlar(ambiente);
				controle.ligar();
				controle.ligar();
				controle.ligar();
			}
		}
		System.out.println("\n\n\tResumo");
		controle.printResumo(System.out);
	}

	
	
	public static void main(String[] args) throws Exception {
		(new Aplicacao()).rodar2();
	}

}
