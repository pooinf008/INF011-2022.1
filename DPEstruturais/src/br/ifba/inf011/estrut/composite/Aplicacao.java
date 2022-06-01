package br.ifba.inf011.estrut.composite;

import br.ifba.inf011.estrut.composite.adapter.LoggerAdapter;
import br.ifba.inf011.estrut.composite.adapter.LoggerStateChanged;
import br.ifba.inf011.estrut.composite.controlador.TipoControlador;
import br.ifba.inf011.estrut.composite.subscriber.FileLogStateChanged;
import br.ifba.inf011.estrut.composite.subscriber.SMSStateChanged;

public class Aplicacao {
	
	
	public void rodar2() throws Exception{
	
		
		LoggerStateChanged arq = new LoggerStateChanged("C:\\Users\\fredericojorge\\workspace\\log.txt");
		LoggerAdapter adapter = new LoggerAdapter(arq);
		
		
		ControleIF controle = new ControladorGenerico(3, 35.0, System.err);
		AmbienteIF ambiente = this.criarAmbiente();
//		AmbienteIF ambiente = new Sala(27);		

		controle.addStateChangedListener(adapter);
		
		int i = 0;
		while(i < 10) {
			ambiente.randomizar();
			controle.controlar(ambiente);
			i++;
		}
		System.out.println("\n\n\tResumo");
		controle.printResumo(System.out);
	}
	
	

	public void rodar() throws Exception{
	
		
		ControleIF controle = new ControladorGenerico(3, 35.0, System.err);
		Sala ambiente = new Sala(27.0);
		
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
	
	public AmbienteIF criarAmbiente() {
		double temp = 27;
		SalaComposite sala1 = new SalaComposite();
		sala1.addAmbientes(new Sala(temp));

		SalaComposite sala11 = new SalaComposite();
		sala11.addAmbientes(new Sala(temp));
		
		SalaComposite sala12 = new SalaComposite();
		
		SalaComposite sala121 = new SalaComposite();
		SalaComposite sala122 = new SalaComposite();
		
		sala121.addAmbientes(new Sala(temp));
		sala121.addAmbientes(new Sala(temp));
		
		sala122.addAmbientes(new Sala(temp));
		
		sala12.addAmbientes(sala121);
		sala12.addAmbientes(sala122);
		
		sala1.addAmbientes(sala11);
		sala1.addAmbientes(sala12);
		
		return sala1;
		
	}

	
	
	public static void main(String[] args) throws Exception {
		(new Aplicacao()).rodar2();
	}

}
