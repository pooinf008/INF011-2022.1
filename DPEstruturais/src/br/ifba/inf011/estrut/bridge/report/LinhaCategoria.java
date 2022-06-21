package br.ifba.inf011.estrut.bridge.report;

public class LinhaCategoria extends AbstractDecoratorLinha implements Linha{

	public LinhaCategoria(Linha decorator) {
		super(decorator);
	}

	@Override
	public String content() {
		CategoriaServico categoria = new CategoriaServico();
		char cat = categoria.getCategoria(this.getEnergia(), this.getSetpoint(), this.getTemperatura());
		return this.decorator().content() + " " + cat;
	}

}
