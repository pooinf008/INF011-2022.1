package br.ifba.inf011.cria.afm.controle;

public class ControleAltaFactory extends ControleFactory {

	@Override
	public ControleIF criaControle() {
		return new ControleAlta(this.temperaturaMaxima);
	}

}
