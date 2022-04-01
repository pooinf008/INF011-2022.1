package br.ifba.inf011.cria.fm.termometros;

public class TermometroFaixaFactory extends TermometroFactory{

	public TermometroFaixaFactory() {
		
	}
	
	public TermometroFaixaFactory(double temperaturaMinima, double temperaturaMaxima) {
		super(temperaturaMinima, temperaturaMaxima);
	}

	@Override
	public TermometroIF criaTermometro() {
		return new TermometroFaixa(this.temperaturaMinima, this.temperaturaMaxima);
	}
	
	

}