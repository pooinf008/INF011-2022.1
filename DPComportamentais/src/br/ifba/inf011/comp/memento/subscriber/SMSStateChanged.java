package br.ifba.inf011.comp.memento.subscriber;

import java.util.Random;

import br.ifba.inf011.comp.memento.StateChangedEvent;
import br.ifba.inf011.comp.memento.StateChangedListener;

public class SMSStateChanged implements Runnable, StateChangedListener{

	int id;
	
	public SMSStateChanged(int id) {
		this.id = id;
	}
	
	
	@Override
	public void run() {
		Random random = new Random();
		while(true) {
			System.out.println("Rodando o SMS State Changed #" + id);
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Thread.yield();
		}
	}


	@Override
	public void stateChange(StateChangedEvent event) {
		System.out.println("#" + id + " STATE CHANGED (" + event.getFrom() + 
						   " ----> " + event.getTo() + ")");
		
	}

}
