package br.ifba.inf011.comp.memento;

import br.ifba.inf011.comp.memento.estados.TipoEstado;

public class StateChangedEvent {
	private TipoEstado from;
	private TipoEstado to;
	
	public StateChangedEvent(TipoEstado from, TipoEstado to) {
		this.from = from;
		this.to = to;
	}

	public TipoEstado getFrom() {
		return from;
	}

	public TipoEstado getTo() {
		return to;
	}
	
	
	

}
