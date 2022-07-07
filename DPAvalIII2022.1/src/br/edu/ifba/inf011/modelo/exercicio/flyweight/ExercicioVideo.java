package br.edu.ifba.inf011.modelo.exercicio.flyweight;

import java.io.PrintStream;

public class ExercicioVideo {
	private String descricao;
	private String video = "[FLY - VIDEO DO EXERCICIO ";
	
	public ExercicioVideo(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void reproduzir(PrintStream out, int qtde, int numRepeticoes) {
		out.println(video + this.descricao +"] / " + qtde + " x " + numRepeticoes);
	}	

}
