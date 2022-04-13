package br.ifba.inf011.cria.builder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.ifba.inf011.cria.builder.controle.Builder;
import br.ifba.inf011.cria.builder.controle.ControleBuilder;
import br.ifba.inf011.cria.builder.controle.ControleBuilderTipo2;
import br.ifba.inf011.cria.builder.controle.ControleIF;
import br.ifba.inf011.cria.builder.controle.DescritorXMLBuilder;
import br.ifba.inf011.cria.builder.controle.Diretor;


public class Aplicacao {

	
	public void rodar2() throws Exception{
		
		Ambiente ambiente = new Ambiente();
		
		ControleBuilderTipo2 controleBuilder = new ControleBuilderTipo2();
		ControleIF controlador = controleBuilder.reset()
					   							.adicionarResfriador(30)
					   							.adicionarTermometroAlta(30)
					   							.adicionarSaidaErro(System.out)
					   							.adicionarSaidaPadrao(System.err)
					   							.build();
		
		while(true) {
			controlador.lerTemperatura(ambiente);
			controlador.modificar(ambiente);
			ambiente.randomizar();
			Thread.sleep(100);
		}
		
	}
	
	
	public void rodar() throws Exception{
		
		Ambiente ambiente = new Ambiente();
		
		Diretor diretor = new Diretor();
		
		ControleBuilder controleBuilder = new ControleBuilder() ;
		diretor.setBuilder(controleBuilder);
		diretor.makeControleFaixa(26, 30, System.out, System.err);
		ControleIF controlador = controleBuilder.getControle();
		
		DescritorXMLBuilder descXMLBuilder = new DescritorXMLBuilder();
		diretor.setBuilder(descXMLBuilder);
		diretor.makeControleFaixa(26, 30, System.out, System.err);
		String descritor = descXMLBuilder.getDescritor();
		
		System.out.println(descritor);
		
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
