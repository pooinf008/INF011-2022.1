package br.ifba.inf011.cria.fm.termometros;

public class TermometroAltaFactory extends TermometroFactory{

	public TermometroAltaFactory() {
		
	}
	
	public TermometroAltaFactory(double temperaturaMinima, double temperaturaMaxima) {
		super(temperaturaMinima, temperaturaMaxima);
	}

	@Override
	public TermometroIF criaTermometro() {
		return new TermometroAlta(this.temperaturaMaxima);
	}
	
	

}