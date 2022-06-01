package br.ifba.inf011.estrut.adapter.subscriber;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import br.ifba.inf011.estrut.adapter.StateChangedEvent;
import br.ifba.inf011.estrut.adapter.StateChangedListener;

public class FileLogStateChanged implements StateChangedListener{
	
	private String fileName;
	
	
	public  FileLogStateChanged(String fileName) {
		this.fileName = fileName;
	}
	
	
	public void writeRegister(StateChangedEvent event) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(this.fileName, true));
		bw.append("STATECHANGED: " + event.getFrom() +  " ---> " + event.getTo() + "\n");
		bw.close();
	}


	@Override
	public void stateChange(StateChangedEvent event) {
		try {
			this.writeRegister(event);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
