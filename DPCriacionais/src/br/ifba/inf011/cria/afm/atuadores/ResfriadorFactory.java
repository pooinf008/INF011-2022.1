package br.ifba.inf011.cria.afm.atuadores;

public class ResfriadorFactory extends AtuadorFactory{

	public ResfriadorFactory() {
		
	}
	
	public ResfriadorFactory(double temperaturaMinima, double temperaturaMaxima) {
		super(temperaturaMinima, temperaturaMaxima);
	}

	@Override
	public AtuadorIF criaAtuador() {
		return new Resfriador(this.temperaturaMaxima);
	}
	
	

}