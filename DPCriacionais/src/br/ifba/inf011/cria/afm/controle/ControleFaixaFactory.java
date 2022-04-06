package br.ifba.inf011.cria.afm.controle;

public class ControleFaixaFactory extends ControleFactory {

	@Override
	public ControleIF criaControle() {
		return new ControleFaixa(this.temperaturaMinima, this.temperaturaMaxima);
	}

}
