package br.ifba.inf011.cria.afm.termometros;

public class TermometroBasicoFactory extends TermometroFactory{

	public TermometroBasicoFactory() {
		
	}
	
	public TermometroBasicoFactory(double temperaturaMinima, double temperaturaMaxima) {
		super(temperaturaMinima, temperaturaMaxima);
	}

	@Override
	public TermometroIF criaTermometro() {
		return new TermometroBasico();
	}
	
	

}
