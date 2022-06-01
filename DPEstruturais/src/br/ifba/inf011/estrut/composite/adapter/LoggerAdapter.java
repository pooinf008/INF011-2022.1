package br.ifba.inf011.estrut.composite.adapter;

import java.io.IOException;

import br.ifba.inf011.estrut.composite.StateChangedEvent;
import br.ifba.inf011.estrut.composite.StateChangedListener;

public class LoggerAdapter implements StateChangedListener{

	private LoggerStateChanged logger;
	
	public LoggerAdapter(String name) {
		this.logger = new LoggerStateChanged(name);
	}
	
	public LoggerAdapter(LoggerStateChanged logger) {
		this.logger = logger;
	}	
	
	@Override
	public void stateChange(StateChangedEvent event) {
		try {
			this.logger.doLog(event.getFrom().toString(), 
							  event.getTo().toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
