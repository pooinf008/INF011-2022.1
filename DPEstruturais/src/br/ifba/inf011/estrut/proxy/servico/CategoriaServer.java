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
		int id = 0;
		ServerSocket socket = new ServerSocket(123);
		System.out.println("Registrando....");
		while(true) {
			Socket cliente = socket.accept();
			(new Thread(new ThreadService(id++, cliente))).start();
		}
	}
	
	public static void main(String[] args) throws IOException {
		(new CategoriaServer()).run();
	}

}
