package br.ifba.inf011.comp.cor.handle;

public abstract class AbstractControleHandler implements ControleHandler {

	protected ControleHandler proximo;
	
	public AbstractControleHandler(ControleHandler proximo) {
		this.setProximo(proximo);
	};
	
	public AbstractControleHandler() {
		this(null);
	};	
	
	@Override
	public void setProximo(ControleHandler proximo) {
		this.proximo = proximo;
	}


}
