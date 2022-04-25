package br.ifba.inf011.cria.singleton.controle;

import br.ifba.inf011.cria.singleton.Ambiente;
import br.ifba.inf011.cria.singleton.Prototype;
import br.ifba.inf011.cria.singleton.atuador.AtuadorIF;
import br.ifba.inf011.cria.singleton.termometro.TermometroIF;

public class Controle implements ControleIF{

	
	public TermometroIF termometro;
	public AtuadorIF atuador;
	
	
	public Controle(TermometroIF termometro, 
					AtuadorIF atuador) {
		this.termometro = termometro;
		this.atuador = atuador;
	}
	
	
	public Controle(Controle controle) {
		this.termometro = (TermometroIF) controle.termometro.clonar();
		this.atuador = (AtuadorIF) controle.atuador.clonar();
	}


	@Override
	public void lerTemperatura(Ambiente ambiente) throws Exception {
		this.termometro.lerTemperatura(ambiente);
	}

	@Override
	public void modificar(Ambiente ambiente) {
		this.atuador.modificar(ambiente);
	}


	@Override
	public Prototype clonar() {
		return new Controle(this);
	}

}
