package br.ifba.inf011.estrut.proxy.adapter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LoggerStateChanged{
	
	private String fileName;
	
	
	public  LoggerStateChanged(String fileName) {
		this.fileName = fileName;
	}
	
	
	public void doLog(String from, String to) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(this.fileName, true));
		bw.append("[Logger] - STATECHANGED: " + from +  " ---> " + to + "\n");
		bw.close();
	}
	

}
