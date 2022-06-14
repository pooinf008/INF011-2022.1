package br.ifba.inf011.estrut.proxy;

import br.ifba.inf011.estrut.proxy.adapter.LoggerAdapter;
import br.ifba.inf011.estrut.proxy.adapter.LoggerStateChanged;
import br.ifba.inf011.estrut.proxy.controlador.TipoControlador;
import br.ifba.inf011.estrut.proxy.report.CategoriaServico;
import br.ifba.inf011.estrut.proxy.servico.ClienteServico;
import br.ifba.inf011.estrut.proxy.subscriber.FileLogStateChanged;
import br.ifba.inf011.estrut.proxy.subscriber.SMSStateChanged;

public class Aplicacao {
	
	
	public void rodar2() throws Exception{
		
		LoggerStateChanged arq = new LoggerStateChanged("C:\\Users\\fredericojorge\\workspace\\log.txt");
		LoggerAdapter adapter = new LoggerAdapter(arq);
		ClienteServico cliente = new ClienteServico();	
		CategoriaServico categoria = new CategoriaServico();
		ControleIF controle = new ControladorGenerico(3, 35.0, System.err);
		AmbienteIF ambiente = this.criarAmbiente();

		controle.addStateChangedListener(adapter);
		
		int i = 0;
		while(i < 10) {
			
			char chCategoria = categoria.getCategoria(controle.getEnergy(), ambiente.getTemperatura(), 35.0);
			System.out.println(cliente.ask(chCategoria));
			ambiente.randomizar();
			controle.controlar(ambiente);
			i++;
		}
		System.out.println("\n\n\tResumo");
		controle.printResumo(System.out);
	}
	
	

	public void rodar() throws Exception{
	
		int i = 0;
		
		ControleIF controle = new ControladorGenerico(3, 35.0, System.err);
		Sala ambiente = new Sala(27.0);
		
		while(controle.getEnergy() > 0 && i < 100) {
			ambiente.randomizar();
			controle.controlar(ambiente);
			i++;
			Thread.sleep(10);
		}
		
		System.out.println("\n\n\tRELATÓRIO");
		System.out.println(controle.getRelatorio());
		
		
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
		(new Aplicacao()).rodar();
	}

}
