package br.ifba.inf011.cria.afm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.ifba.inf011.cria.afm.atuadores.AtuadorFactory;
import br.ifba.inf011.cria.afm.atuadores.AtuadorIF;
import br.ifba.inf011.cria.afm.atuadores.Estabilizador;
import br.ifba.inf011.cria.afm.atuadores.Resfriador;
import br.ifba.inf011.cria.afm.atuadores.TipoAtuador;
import br.ifba.inf011.cria.afm.termometros.TermometroAlta;
import br.ifba.inf011.cria.afm.termometros.TermometroAltaFactory;
import br.ifba.inf011.cria.afm.termometros.TermometroBasico;
import br.ifba.inf011.cria.afm.termometros.TermometroBasicoFactory;
import br.ifba.inf011.cria.afm.termometros.TermometroFactory;
import br.ifba.inf011.cria.afm.termometros.TermometroIF;
import br.ifba.inf011.cria.afm.termometros.TipoTermometro;

public class Aplicacao {
	
	public void rodar() throws InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Ambiente ambiente = new Ambiente();
		
		AtuadorIF atuador = AtuadorFactory
							.getFactory(TipoAtuador.RESFRIADOR, 24, 28)
							.getAtuador();
		TermometroIF termometro  = TermometroFactory
								   .getFactory(TipoTermometro.ALTA, 24, 28)
								   .getTermometro();
		
		while(true) {
			termometro.lerTemperatura(ambiente);
			atuador.modificar(ambiente);
			ambiente.randomizar();
			Thread.sleep(100);
		}
		
	}

	
	
	public static void main(String[] args) throws InstantiationException, InterruptedException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		(new Aplicacao()).rodar();
	}

}
