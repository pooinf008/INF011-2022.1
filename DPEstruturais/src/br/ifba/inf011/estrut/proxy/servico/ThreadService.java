package br.ifba.inf011.estrut.proxy.servico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.StringTokenizer;

public class ThreadService implements Runnable{

	private Socket cliente;
	private int id;
	
	
	public ThreadService(int id, Socket cliente) {
		this.cliente = cliente;
		this.id = id;
	}
	
	@Override
	public void run() {
		BufferedReader br;
		try {
			br = new BufferedReader(
					new	InputStreamReader(
							this.cliente.getInputStream()));
			BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(
							this.cliente.getOutputStream()));
			
			String msg = br.readLine();
			System.out.println("Mensagem recebida por " + this.id + msg);
			StringTokenizer tokenizer = new StringTokenizer(msg, "? ");
			char chCategoria = tokenizer.nextToken().charAt(0);
			String descricao = CategoriaDicionario.getDescricao(chCategoria);
			bw.write(descricao);
			bw.newLine();
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
