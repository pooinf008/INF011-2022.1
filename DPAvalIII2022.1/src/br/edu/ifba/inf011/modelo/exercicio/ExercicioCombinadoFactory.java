package br.edu.ifba.inf011.modelo.exercicio;

public interface ExercicioCombinadoFactory{
	public ExercicioCombinadoFactory clear();
	public ExercicioCombinadoFactory descricao(String descricao);
	public ExercicioCombinadoFactory withExercicio(Exercicio exercicio);	
	public Exercicio build(String id);
}
