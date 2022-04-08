package br.ifba.inf011.cria.builder.controle;

import br.ifba.inf011.cria.builder.Ambiente;

public class Controle implements ControleIF{

	
	private TermometroIF termometro;
	private AtuadorIF atuador;
	
	
	public Controle(TermometroIF termometro, 
					AtuadorIF atuador) {
		this.termometro = termometro;
		this.atuador = atuador;
	}
	
	
	@Override
	public void lerTemperatura(Ambiente ambiente) throws Exception {
		this.termometro.lerTemperatura(ambiente);
	}

	@Override
	public void modificar(Ambiente ambiente) {
		this.atuador.modificar(ambiente);
	}

}
