package br.ifba.inf011.cria.prototype;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.ifba.inf011.cria.prototype.termometro.TermometroAlta;
import br.ifba.inf011.cria.prototype.termometro.TermometroFaixa;
import br.ifba.inf011.cria.prototype.termometro.TermometroIF;
import br.ifba.inf011.cria.prototype.controle.Builder;
import br.ifba.inf011.cria.prototype.controle.Controle;
import br.ifba.inf011.cria.prototype.controle.ControleBuilder;
import br.ifba.inf011.cria.prototype.controle.ControleBuilderTipo2;
import br.ifba.inf011.cria.prototype.controle.ControleIF;
import br.ifba.inf011.cria.prototype.controle.DescritorXMLBuilder;
import br.ifba.inf011.cria.prototype.controle.Diretor;


public class Aplicacao {

	public void rodar4() throws Exception{
		
		Ambiente ambiente = new Ambiente();
		
		CatalogoControles catalogo = new CatalogoControles();
		
		ControleIF controlador2 = catalogo.get("Controle Alta Padrão");
		
		
		
		while(true) {
			controlador2.lerTemperatura(ambiente);
			controlador2.modificar(ambiente);
			ambiente.randomizar();
			Thread.sleep(100);
		}
		
	}	
	
	
	public void rodar3() throws Exception{
		TermometroIF termometro = new TermometroAlta(40);
		TermometroFaixa termometro2 = (TermometroFaixa) termometro.clonar();
		System.out.println(termometro);
		System.out.println(termometro2);
	}
	
	
	public void rodar2() throws Exception{
		
		Ambiente ambiente = new Ambiente();
		
		ControleBuilderTipo2 controleBuilder = new ControleBuilderTipo2();
		Controle controlador = (Controle) controleBuilder.reset()
					   							.adicionarEstabilizador(26, 28)
					   							.adicionarTermometroFaixa(26, 28)
					   							.adicionarSaidaErro(System.out)
					   							.adicionarSaidaPadrao(System.err)
					   							.build();
		
		Controle controlador2 =  (Controle) controlador.clonar();
		
		controlador.termometro.setTemperaturaMaxima(100);
		
		
		
		
		while(true) {
			controlador2.lerTemperatura(ambiente);
			controlador2.modificar(ambiente);
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

		
		diretor.makeControleAlta(30, System.out, System.err);
		String descritor2 = descXMLBuilder.getDescritor();
		
		
		System.out.println(descritor);
		
		System.out.println(descritor2);
		
		while(true) {
			controlador.lerTemperatura(ambiente);
			controlador.modificar(ambiente);
			ambiente.randomizar();
			Thread.sleep(100);
		}
		
	}

	
	
	public static void main(String[] args) throws Exception {
		(new Aplicacao()).rodar4();
	}

}
