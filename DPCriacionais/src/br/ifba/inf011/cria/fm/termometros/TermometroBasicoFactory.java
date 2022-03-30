package br.ifba.inf011.cria.fm.termometros;

public class TermometroBasicoFactory extends TermometroFactory{

	public TermometroBasicoFactory() {
		
	}
	
	public TermometroBasicoFactory(double temperatura) {
		super(temperatura);
	}

	@Override
	public TermometroIF criaTermometro() {
		return new TermometroBasico();
	}
	
	

}
