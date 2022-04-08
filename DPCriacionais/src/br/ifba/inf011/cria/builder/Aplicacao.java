package br.ifba.inf011.cria.builder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.ifba.inf011.cria.builder.controle.Builder;
import br.ifba.inf011.cria.builder.controle.ControleBuilder;
import br.ifba.inf011.cria.builder.controle.ControleIF;
import br.ifba.inf011.cria.builder.controle.Diretor;


public class Aplicacao {
	
	public void rodar() throws Exception{
		
		
		Ambiente ambiente = new Ambiente();
		
		Builder builder = new ControleBuilder(); 
		Diretor diretor = new Diretor(builder);
		diretor.makeControleAlta(28, System.out, System.err);
		ControleIF controlador = builder.getControle();
		
		while(true) {
			controlador.lerTemperatura(ambiente);
			controlador.modificar(ambiente);
			ambiente.randomizar();
			Thread.sleep(100);
		}
		
	}

	
	
	public static void main(String[] args) throws Exception {
		(new Aplicacao()).rodar();
	}

}
