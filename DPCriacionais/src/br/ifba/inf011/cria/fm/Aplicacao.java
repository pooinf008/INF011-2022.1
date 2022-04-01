package br.ifba.inf011.cria.fm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.ifba.inf011.cria.fm.termometros.TermometroAlta;
import br.ifba.inf011.cria.fm.termometros.TermometroAltaFactory;
import br.ifba.inf011.cria.fm.termometros.TermometroBasico;
import br.ifba.inf011.cria.fm.termometros.TermometroBasicoFactory;
import br.ifba.inf011.cria.fm.termometros.TermometroFactory;
import br.ifba.inf011.cria.fm.termometros.TermometroIF;
import br.ifba.inf011.cria.fm.termometros.TipoTermometro;

public class Aplicacao {
	
	public void rodar() throws InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Ambiente ambiente = new Ambiente();
		TermometroFactory factory = TermometroFactory.getFactory(TipoTermometro.FAIXA, 20, 30);
		TermometroIF termometro  = factory.getTermometro();
		while(true) {
			termometro.lerTemperatura(ambiente);
			ambiente.randomizar();
			Thread.sleep(100);
		}
		
	}

	
	
	public static void main(String[] args) throws InstantiationException, InterruptedException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		(new Aplicacao()).rodar();
	}

}
