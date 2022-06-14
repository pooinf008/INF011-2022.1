package br.ifba.inf011.estrut.flyweight.servico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClienteServico implements ServicoIF{

	public String ask(char categoria) throws IOException {
		Socket socket = new Socket("localhost", 123);
		System.out.println("Questionando....");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		bw.write("? " + categoria);
		bw.newLine();
		bw.flush();
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String descricao = br.readLine();
		socket.close();
		return descricao;
	}
	
	

	
}
