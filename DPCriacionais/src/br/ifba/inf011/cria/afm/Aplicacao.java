package br.ifba.inf011.cria.afm;


import br.ifba.inf011.cria.afm.atuadores.AtuadorIF;
import br.ifba.inf011.cria.afm.controle.ControleFactory;
import br.ifba.inf011.cria.afm.controle.ControleIF;
import br.ifba.inf011.cria.afm.controle.TipoControle;
import br.ifba.inf011.cria.afm.termometros.TermometroIF;

public class Aplicacao {
	
	public void rodar() throws Exception{
		Ambiente ambiente = new Ambiente();
		
		ControleIF controlador = ControleFactory.getFactory(TipoControle.FAIXA, 27, 29).getControle();
		
		AtuadorIF atuador = controlador.getAtuador();
		TermometroIF termometro = controlador.getTermometro();
		
		while(true) {
			termometro.lerTemperatura(ambiente);
			atuador.modificar(ambiente);
			ambiente.randomizar();
			Thread.sleep(100);
		}
		
	}

	
	
	public static void main(String[] args) throws Exception {
		(new Aplicacao()).rodar();
	}

}
