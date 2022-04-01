package br.ifba.inf011.cria.afm.atuadores;

public class EstabilizadorFactory extends AtuadorFactory{

	public EstabilizadorFactory() {
		
	}
	
	public EstabilizadorFactory(double temperaturaMinima, double temperaturaMaxima) {
		super(temperaturaMinima, temperaturaMaxima);
	}

	@Override
	public AtuadorIF criaAtuador() {
		return new Estabilizador(this.temperaturaMinima, this.temperaturaMaxima);
	}
	
	

}