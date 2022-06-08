package br.ifba.inf011.estrut.proxy.servico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class CategoriaServer {
	
	
	public void run() throws IOException {
		ServerSocket socket = new ServerSocket(123);
		System.out.println("Registrando....");
		while(true) {
			Socket cliente = socket.accept();
			BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			String msg = br.readLine();
			StringTokenizer tokenizer = new StringTokenizer(msg, "? ");
			char chCategoria = tokenizer.nextToken().charAt(0);
			String descricao = "INDEFINIDO";
			switch(chCategoria) {
				case 'A' : descricao = "Situação Ótima"; break;
				case 'B' : descricao = "Alerta Azul"; break;
				case 'C' : descricao = "Alerta Amarelo"; break;
				case 'D' : descricao = "Alerta Laranja"; break;
				case 'E' : descricao = "Alerta Vermelho"; break;
			}
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream()));
			bw.write(descricao);
			bw.newLine();
			bw.flush();
		}
	}
	
	public static void main(String[] args) throws IOException {
		(new CategoriaServer()).run();
	}

}
