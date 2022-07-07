package br.edu.ifba.inf011.modelo.exercicio;

import java.util.ArrayList;
import java.util.List;

public class ExercicioCombinadoBuilder implements ExercicioCombinadoFactory{

	private String descricao;	
	private List<Exercicio> exercicios;	
	
	public static ExercicioCombinadoBuilder getFactory() {
		return new ExercicioCombinadoBuilder();
	}
	
	@Override
	public ExercicioCombinadoFactory clear() {
		this.descricao = null;
		this.exercicios = new ArrayList<Exercicio>();
		return this;
	}

	@Override
	public ExercicioCombinadoFactory descricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	@Override
	public ExercicioCombinadoFactory withExercicio(Exercicio exercicio) {
		this.exercicios.add(exercicio);
		return this;
	}

	@Override
	public Exercicio build(String id) {
		return new ExercicioCombinado(id, this.descricao, this.exercicios);
	}

}
